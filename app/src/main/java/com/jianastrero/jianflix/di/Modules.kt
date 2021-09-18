package com.jianastrero.jianflix.di

import android.app.Application
import androidx.room.Room
import com.jianastrero.core.util.Logger
import com.jianastrero.jianflix.BuildConfig
import com.jianastrero.jianflix.JianFlixDatabase
import com.jianastrero.movie_data.local.MovieDao
import com.jianastrero.movie_data.remote.ITunesApi
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * App Module Instance for dependency injection
 *
 * @author Jian James P. Astrero
 */
val appModule = module {

    single { Logger(BuildConfig.DEBUG, "JianDebug") }

}

/**
 * Database Module Instance for dependency injection
 *
 * @author Jian James P. Astrero
 */
val databaseModule = module {

    fun provideJianFlixDatabase(application: Application): JianFlixDatabase =
        Room.databaseBuilder(
            application.applicationContext,
            JianFlixDatabase::class.java,
            "jianflix_db"
        ).build()

    fun provideMovieDao(db: JianFlixDatabase): MovieDao =
        db.movieDao()

    single { provideJianFlixDatabase(androidApplication()) }

    single { provideMovieDao(get()) }
}

/**
 * Network Module Instance for dependency injection
 *
 * @author Jian James P. Astrero
 */
val networkModule = module {

    fun provideOkhttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .build()

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun provideITunesApi(retrofit: Retrofit): ITunesApi =
        retrofit.create(ITunesApi::class.java)

    single { provideOkhttpClient() }

    single { provideRetrofit(get()) }

    single { provideITunesApi(get()) }

}