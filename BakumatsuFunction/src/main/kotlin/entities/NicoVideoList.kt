package entities

import kotlinx.serialization.Serializable

@Serializable
data class NicoVideoList(
    val pagination: Pagination,
    val data: List<NicoVideo>
)
