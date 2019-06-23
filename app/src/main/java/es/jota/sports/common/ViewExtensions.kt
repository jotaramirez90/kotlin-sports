package es.jota.sports.common

import android.content.res.Resources
import android.util.TypedValue

fun Resources.dpToPx(value: Int): Int =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value.toFloat(), displayMetrics).toInt()