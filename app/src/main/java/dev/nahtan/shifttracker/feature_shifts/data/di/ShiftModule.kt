package dev.nahtan.shifttracker.feature_shifts.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.nahtan.shifttracker.feature_shifts.data.local.ShiftDatabase
import dev.nahtan.shifttracker.feature_shifts.data.local.ShiftEntryDao
import dev.nahtan.shifttracker.feature_shifts.data.repo.ShiftRepoImpl
import dev.nahtan.shifttracker.feature_shifts.domain.repo.ShiftRepo
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ShiftModule {
    @Provides
    fun providesRoomDao(database: ShiftDatabase): ShiftEntryDao{
        return database.dao
    }
    @Singleton
    @Provides
    fun providesRoomDb(
        @ApplicationContext appContext: Context
    ): ShiftDatabase{
        return Room.databaseBuilder(
            appContext.applicationContext,
            ShiftDatabase::class.java,
            "shift_db")
            .fallbackToDestructiveMigration()
            .build()
    }
    @Singleton
    @Provides
    fun providesShiftEntryRepo(
        db: ShiftDatabase,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): ShiftRepo{
        return ShiftRepoImpl(dao = db.dao, dispatcher = dispatcher)
    }
}