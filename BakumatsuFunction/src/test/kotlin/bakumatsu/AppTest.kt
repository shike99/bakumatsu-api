package bakumatsu

import org.junit.Test
import kotlin.test.assertEquals

class AppTest {
    @Test
    fun successfulResponse() {
        val app = App()
        val result = app.handleRequest(null, null) as GatewayResponse
        assertEquals(result.statusCode, 200)
        assertEquals(result.headers["Content-Type"], "application/json")
    }
}
