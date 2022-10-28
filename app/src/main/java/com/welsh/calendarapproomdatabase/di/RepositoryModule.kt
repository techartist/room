package com.welsh.calendarapproomdatabase.di

import android.content.Context
import com.welsh.calendarapproomdatabase.room.CalendarDao
import com.welsh.calendarapproomdatabase.room.CalendarDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideCalendarDatabase(
        @ApplicationContext context: Context
    ): CalendarDatabase? = CalendarDatabase.getDatabase(context)

    @Provides
    fun provideCalendarDao(database:CalendarDatabase): CalendarDao {
        return database.calendarDao()
    }

}