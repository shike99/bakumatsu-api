package bakumatsu

class RequestContext {
    lateinit var accountId: String
    lateinit var apiId: String
    lateinit var httpMethod: String
    lateinit var identity: Any
    lateinit var path: String
    lateinit var requestId: String
    lateinit var requestTime: String
    lateinit var resourceId: String
    lateinit var resourcePath: String
    lateinit var stage: String
}
