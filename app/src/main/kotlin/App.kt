package com.example.bdkjvm

fun main() {
    printLogo()
    print("1st address".boldYellow())
    println(": ${Wallet.newAddress()}")
}
