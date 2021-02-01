package com.soten.androidstudio.imageloadsample.util

import java.util.*

fun ClosedRange<Int>.random() =
    Random().nextInt(endInclusive - start)