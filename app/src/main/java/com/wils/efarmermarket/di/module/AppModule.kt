package com.wils.efarmermarket.di.module

import android.content.Context
import androidx.room.Room
import com.wils.efarmermarket.db.AppDatabase
import com.wils.efarmermarket.db.dao.ItemsDao
import com.wils.efarmermarket.db.dao.OrderDetailsDao
import com.wils.efarmermarket.db.dao.UserDetailsDao
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
    fun provideUserDao(appDatabase: AppDatabase): UserDetailsDao {
        return appDatabase.userDetailsDao()
    }

    @Provides
    fun provideOrderDao(appDatabase: AppDatabase): OrderDetailsDao {
        return appDatabase.orderDetailsDao()
    }

    @Provides
    fun provideItemDetailsDao(appDatabase: AppDatabase): ItemsDao {
        return appDatabase.itemDetailsDao()
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