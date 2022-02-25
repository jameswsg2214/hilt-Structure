package com.wils.efarmermarket.di.module

import android.content.Context
import androidx.room.Room
import com.wils.efarmermarket.db.AppDatabase
import com.wils.efarmermarket.db.UserDetailsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideUserDao(appDatabase: AppDatabase):UserDetailsDao{
        return appDatabase.userDetailsDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext:Context):AppDatabase{
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "EFarmerDb"
        ).build()
    }
}