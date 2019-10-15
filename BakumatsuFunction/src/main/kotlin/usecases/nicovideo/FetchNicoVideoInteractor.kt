package usecases.nicovideo

import infrastructures.nicovideo.NicoVideoApi
import io.ktor.client.HttpClient

class FetchNicoVideoInteractor : FetchNicoVideoUseCase {
    override fun execute(inputData: FetchNicoVideoInputData): FetchNicoVideoOutputData {
        val client = HttpClient()
        val nicoVideoList = NicoVideoApi(client).call(inputData.offset)
        client.close()
        return FetchNicoVideoOutputData(nicoVideoList, inputData.page)
    }
}
