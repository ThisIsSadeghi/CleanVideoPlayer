package com.sadeghirad.androidcore.ext

import android.view.View
import android.view.ViewGroup
import com.sadeghirad.core.isNegative

fun View.makeVisible() {
    this.visibility = View.VISIBLE
}

fun View.makeInvisible() {
    this.visibility = View.INVISIBLE
}

fun View.makeGone() {
    this.visibility = View.GONE
}

fun View.makeHeightAndWidthMatchParent() {
    this.layoutParams.apply {
        height = ViewGroup.LayoutParams.MATCH_PARENT
        width = ViewGroup.LayoutParams.MATCH_PARENT
    }.also {
        this.layoutParams = it
    }
}

fun View.setHeightPX(h: Int) {
    this.layoutParams.apply {
        height = h
    }.also {
        this.layoutParams = it
    }
}

fun View.setWidthPX(w: Int) {
    this.layoutParams.apply {
        width = w
    }.also {
        this.layoutParams = it
    }
}

fun View.setHeightDP(h: Int) {
    this.layoutParams.apply {
        height = if (h.isNegative()) h else h.dp()
    }.also {
        this.layoutParams = it
    }
}

fun View.setWidthDP(w: Int) {
    this.layoutParams.apply {
        width = if (w.isNegative()) w else w.dp()
    }.also {
        this.layoutParams = it
    }
}

fun View.setHeightAndWidthPX(h: Int, w: Int) {
    this.layoutParams.apply {
        height = h
        width = w
    }.also {
        this.layoutParams = it
    }
}

fun View.setHeightAndWidthDP(h: Int, w: Int) {
    this.layoutParams.apply {
        //isNegative() check is added because of MATCH_PARENT, WRAP_CONTENT and FILL_PARENT
        height = if (h.isNegative()) h else h.dp()
        width = if (w.isNegative()) w else w.dp()
    }.also {
        this.layoutParams = it
    }
}