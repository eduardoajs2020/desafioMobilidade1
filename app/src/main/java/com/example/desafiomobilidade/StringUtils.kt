package com.example.desafiomobilidade

object StringUtils {

    fun isAlphanumeric(text: String): Boolean {
        return text.matches(Regex("[a-zA-Z0-9]+"))
    }

    fun isValidLength(text: String, min: Int, max: Int): Boolean {
        return text.length in min..max
    }

}
