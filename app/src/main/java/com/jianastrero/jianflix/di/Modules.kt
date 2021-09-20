package com.jianastrero.jianflix.di

import android.app.Application
import androidx.room.Room
import com.jianastrero.constant.NetworkConstants
import com.jianastrero.core.util.Logger
import com.jianastrero.jianflix.BuildConfig
import com.jianastrero.jianflix.JianFlixDatabase
import com.jianastrero.movie_data.local.MovieDao
import com.jianastrero.movie_data.remote.ITunesApi
import com.jianastrero.movie_detail.MovieDetailViewModel
import com.jianastrero.movie_main_list.MovieMainListViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

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
            .connectTimeout(NetworkConstants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(NetworkConstants.READ_TIMEOUT, TimeUnit.SECONDS)
            .also { builder ->
                if (BuildConfig.DEBUG) {
                    builder.addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }
                    )
                }
            }
            .build()

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(NetworkConstants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun provideITunesApi(retrofit: Retrofit): ITunesApi =
        retrofit.create(ITunesApi::class.java)

    single { provideOkhttpClient() }

    single { provideRetrofit(get()) }

    single { provideITunesApi(get()) }

}

/**
 * ViewModel Module Instance for dependency injection
 *
 * @author Jian James P. Astrero
 */
val viewModelModules = module {
    viewModel { MovieMainListViewModel(get(), get()) }
    viewModel { MovieDetailViewModel(get(), get(), get()) }
}