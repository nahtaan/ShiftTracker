package dev.nahtan.shifttracker.feature_shifts.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.nahtan.shifttracker.feature_shifts.data.local.dto.LocalShiftEntry

@Database(
    entities = [LocalShiftEntry::class],
    version = 1,
    exportSchema = false
)
abstract class ShiftDatabase: RoomDatabase() {
    abstract val dao: ShiftEntryDao
    companion object{
        const val DATABASE_NAME = "shift_db"
    }
}