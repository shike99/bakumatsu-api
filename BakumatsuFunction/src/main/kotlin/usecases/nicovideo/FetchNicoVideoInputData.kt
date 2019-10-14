package usecases.nicovideo

import infrastructures.nicovideo.NicoVideoApi

class FetchNicoVideoInputData(private val nullablePage: Int?) {
    val page = nullablePage ?: 1
    val offset = if (page <= 1) {
        0
    } else {
        NicoVideoApi.LIMIT * (page - 1)
    }
}