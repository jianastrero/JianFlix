package com.jianastrero.jianflix.di

import com.jianastrero.core.util.Logger
import com.jianastrero.jianflix.BuildConfig
import org.koin.dsl.module

val appModule = module {
    single { Logger(BuildConfig.DEBUG, "JianDebug") }
}