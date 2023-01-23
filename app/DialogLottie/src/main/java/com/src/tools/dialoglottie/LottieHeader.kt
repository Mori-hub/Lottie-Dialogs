package com.src.tools.dialoglottie

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import com.airbnb.lottie.LottieAnimationView
import java.util.*
import kotlin.system.exitProcess

@SuppressLint("SetTextI18n")

class LottieHeader(private val context: Context, smallOrLarge: String) {
    private val smallOrLarge: String = ""
    private val dialog = Dialog(context)

    private val dialogHeaderImage: LottieAnimationView
    private val dialogDescription: TextView
    private val dialogPositiveButton: TextView
    private val dialogNegativeButton: TextView
    private val dialogMiddleButton: TextView
    private var dialogCardView: CardView
    private val fPos: FrameLayout
    private val fNeg: FrameLayout
    private val fMid: FrameLayout
    private var tag = ".json"
    private val userGiven = arrayListOf<String>()
    private var applyToAll: Boolean = false

    init {

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        // dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        if (smallOrLarge == "large") {
            dialog.setContentView(R.layout.dialog_large)
            tag = "L.json"
        } else
            dialog.setContentView(R.layout.dialog_small)
        dialogHeaderImage =
            dialog.findViewById(R.id.lottieHeader) //MUSt Chang to Lottie
        dialogDescription = dialog.findViewById(R.id.description) as TextView
        dialogPositiveButton = dialog.findViewById(R.id.positiveButton)
        dialogNegativeButton = dialog.findViewById(R.id.negativeButton)
        dialogMiddleButton = dialog.findViewById(R.id.middleButton)
        dialogCardView = dialog.findViewById(R.id.mainCard)

        fPos = dialog.findViewById(R.id.fPosetive)
        fNeg = dialog.findViewById(R.id.fNegative)
        fMid = dialog.findViewById(R.id.fMiddel)

        clean()

    }

    fun dialogTheme(
        applyToAll: Boolean,
        mainBackColor: String,
        dscBackColor: String,
        desTextColor: String,
        buttonsColor: String,
        buttonTextColor: String
    ) {
        this.applyToAll = applyToAll
        userGiven.add(mainBackColor)
        userGiven.add(dscBackColor)
        userGiven.add(desTextColor)
        userGiven.add(buttonsColor)
        userGiven.add(buttonTextColor)
        applyTheme()

    }

    private fun applyTheme() {
        if (applyToAll) {
            dialogCardView.setCardBackgroundColor(Color.parseColor(userGiven[0]))

            dialogDescription.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor(userGiven[1]))
            dialogDescription.setTextColor(Color.parseColor(userGiven[2]))

            dialogPositiveButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor(userGiven[3]))
            dialogNegativeButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor(userGiven[3]))
            dialogMiddleButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor(userGiven[3]))

            dialogPositiveButton.setTextColor(Color.parseColor(userGiven[4]))
            dialogNegativeButton.setTextColor(Color.parseColor(userGiven[4]))
            dialogMiddleButton.setTextColor(Color.parseColor(userGiven[4]))
        }
    }


    fun sample(
        headerLottie: String,
        mainBackColor: String,
        description: String,
        titleOfPositiveButton: String,
        titleOfNegativeButton: String,
        titleOfMiddleButton: String,
        pBtnColor: String,
        nBtnColor: String,
        mBtnColor: String,
        textBtnColor: String,
        positiveButtonFunction: (() -> Unit)? = null,
        negativeButtonFunction: (() -> Unit)? = null,
        middleButtonFunction: (() -> Unit)? = null

    ) {
        headerLottie.let { dialogHeaderImage.setAnimation(it) }
        // Text Change
        dialogDescription.text = description
        titleOfPositiveButton.let { dialogPositiveButton.text = it }
        titleOfNegativeButton.let { dialogNegativeButton.text = it }
        titleOfMiddleButton.let { dialogMiddleButton.text = it }
        // Visibility
        fNeg.visibility = View.VISIBLE
        fPos.visibility = View.VISIBLE
        fMid.visibility = View.VISIBLE
        // Colors
        dialogCardView.setCardBackgroundColor(Color.parseColor(mainBackColor))
        dialogNegativeButton.backgroundTintList =
            ColorStateList.valueOf(Color.parseColor(nBtnColor))
        dialogPositiveButton.backgroundTintList =
            ColorStateList.valueOf(Color.parseColor(pBtnColor))
        dialogMiddleButton.backgroundTintList =
            ColorStateList.valueOf(Color.parseColor(mBtnColor))
        // Color Text
        dialogPositiveButton.setTextColor(Color.parseColor(textBtnColor))
        dialogNegativeButton.setTextColor(Color.parseColor(textBtnColor))
        dialogMiddleButton.setTextColor(Color.parseColor(textBtnColor))
        //On Click
        dialogPositiveButton.setOnClickListener {
            positiveButtonFunction?.invoke()
            dialog.dismiss()
            clean()
            applyTheme()
        }
        dialogNegativeButton.setOnClickListener {
            negativeButtonFunction?.invoke()
            dialog.dismiss()
            clean()
            applyTheme()
        }
        dialogMiddleButton.setOnClickListener {
            middleButtonFunction?.invoke()
            dialog.dismiss()
            clean()
            applyTheme()
        }

        dialog.show()
    }


    fun welcome(
        description: String,
        titleOfPositiveButton: String? = null, positiveButtonFunction: (() -> Unit)? = null
    ) {
        dialogMiddleButton.text = "Let's start"
        dialogHeaderImage.setAnimation("welcome$tag")

        // Colors


        if (!applyToAll) {
            dialogCardView.setCardBackgroundColor(Color.parseColor("#8FBDD3"))//
            dialogMiddleButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor("#82B1FF"))

        }


        dialogDescription.text = description
        titleOfPositiveButton?.let { dialogMiddleButton.text = it }
        fNeg.visibility = View.INVISIBLE
        fPos.visibility = View.INVISIBLE
        fMid.visibility = View.VISIBLE

        dialogMiddleButton.setOnClickListener {
            positiveButtonFunction?.invoke()
            delay(dialogMiddleButton) { dialog.dismiss() }
            clean()
        }

        dialog.show()

    }

    fun exit(
        description: String,
        titleOfPositiveButton: String? = null,
        titleOfNegativeButton: String? = null,
        positiveButtonFunction: (() -> Unit)? = null, activity: Activity
    ) {
        dialogPositiveButton.text = "Exit"
        dialogNegativeButton.text = "Back"
        dialogHeaderImage.setAnimation("exit$tag")
        // Colors
        if (!applyToAll) {
            dialogCardView.setCardBackgroundColor(Color.parseColor("#C69B7B"))
            dialogNegativeButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor("#826F66"))
            dialogPositiveButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor("#D49B54"))
        }
//        dialogMiddleButton.setBackgroundColor(android.R.color.holo_purple)

        dialogDescription.text = description
        titleOfPositiveButton?.let { dialogPositiveButton.text = it } ?: dialogPositiveButton.text
        titleOfNegativeButton?.let { dialogNegativeButton.text = it } ?: dialogNegativeButton.text
        fPos.visibility = View.VISIBLE
        dialogPositiveButton.setOnClickListener {
            Thread.setDefaultUncaughtExceptionHandler(DefaultExceptionHandler(activity));
            dialog.dismiss()
            if (positiveButtonFunction != null)
                positiveButtonFunction.invoke()
            else activity.finish()

            // delay(dialogPositiveButton) { dialog.dismiss() }
            clean()
        }
        fNeg.visibility = View.VISIBLE

        dialogNegativeButton.setOnClickListener {
            delay(dialogNegativeButton) { dialog.dismiss() }
            clean()
        }

        dialog.show()
    }

    fun rate(
        description: String,
        titleOfPositiveButton: String? = null,
        titleOfNegativeButton: String? = null,
        positiveButtonFunction: (() -> Unit)? = null
    ) {
        dialogPositiveButton.text = "Rate Now"
        dialogNegativeButton.text = "Maybe Later"
        dialogHeaderImage.setAnimation("rate$tag")
        // Colors
        if (!applyToAll) {
            dialogCardView.setCardBackgroundColor(Color.parseColor("#464E2E"))
            dialogNegativeButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor("#A1B57D"))
            dialogPositiveButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor("#F1D00A"))
        }

        dialogDescription.text = description
        titleOfPositiveButton?.let { dialogPositiveButton.text = it } ?: dialogPositiveButton.text
        titleOfNegativeButton?.let { dialogNegativeButton.text = it } ?: dialogNegativeButton.text
        dialogPositiveButton.setOnClickListener {
            positiveButtonFunction?.invoke()
            delay(dialogPositiveButton) { dialog.dismiss() }
            clean()
        }
        fNeg.visibility = View.VISIBLE
        fPos.visibility = View.VISIBLE
        dialogNegativeButton.setOnClickListener {
            delay(dialogNegativeButton) { dialog.dismiss() }
            clean()
        }

        dialog.show()
        clean()
    }

    fun info(
        description: String,
        titleOfPositiveButton: String? = null,
        positiveButtonFunction: (() -> Unit)? = null
    ) {
        dialogPositiveButton.text = "Got it"
        dialogHeaderImage.setAnimation("info$tag")
        // Colors
        if (!applyToAll) {
            dialogCardView.setCardBackgroundColor(Color.parseColor("#7897AB"))

            dialogMiddleButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor("#D885A3"))
        }
        dialogDescription.text = description
        titleOfPositiveButton.let { dialogMiddleButton.text = it }
        fNeg.visibility = View.INVISIBLE
        fPos.visibility = View.INVISIBLE
        fMid.visibility = View.VISIBLE
        dialogMiddleButton.setOnClickListener {
            positiveButtonFunction?.invoke()
            delay(dialogMiddleButton) { dialog.dismiss() }
            clean()
        }

        dialog.show()
    }

    fun warning(
        description: String,
        titleOfPositiveButton: String? = null,
        titleOfNegativeButton: String? = null,
        positiveButtonFunction: (() -> Unit)? = null
    ) {
        dialogPositiveButton.text = "Accept"
        dialogNegativeButton.text = "Ignore"
        dialogHeaderImage.setAnimation("warning$tag")
        // Colors
        if (!applyToAll) {
            dialogCardView.setCardBackgroundColor(Color.parseColor("#FFBD35"))
            dialogNegativeButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor("#A1B57D"))
            dialogPositiveButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor("#FF6464"))
        }

        dialogDescription.text = description
        titleOfPositiveButton?.let { dialogPositiveButton.text = it } ?: dialogPositiveButton.text
        titleOfNegativeButton?.let { dialogNegativeButton.text = it } ?: dialogNegativeButton.text
        dialogPositiveButton.setOnClickListener {
            positiveButtonFunction?.invoke()
            delay(dialogPositiveButton) { dialog.dismiss() }
            clean()
        }
        fNeg.visibility = View.VISIBLE
        fPos.visibility = View.VISIBLE
        dialogNegativeButton.setOnClickListener {
            delay(dialogNegativeButton) { dialog.dismiss() }
            clean()
        }

        dialog.show()
    }

    fun success(
        description: String,
        titleOfPositiveButton: String? = null,
        titleOfNegativeButton: String? = null,
        positiveButtonFunction: (() -> Unit)? = null
    ) {
        dialogPositiveButton.text = "Accept"
        dialogNegativeButton.text = "More about"
        dialogHeaderImage.setAnimation("success$tag")
        // Colors
        if (!applyToAll) {
            dialogCardView.setCardBackgroundColor(Color.parseColor("#E7ED9B"))
            dialogNegativeButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor("#FAEEE7"))
            dialogPositiveButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor("#91C483"))
        }

        dialogDescription.text = description
        titleOfPositiveButton?.let { dialogPositiveButton.text = it } ?: dialogPositiveButton.text
        titleOfNegativeButton?.let { dialogNegativeButton.text = it } ?: dialogNegativeButton.text
        dialogPositiveButton.setOnClickListener {
            positiveButtonFunction?.invoke()
            delay(dialogPositiveButton) { dialog.dismiss() }
            clean()
        }
        fNeg.visibility = View.VISIBLE
        fPos.visibility = View.VISIBLE
        dialogNegativeButton.setOnClickListener {
            delay(dialogNegativeButton) { dialog.dismiss() }
            clean()
        }

        dialog.show()
    }


    fun del(
        description: String,
        titleOfPositiveButton: String? = null,
        titleOfNegativeButton: String? = null,
        positiveButtonFunction: (() -> Unit)? = null
    ) {
        dialogPositiveButton.text = "Delete it"
        dialogNegativeButton.text = "Ignore"
        dialogHeaderImage.setAnimation("clean$tag")
        // Colors
        if (!applyToAll) {
            dialogCardView.setCardBackgroundColor(Color.parseColor("#F47F3F"))
            dialogNegativeButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor("#A3DA8D"))
            dialogPositiveButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor("#FF5959"))
        }

        dialogDescription.text = description
        titleOfPositiveButton?.let { dialogPositiveButton.text = it } ?: dialogPositiveButton.text
        titleOfNegativeButton?.let { dialogNegativeButton.text = it } ?: dialogNegativeButton.text
        dialogPositiveButton.setOnClickListener {
            positiveButtonFunction?.invoke()
            delay(dialogPositiveButton) { dialog.dismiss() }
            clean()
        }
        fNeg.visibility = View.VISIBLE
        fPos.visibility = View.VISIBLE
        dialogNegativeButton.setOnClickListener {
            delay(dialogNegativeButton) { dialog.dismiss() }
            clean()
        }

        dialog.show()
    }

    private fun clean() {
        if (!dialog.isShowing) {
            dialogMiddleButton.text = ""
            dialogPositiveButton.text = ""
            dialogNegativeButton.text = ""

            if (fMid.isVisible) fMid.visibility = View.INVISIBLE
        }
    }

    private fun delay(whichView: View, doWhat: (() -> Unit)? = null) {

        whichView.startAnimation(
            AnimationUtils.loadAnimation(
                context,
                R.anim.bounce
            )
        )
        Handler(Looper.getMainLooper()).postDelayed({
            doWhat?.invoke()

            if (fMid.isVisible) fMid.visibility = View.INVISIBLE
        }, 600)

    }

    class DefaultExceptionHandler(var activity: Activity) : Thread.UncaughtExceptionHandler {
        override fun uncaughtException(thread: Thread, ex: Throwable) {
            Log.d("ERROR Dialog Lottie", "---------" + ex.message)
            Log.d("ERROR Dialog Lottie", "--------" + ex.cause)
            Log.d("ERROR Dialog Lottie", "--------" + Arrays.toString(ex.stackTrace))
            activity.finish()
            exitProcess(0)
        }
    }
}