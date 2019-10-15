package entities

import kotlinx.serialization.Serializable

@Serializable
data class NicoVideo(
    val id: String,
    val title: String,
    val description: String,
    val playedCount: Int,
    val myListCount: Int,
    val timeLengthSeconds: Int,
    val thumbnailUrl: String,
    val uploadedAt: String,
    val commentCount: Int,
    val categoryTags: String,
    val tags: List<String>,
    val genre: String,
    val contentUrl: String
)
