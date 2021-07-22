package com.example.bdkjvm

import org.bitcoindevkit.bdkjni.Lib
import org.bitcoindevkit.bdkjni.Network
import org.bitcoindevkit.bdkjni.WalletConstructor
import org.bitcoindevkit.bdkjni.WalletPtr
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.nio.file.Paths

object Wallet {
    
    init {
        System.loadLibrary("bdk_jni")
    }

    val log: Logger = LoggerFactory.getLogger(Wallet::class.java)

    private lateinit var wallet: WalletPtr

    val descriptor =
        "wpkh([c258d2e4/84h/1h/0h]tpubDDYkZojQFQjht8Tm4jsS3iuEmKjTiEGjG6KnuFNKKJb5A6ZUCUZKdvLdSDWofKi4ToRCwb9poe1XdqfUnP4jaJjCB2Zwv11ZLgSbnZSNecE/0/*)"
    val change_descriptor =
        "wpkh([c258d2e4/84h/1h/0h]tpubDDYkZojQFQjht8Tm4jsS3iuEmKjTiEGjG6KnuFNKKJb5A6ZUCUZKdvLdSDWofKi4ToRCwb9poe1XdqfUnP4jaJjCB2Zwv11ZLgSbnZSNecE/1/*)"

    fun newAddress(): String {
        wallet = Lib().constructor(
            WalletConstructor(
                "testnet",
                Network.regtest,
                getTestDataDir(),
                descriptor,
                null,
                "ssl://electrum.blockstream.info:60002",
                null
            )
        )
        Lib().sync(wallet)
        val address = Lib().get_new_address(wallet)
        return address
    }

    fun getTestDataDir(): String {
        //return Files.createTempDirectory("bdk-test").toString()
        return Paths.get(System.getProperty("java.io.tmpdir"), "bdk-test").toString()
    }
}
