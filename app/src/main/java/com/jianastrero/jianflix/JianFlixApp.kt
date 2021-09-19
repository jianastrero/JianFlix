package com.jianastrero.jianflix

import android.app.Application
import com.jianastrero.core.util.Logger
import com.jianastrero.di.movieModule
import com.jianastrero.jianflix.di.appModule
import com.jianastrero.jianflix.di.databaseModule
import com.jianastrero.jianflix.di.networkModule
import com.jianastrero.jianflix.di.viewModelModules
import com.jianastrero.movie_use_case.di.movieUseCaseModule
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
            modules(
                appModule,
                databaseModule,
                networkModule,
                movieModule,
                movieUseCaseModule,
                viewModelModules
            )
        }

        // Initialize Logger
        val logger = get<Logger>()
        logger.init()
    }
}