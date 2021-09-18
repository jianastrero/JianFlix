package com.jianastrero.jianflix.di

import com.jianastrero.core.util.Logger
import com.jianastrero.jianflix.BuildConfig
import org.koin.dsl.module

/**
 * App Module Instance for dependency injection on the whole app
 *
 * @author Jian James P. Astrero
 */
val appModule = module {
    single { Logger(BuildConfig.DEBUG, "JianDebug") }
}