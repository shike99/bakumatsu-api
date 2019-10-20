package infrastructures.nicovideo

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

class NicoVideoApi(private val client: HttpClient) {
    companion object {
        const val CHANNEL_NAME = "幕末志士"
        const val BAKUMATSU_CHANNEL_ID = 2613458
        const val LIMIT = 20
    }

    private val json = Json(JsonConfiguration.Stable)
    private val apiUrl = "https://api.search.nicovideo.jp/api/v2/video/contents/search"
    private val applicationName = "bakumatsu-api"
    private val fields = listOf(
        "contentId",
        "title",
        "description",
        "tags",
        "viewCounter",
        "mylistCounter",
        "lengthSeconds",
        "thumbnailUrl",
        "startTime",
        "commentCounter",
        "categoryTags",
        "genre"
    )

    fun call(offset: Int = 0): VideoListDTO {
        val response = runBlocking {
            client.get<String> {
                url(apiUrl)
                parameter("q", CHANNEL_NAME)
                parameter("targets", "lockTagsExact")
                parameter("fields", fields.joinToString(","))
                parameter("filters[channelId][0]", BAKUMATSU_CHANNEL_ID)
                parameter("_sort", "startTime")
                parameter("_offset", offset)
                parameter("_limit", LIMIT)
                parameter("_context", applicationName)
            }
        }
        client.close()
        return json.parse(VideoListDTO.serializer(), response)
    }
}
