package com.jianastrero.core.util

fun Float.toCurrency(currency: String = "") = "%.2f".format(this).let {
    if (currency.isEmpty()) {
        it
    } else {
        "$currency $it"
    }
}