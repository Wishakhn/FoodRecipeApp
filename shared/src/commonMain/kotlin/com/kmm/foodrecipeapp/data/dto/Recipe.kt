package com.kmm.foodrecipeapp.data.dto

import com.kmm.foodrecipeapp.base.network.BaseApiResponse
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Recipe(
    @SerialName("approved_at")
    val approvedAt: Int? = null,
    @SerialName("aspect_ratio")
    val aspectRatio: String? = null,
    @SerialName("beauty_url")
    val beautyUrl: String? = null,
    @SerialName("brand_id")
    val brandId: Int? = null,
    @SerialName("canonical_id")
    val canonicalId: String? = null,
    @SerialName("cook_time_minutes")
    val cookTimeMinutes: Int? = null,
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
    @SerialName("is_one_top")
    val isOneTop: Boolean? = null,
    @SerialName("is_shoppable")
    val isShoppable: Boolean? = null,
    @SerialName("keywords")
    val keywords: String? = null,
    @SerialName("language")
    val language: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("num_servings")
    val numServings: Int? = null,
    @SerialName("nutrition_visibility")
    val nutritionVisibility: String? = null,
    @SerialName("original_video_url")
    val originalVideoUrl: String? = null,
    @SerialName("prep_time_minutes")
    val prepTimeMinutes: Int? = null,
    @SerialName("promotion")
    val promotion: String? = null,
    @SerialName("seo_title")
    val seoTitle: String? = null,
    @SerialName("servings_noun_plural")
    val servingsNounPlural: String? = null,
    @SerialName("servings_noun_singular")
    val servingsNounSingular: String? = null,
    @SerialName("show_id")
    val showId: Int? = null,
    @SerialName("slug")
    val slug: String? = null,
    @SerialName("thumbnail_alt_text")
    val thumbnailAltText: String? = null,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String? = null,
    @SerialName("tips_and_ratings_enabled")
    val tipsAndRatingsEnabled: Boolean? = null,
    @SerialName("topics")
    val topics: List<Topic?>? = null,
    @SerialName("total_time_minutes")
    val totalTimeMinutes: Int? = null,
    @SerialName("updated_at")
    val updatedAt: Int? = null,
    @SerialName("video_ad_content")
    val videoAdContent: String? = null,
    @SerialName("video_id")
    val videoId: Int? = null,
    @SerialName("video_url")
    val videoUrl: String? = null,
    @SerialName("yields")
    val yields: String? = null
) : BaseApiResponse()


