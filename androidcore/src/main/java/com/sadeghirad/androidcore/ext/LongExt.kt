package com.sadeghirad.androidcore.ext

import android.content.res.Resources

/**
 * Created by Ali Sadeghi
 * on 30,Mar,2021
 */
fun Long.px(): Int {
    return (this / Resources.getSystem().displayMetrics.density).toInt()
}

fun Long.dp(): Int {
    return (this * Resources.getSystem().displayMetrics.density).toInt()
}
