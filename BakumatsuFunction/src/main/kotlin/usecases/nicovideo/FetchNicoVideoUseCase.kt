package usecases.nicovideo

interface FetchNicoVideoUseCase {
    fun execute(inputData: FetchNicoVideoInputData): FetchNicoVideoOutputData
}
