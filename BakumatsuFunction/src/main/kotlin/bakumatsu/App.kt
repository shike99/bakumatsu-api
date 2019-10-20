package bakumatsu

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import controllers.NicoVideoController
import io.ktor.client.HttpClient
import org.koin.core.context.startKoin
import org.koin.dsl.module
import usecases.nicovideo.FetchNicoVideoInteractor
import usecases.nicovideo.FetchNicoVideoUseCase

/**
 * Handler for requests to Lambda function.
 */
class App : RequestHandler<GetRequest, GatewayResponse> {
    override fun handleRequest(request: GetRequest, context: Context?): GatewayResponse {
        val headers = mutableMapOf<String, String>()
        headers["Content-Type"] = "application/json"

        val fetchModule = module {
            single { HttpClient() }
            single { FetchNicoVideoInteractor(get()) as FetchNicoVideoUseCase }
        }

        startKoin { modules(fetchModule) }

        return when (request.path) {
            "/nico_video" -> {
                val response = NicoVideoController().call(request)
                GatewayResponse(response, headers, 200)
            }
            "/youtube" -> {
                GatewayResponse("{}", headers, 200)
            }
            else -> {
                GatewayResponse("{}", headers, 404)
            }
        }
    }
}
