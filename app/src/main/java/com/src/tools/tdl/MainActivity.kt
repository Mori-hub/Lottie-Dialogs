package com.src.tools.tdl

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.src.tools.dialoglottie.LottieHeader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Call Lib
        val lottieHeader = LottieHeader(this, "small")

        // If you need create your Theme!
        lottieHeader.dialogTheme(
            true,
            "black",
            "gray", "white",
            "#9B0000", "yellow"
        )

        // Welcome Dialog
        findViewById<Button>(R.id.button).setOnClickListener {
            lottieHeader.welcome("Hi, Welcome to our app! 😎")
        }
        // Exit Dialog
        findViewById<Button>(R.id.button2).setOnClickListener {
            lottieHeader.exit(
                "Goodbye, \n Do you want Exit now?",
                null, null, null, this
            )
        }
        // Rate Dialog
        findViewById<Button>(R.id.button3).setOnClickListener {
            lottieHeader.rate("Hi, Please Rate us! 😎", null, null, null)
        }
        // Information Dialog
        findViewById<Button>(R.id.button4).setOnClickListener {
            lottieHeader.info("This is an App just show Information! 😎", "info",
                { Toast.makeText(this, "Help me", Toast.LENGTH_SHORT).show() })
        }
        // Warning Dialog
        findViewById<Button>(R.id.button5).setOnClickListener {
            lottieHeader.warning("Attention, this is yellow area!", null, null, null)

        }

        // Delete Dialog
        findViewById<Button>(R.id.button6).setOnClickListener {
            lottieHeader.del("Do you want delete this file?", null, null, null)

        }

        // Success Dialog
        findViewById<Button>(R.id.button7).setOnClickListener {
            lottieHeader.success("The process is successful!", null, null, null)

        }

        // Sample Dialog - You can change all attributes
        findViewById<Button>(R.id.button8).setOnClickListener {
            lottieHeader.sample(
                "file.json",
                "#DFD3C3", "This is a sample you can generate as you want",
                "Got it", "Not Sure", "Help me ",
                "green", "red", "yellow", "black",
                { Toast.makeText(this, "Got", Toast.LENGTH_SHORT).show() },
                { Toast.makeText(this, "Not", Toast.LENGTH_SHORT).show() },
                { Toast.makeText(this, "Help me", Toast.LENGTH_SHORT).show() }
            )
        }


    }
}