package com.abhishek.openinapp.utils

fun shortenText(text: String, maxLength: Int): String {
    return if (text.length > maxLength) {
        text.take(maxLength) + "..."
    } else {
        text
    }
}