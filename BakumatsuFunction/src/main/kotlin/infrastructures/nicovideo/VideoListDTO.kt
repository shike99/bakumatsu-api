package infrastructures.nicovideo

import kotlinx.serialization.Serializable

@Serializable
data class VideoListDTO(
        val data: List<VideoDTO>,
        val meta: MetaDTO
)