package com.kmm.foodrecipeapp.data.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Topic(
    @SerialName("name")
    val name: String? = null,
    @SerialName("slug")
    val slug: String? = null
)

@kotlinx.serialization.Serializable
data class Brand(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("image_url")
    val imageUrl: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("slug")
    val slug: String? = null
)

@kotlinx.serialization.Serializable
data class Compilation(
    @SerialName("approved_at")
    val approvedAt: Int? = null,
    @SerialName("aspect_ratio")
    val aspectRatio: String? = null,
    @SerialName("canonical_id")
    val canonicalId: String? = null,
    @SerialName("country")
    val country: String? = null,
    @SerialName("created_at")
    val createdAt: Int? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("draft_status")
    val draftStatus: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("is_shoppable")
    val isShoppable: Boolean? = null,
    @SerialName("language")
    val language: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("promotion")
    val promotion: String? = null,
    @SerialName("show")
    val show: List<Show?>? = null,
    @SerialName("slug")
    val slug: String? = null,
    @SerialName("thumbnail_alt_text")
    val thumbnailAltText: String? = null,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String? = null,
    @SerialName("video_id")
    val videoId: Int? = null,
    @SerialName("video_url")
    val videoUrl: String? = null
)

@kotlinx.serialization.Serializable
data class Show(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null
)

@kotlinx.serialization.Serializable
data class Credit(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("image_url")
    val imageUrl: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("slug")
    val slug: String? = null,
    @SerialName("type")
    val type: String? = null
)

@kotlinx.serialization.Serializable
data class Instruction(
    @SerialName("appliance")
    val appliance: String? = null,
    @SerialName("display_text")
    val displayText: String? = null,
    @SerialName("end_time")
    val endTime: Int? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("position")
    val position: Int? = null,
    @SerialName("start_time")
    val startTime: Int? = null,
    @SerialName("temperature")
    val temperature: Int? = null
)

@kotlinx.serialization.Serializable
data class Nutrition(
    @SerialName("calories")
    val calories: Int? = null,
    @SerialName("carbohydrates")
    val carbohydrates: Int? = null,
    @SerialName("fat")
    val fat: Int? = null,
    @SerialName("fiber")
    val fiber: Int? = null,
    @SerialName("protein")
    val protein: Int? = null,
    @SerialName("sugar")
    val sugar: Int? = null,
    @SerialName("updated_at")
    val updatedAt: String? = null
)

@kotlinx.serialization.Serializable
data class Rendition(
    @SerialName("aspect")
    val aspect: String? = null,
    @SerialName("bit_rate")
    val bitRate: Int? = null,
    @SerialName("container")
    val container: String? = null,
    @SerialName("content_type")
    val contentType: String? = null,
    @SerialName("duration")
    val duration: Int? = null,
    @SerialName("file_size")
    val fileSize: Int? = null,
    @SerialName("height")
    val height: Int? = null,
    @SerialName("maximum_bit_rate")
    val maximumBitRate: Int? = null,
    @SerialName("minimum_bit_rate")
    val minimumBitRate: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("poster_url")
    val posterUrl: String? = null,
    @SerialName("url")
    val url: String? = null,
    @SerialName("width")
    val width: Int? = null
)


@kotlinx.serialization.Serializable
data class Section(
    @SerialName("components")
    val components: List<Component?>? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("position")
    val position: Int? = null
)

@kotlinx.serialization.Serializable
data class Component(
    @SerialName("extra_comment")
    val extraComment: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("ingredient")
    val ingredient: Ingredient? = null,
    @SerialName("measurements")
    val measurements: List<Measurement?>? = null,
    @SerialName("position")
    val position: Int? = null,
    @SerialName("raw_text")
    val rawText: String? = null
)

@kotlinx.serialization.Serializable
data class Ingredient(
    @SerialName("created_at")
    val createdAt: Int? = null,
    @SerialName("display_plural")
    val displayPlural: String? = null,
    @SerialName("display_singular")
    val displaySingular: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("updated_at")
    val updatedAt: Int? = null
)

@kotlinx.serialization.Serializable
data class Measurement(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("quantity")
    val quantity: String? = null,
    @SerialName("unit")
    val unit: Unit? = null
)

@kotlinx.serialization.Serializable
data class Unit(
    @SerialName("abbreviation")
    val abbreviation: String? = null,
    @SerialName("display_plural")
    val displayPlural: String? = null,
    @SerialName("display_singular")
    val displaySingular: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("system")
    val system: String? = null
)

data class Tag(
    @SerialName("display_name")
    val displayName: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("type")
    val type: String? = null
)

data class TotalTimeTier(
    @SerialName("display_tier")
    val displayTier: String? = null,
    @SerialName("tier")
    val tier: String? = null
)

data class UserRatings(
    @SerialName("count_negative")
    val countNegative: Int? = null,
    @SerialName("count_positive")
    val countPositive: Int? = null,
    @SerialName("score")
    val score: Double? = null
)