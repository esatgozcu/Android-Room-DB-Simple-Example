package com.esatgozcu.roomdbexample.utils

enum class PopupResultType {
    CLOSE, DELETE, UPDATE
}

data class PopupResult (
    val type: PopupResultType? = PopupResultType.CLOSE,
    val value: String? = "",
)
