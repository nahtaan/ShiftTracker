package dev.nahtan.shifttracker.feature_shifts.domain.repo

import dev.nahtan.shifttracker.feature_shifts.domain.model.ShiftEntry

interface ShiftRepo{
    suspend fun getAllShiftEntries(): List<ShiftEntry>
    suspend fun getSingleShiftById(id: Int): ShiftEntry?
    suspend fun addShiftEntry(entry: ShiftEntry)
    suspend fun updateShiftEntry(entry: ShiftEntry)
    suspend fun updateShiftEntries(entries: List<ShiftEntry>)
    suspend fun deleteShiftEntry(entry: ShiftEntry)
    suspend fun getAllPaidShiftEntries(): List<ShiftEntry>
    suspend fun deleteAllPaidShiftEntries()
    suspend fun deleteAllShiftEntries()
}