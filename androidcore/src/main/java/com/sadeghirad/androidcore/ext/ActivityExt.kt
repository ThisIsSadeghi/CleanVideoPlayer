package com.sadeghirad.androidcore.ext

import android.app.Activity
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Build
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController

/**
 * Created by Ali Sadeghi
 * on 30,Mar,2021
 */

fun Activity.getDeviceOrientation() = this.resources?.configuration?.orientation

fun Activity.isPortrait() =
    this.resources?.configuration?.orientation == Configuration.ORIENTATION_PORTRAIT

fun Activity.isLandscape() =
    this.resources?.configuration?.orientation == Configuration.ORIENTATION_LANDSCAPE

fun Activity.showSystemUI() {
    window?.let { window ->

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(true)
            window.insetsController?.show(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        }
    }
}

fun Activity.hideSystemUI() {

    window?.let { window ->

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.let { insetsController ->
                insetsController.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                insetsController.systemBarsBehavior =
                    WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        }
    }
}

fun Activity.rotateScreenToLandscape() {
    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
}

fun Activity.rotateScreenToPortrait() {
    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
}