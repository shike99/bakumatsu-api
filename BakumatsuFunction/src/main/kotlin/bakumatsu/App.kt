package bakumatsu

import java.util.HashMap
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import kotlinx.coroutines.runBlocking

/**
 * Handler for requests to Lambda function.
 */
class App : RequestHandler<Any, GatewayResponse> {
    override fun handleRequest(input: Any?, context: Context?): GatewayResponse {
        val headers = HashMap<String, String>()
        headers.put("Content-Type", "application/json")
        val client = HttpClient()
        val response = runBlocking {
            client.get<String> {
                url("https://api.search.nicovideo.jp/api/v2/video/contents/search")
                parameter("q", "幕末志士")
                parameter("targets", "lockTagsExact")
                parameter("fields", "contentId,title,description,tags,viewCounter,mylistCounter,lengthSeconds,thumbnailUrl,startTime,commentCounter,categoryTags,genre")
                parameter("filters[channelId][0]", "2613458")
                parameter("_sort", "startTime")
                parameter("_limit", "20")
                parameter("_context", "bakumatsu-api")
            }
        }
        client.close()
        return GatewayResponse(response, headers, 200)
    }
}
