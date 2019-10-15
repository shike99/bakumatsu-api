package bakumatsu

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import controllers.NicoVideoController

/**
 * Handler for requests to Lambda function.
 */
class App : RequestHandler<GetRequest, GatewayResponse> {
    override fun handleRequest(request: GetRequest, context: Context?): GatewayResponse {
        val headers = mutableMapOf<String, String>()
        headers["Content-Type"] = "application/json"

        return when (request.path) {
            "/nico_video" -> {
                val response = NicoVideoController().call(request)
                GatewayResponse(response, headers, 200)
            }
            "/youtube" -> {
                GatewayResponse("{}", headers, 200)
            }
            else -> {
                GatewayResponse("{}", headers, 200)
            }
        }
    }
}
