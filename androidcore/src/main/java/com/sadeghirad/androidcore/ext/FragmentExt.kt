package com.sadeghirad.androidcore.ext

import androidx.fragment.app.Fragment


/**
 * Created by Ali Sadeghi
 * on 30,Mar,2021
 */

fun Fragment.getDeviceOrientation() = requireActivity().getDeviceOrientation()

fun Fragment.isPortrait() = requireActivity().isPortrait()

fun Fragment.isLandscape() = requireActivity().isLandscape()

fun Fragment.showSystemUI() = requireActivity().showSystemUI()

fun Fragment.hideSystemUI() = requireActivity().hideSystemUI()

fun Fragment.rotateScreenToLandscape() = requireActivity().rotateScreenToLandscape()

fun Fragment.rotateScreenToPortrait() = requireActivity().rotateScreenToPortrait()