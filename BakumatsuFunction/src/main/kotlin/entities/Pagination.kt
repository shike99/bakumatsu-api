package entities

import kotlinx.serialization.Serializable

@Serializable
data class Pagination(
    val page: Int,
    val total: Int,
    val prev: Int?,
    val next: Int?,
    val count: Int
)
