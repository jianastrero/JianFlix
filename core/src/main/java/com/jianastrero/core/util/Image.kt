package com.jianastrero.core.util

import java.io.File

fun String.iTunesArtworkUrlResize(newSize: Int): String {
    val file = File(this)
    val directory = file.parent
    val name = file.nameWithoutExtension
    val extension = file.extension

    val suffix = name.replace("\\d+x\\d+".toRegex(), "")

    val newFileName = "$directory/${newSize}x$newSize$suffix.$extension"

    newFileName.log()

    return newFileName
}