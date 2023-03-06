package com.esatgozcu.roomdbexample.utils

import com.esatgozcu.roomdbexample.database.Car

enum class PopupResultType {
    CLOSE, DELETE, UPDATE
}

data class PopupResult (
    val type: PopupResultType? = PopupResultType.CLOSE,
    val car: Car?
)
