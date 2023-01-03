package com.kmm.foodrecipeapp.data.dto

import com.kmm.foodrecipeapp.base.network.BaseApiResponse
import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class DetailResponse(
    @SerialName("count")
    val count: Int? = null,
    @SerialName("results")
    val results: List<Recipe>? = null
) : BaseApiResponse()









