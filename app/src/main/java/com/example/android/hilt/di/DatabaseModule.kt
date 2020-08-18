package com.example.android.hilt.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.android.hilt.data.AppDatabase
import com.example.android.hilt.data.LogDao
import com.example.android.hilt.ui.LogsFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "logging.db"
        ).build()
    }

    @Provides
    fun providesLogDao(database: AppDatabase): LogDao {
        return database.logDao()
    }
}