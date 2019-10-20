package usecases.nicovideo

import infrastructures.nicovideo.NicoVideoApi
import io.ktor.client.HttpClient

class FetchNicoVideoInteractor(private val client: HttpClient) : FetchNicoVideoUseCase {
    override fun execute(inputData: FetchNicoVideoInputData): FetchNicoVideoOutputData {
        val nicoVideoList = NicoVideoApi(client).call(inputData.offset)
        return FetchNicoVideoOutputData(nicoVideoList, inputData.page)
    }
}
