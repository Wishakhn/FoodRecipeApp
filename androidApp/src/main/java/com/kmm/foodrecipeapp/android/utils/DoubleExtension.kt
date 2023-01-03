package com.kmm.foodrecipeapp.android.utils

import java.text.DecimalFormat


fun Double.roundToThreeDeci(): Double {
    return DecimalFormat("########0.000").format(this).toDouble()
}