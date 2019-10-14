package usecases.nicovideo

import entities.NicoVideo
import entities.Pagination
import entities.NicoVideoList
import infrastructures.nicovideo.NicoVideoApi
import infrastructures.nicovideo.VideoListDTO
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

class FetchNicoVideoOutputData(private val nicoVideoList: VideoListDTO, private val page: Int) {
    private val pagination = Pagination(
        page = page,
        total = nicoVideoList.meta.totalCount,
        prev = if (page - 1 > 0) page - 1 else null,
        next = if (page * NicoVideoApi.LIMIT >= nicoVideoList.meta.totalCount) null else page + 1,
        count = nicoVideoList.data.size
    )
    private val data = nicoVideoList.data.map {
        NicoVideo(
            id = it.contentId,
            title = it.title,
            description = it.description.replace("<br>", "\\n"),
            playedCount = it.viewCounter,
            myListCount = it.mylistCounter,
            timeLengthSeconds = it.lengthSeconds,
            thumbnailUrl = it.thumbnailUrl,
            uploadedAt = it.startTime,
            commentCount = it.commentCounter,
            categoryTags = it.categoryTags,
            tags = it.tags.split(" "),
            genre = it.genre,
            contentUrl = "https://nico.ms/${it.contentId}"
        )
    }
    val videoList: String by lazy {
        val json = Json(JsonConfiguration.Stable)
        json.stringify(NicoVideoList.serializer(), NicoVideoList(pagination = pagination, data = data))
    }
}