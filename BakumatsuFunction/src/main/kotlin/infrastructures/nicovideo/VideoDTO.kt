package infrastructures.nicovideo

import kotlinx.serialization.Serializable

@Serializable
data class VideoDTO(
    val categoryTags: String,
    val commentCounter: Int,
    val contentId: String,
    val description: String,
    val genre: String,
    val lengthSeconds: Int,
    val mylistCounter: Int,
    val startTime: String,
    val tags: String,
    val thumbnailUrl: String,
    val title: String,
    val viewCounter: Int
)