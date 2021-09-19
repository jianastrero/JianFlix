package com.jianastrero.core.util

/**
 * Float Extension function to convert it to a String Currency
 *
 * @param currency The shown currency in the string. Default: None
 *
 * @author Jian James P. Astrero
 */
fun Float.toCurrency(currency: String = "") = "%.2f".format(this).let {
    if (currency.isEmpty()) {
        it
    } else {
        "$currency $it"
    }
}