package helloworld

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.IOException
import java.net.URL
import java.util.HashMap
import java.util.stream.Collectors
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler

/**
 * Handler for requests to Lambda function.
 */
class App : RequestHandler<Any, GatewayResponse> {

    override fun handleRequest(input: Any?, context: Context?): GatewayResponse {
        val headers = HashMap<String, String>()
        headers.put("Content-Type", "application/json")
        headers.put("X-Custom-Header", "application/json")
        try {
            val pageContents = this.getPageContents("https://checkip.amazonaws.com")
            val output = String.format("{ \"message\": \"hello world\", \"location\": \"%s\" }", pageContents)
            return GatewayResponse(output, headers, 200)
        } catch (e: IOException) {
            return GatewayResponse("{}", headers, 500)
        }

    }

    @Throws(IOException::class)
    private fun getPageContents(address: String): String {
        val url = URL(address)
        BufferedReader(InputStreamReader(url.openStream())).use({ br -> return br.lines().collect(Collectors.joining(System.lineSeparator())) })
    }
}
