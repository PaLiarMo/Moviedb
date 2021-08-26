package com.paliarmo.moviedb.adapter

import com.paliarmo.moviedb.core.BasicData

interface AdapterBasicView<T: BasicData> {
    fun apply(data: T)
}