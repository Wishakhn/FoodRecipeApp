package com.kmm.foodrecipeapp.base.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Transient

@kotlinx.serialization.Serializable
data class ApiError(
    @Transient
    var statusCode: Int = 0,
    @SerialName("error_description") var message: String = "",
    @SerialName("error") var actualCode: String = "-1"
)