package controllers

import bakumatsu.GetRequest
import org.koin.core.KoinComponent
import org.koin.core.inject
import usecases.nicovideo.FetchNicoVideoInputData
import usecases.nicovideo.FetchNicoVideoUseCase

class NicoVideoController : KoinComponent {
    fun call(request: GetRequest): String {
        val fetchNicoVideo by inject<FetchNicoVideoUseCase>()
        val params = FetchNicoVideoInputData(request.queryStringParameters?.page?.toInt())
        return fetchNicoVideo.execute(params).videoList
    }
}
