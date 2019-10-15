package infrastructures.nicovideo

import kotlinx.serialization.Serializable

@Serializable
data class MetaDTO(
    val id: String,
    val status: Int,
    val totalCount: Int
)
