package com.reynaldiwijaya.menghitungberatbadanideal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Respon ketika di klik
        btnHitung.onClick {

            var beratBadan = edtBeratBadan.text.toString()
            var tinggiBadan = edtTinggiBadan.text.toString()

            val kurus = 0.0
            val batasKurus = 18.4
            val normal = 18.5
            val batasNormal = 24.9
            val gemuk = 25.0
            val batasGemuk = 29.9


            if (beratBadan.toDoubleOrNull() != null && tinggiBadan.toDoubleOrNull() != null) {
                var process = beratBadan.toDouble() / (tinggiBadan.toDouble() * tinggiBadan.toDouble())

                when (process) {
                    in kurus..batasKurus -> {
                        txtHasil.text = "Kamu Kurus = $process"
                        alert ("Kamu Kurus"){
                            yesButton {
                            }
                        }.show()

                    }
                    in normal..batasNormal -> {
                        txtHasil.text = "Kamu Normal = $process"
                        alert ("Kamu Normal") {
                            yesButton {
                            }
                        }.show()
                    }
                    in gemuk..batasGemuk -> {
                        txtHasil.text = "Kamu Gemuk = $process"
                        alert ("Kamu Gemuk") {
                            yesButton {

                            }
                        }.show()
                    }
                    else -> {
                        txtHasil.text = "Kamu Obesitas = $process"
                    }
                }


            } else{
                alert ("Isi datanya terlebih dahulu") {
                    yesButton {

                    }
                }.show()
            }
        }
    }
}
