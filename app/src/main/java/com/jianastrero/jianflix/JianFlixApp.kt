package com.jianastrero.jianflix

import android.app.Application
import com.jianastrero.core.util.Logger
import com.jianastrero.jianflix.di.appModule
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * The Application that JianFlix will use
 *
 * @author Jian James P. Astrero
 */
class JianFlixApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@JianFlixApp)
            modules(appModule)
        }

        // Initialize Logger
        val logger = get<Logger>()
        logger.init()
    }
}