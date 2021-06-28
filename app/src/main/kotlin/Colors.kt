package com.example.bdkjvm

fun String.boldGreen(): String {
    return "\u001B[92;1m"+ this + "\u001B[0m"
}

fun String.green(): String {
    return "\u001B[92m"+ this + "\u001B[0m"
}

fun String.boldYellow(): String {
    return "\u001B[93;1m"+ this + "\u001B[0m"
}
