package com.example.kotlincustomalerts

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


                    Alert.confirmationAlertWithThreeButtons(this,"rectangle","My Alert",Color.BLACK,18f,"Title",Color.BLACK,"Submit","oval",Color.BLUE,3f,Color.WHITE,
                object : ConformListener {
                    override fun confirmed() {
                        super.confirmed()
                        Toast.makeText(applicationContext, "Lavaya", Toast.LENGTH_SHORT).show()
                    }
                },
                "Cancel","oval",
                        Color.BLUE,3f,Color.WHITE,
                object : ConformListener {
                    override fun confirmed() {
                        super.confirmed()
                        Toast.makeText(applicationContext, "Sree", Toast.LENGTH_SHORT).show()
                    }
                },
                "Delete","oval",Color.BLUE,3f,Color.WHITE,
                object : ConformListener {
                    override fun confirmed() {
                        super.confirmed()
                        Toast.makeText(applicationContext, "LavSree", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }

    }
