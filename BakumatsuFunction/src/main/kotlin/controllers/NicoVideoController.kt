package controllers

import bakumatsu.GetRequest
import usecases.nicovideo.FetchNicoVideoInputData
import usecases.nicovideo.FetchNicoVideoInteractor

class NicoVideoController {
    fun call(request: GetRequest): String {
        val inputData = FetchNicoVideoInputData(request.queryStringParameters?.page?.toInt())
        return FetchNicoVideoInteractor().execute(inputData).videoList
    }
}
