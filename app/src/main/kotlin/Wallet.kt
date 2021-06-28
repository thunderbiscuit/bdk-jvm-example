package com.example.bdkjvm

import org.bitcoindevkit.bdk.ElectrumConfig
import org.bitcoindevkit.bdk.MemoryConfig
import org.bitcoindevkit.bdk.Wallet

object Wallet {

    val desc =
        "wpkh([c258d2e4/84h/1h/0h]tpubDDYkZojQFQjht8Tm4jsS3iuEmKjTiEGjG6KnuFNKKJb5A6ZUCUZKdvLdSDWofKi4ToRCwb9poe1XdqfUnP4jaJjCB2Zwv11ZLgSbnZSNecE/0/*)"
    val change =
        "wpkh([c258d2e4/84h/1h/0h]tpubDDYkZojQFQjht8Tm4jsS3iuEmKjTiEGjG6KnuFNKKJb5A6ZUCUZKdvLdSDWofKi4ToRCwb9poe1XdqfUnP4jaJjCB2Zwv11ZLgSbnZSNecE/1/*)"

    fun newAddress(): String {
        val bcConfig = ElectrumConfig("ssl://electrum.blockstream.info:60002", null, 5, 30)
        val dbConfig = MemoryConfig()
        val wallet = Wallet(desc, change, bcConfig, dbConfig)
        val address = wallet.getAddress()
        return address
    }
}
