package bakumatsu

import kotlin.properties.Delegates

class GetRequest {
    lateinit var headers: Any
    lateinit var multiValueHeaders: Any
    lateinit var path: String
    var queryStringParameters: QueryStringParameters? = null
    var multiValueQueryStringParameters: MultiValueQueryStringParameters? = null
    lateinit var requestContext: RequestContext
}
