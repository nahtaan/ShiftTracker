package dev.nahtan.shifttracker.feature_shifts.data.local

import androidx.room.*
import dev.nahtan.shifttracker.feature_shifts.data.local.dto.LocalShiftEntry

@Dao
interface ShiftEntryDao {
    @Query("SELECT * FROM shift_db")
    suspend fun getAllShiftEntries(): List<LocalShiftEntry>

    @Query("SELECT * FROM shift_db WHERE id = :id")
    suspend fun getSingleShiftEntryById(id: Int): LocalShiftEntry?

    @Query("SELECT * FROM shift_db WHERE isPaid = true")
    suspend fun getAllPaidShiftEntries(): List<LocalShiftEntry>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllShiftEntries(entries: List<LocalShiftEntry>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSingleShiftEntry(entry: LocalShiftEntry)

    @Update
    suspend fun updateShiftEntry(entry: LocalShiftEntry)

    @Transaction
    suspend fun updateAllShiftEntries(entries: List<LocalShiftEntry>){
        entries.forEach {
            updateShiftEntry(it)
        }
    }
    @Delete
    suspend fun deleteShiftEntry(entry: LocalShiftEntry)
    @Query("DELETE FROM shift_db WHERE isPaid = true")
    suspend fun deleteAllPaidShiftEntries()

    @Query("DELETE FROM shift_db WHERE 1 = 1")
    suspend fun deleteAllShiftEntries()
}