package com.sadeghirad.androidcore.ext

import android.content.res.Resources

/**
 * Created by Ali Sadeghi
 * on 30,Mar,2021
 */
fun Int.px(): Int {
    return (this / Resources.getSystem().displayMetrics.density).toInt()
}

fun Int.dp(): Int {
    return (this * Resources.getSystem().displayMetrics.density).toInt()
}
