package dev.nahtan.shifttracker.feature_shifts.data.repo

import dev.nahtan.shifttracker.feature_shifts.data.di.IoDispatcher
import dev.nahtan.shifttracker.feature_shifts.data.local.ShiftEntryDao
import dev.nahtan.shifttracker.feature_shifts.data.mapper.toEntry
import dev.nahtan.shifttracker.feature_shifts.data.mapper.toLocalEntry
import dev.nahtan.shifttracker.feature_shifts.data.mapper.toLocalShiftEntryList
import dev.nahtan.shifttracker.feature_shifts.data.mapper.toShiftEntryList
import dev.nahtan.shifttracker.feature_shifts.domain.model.ShiftEntry
import dev.nahtan.shifttracker.feature_shifts.domain.repo.ShiftRepo
import kotlinx.coroutines.CoroutineDispatcher

class ShiftRepoImpl(
    private val dao: ShiftEntryDao,
    @IoDispatcher
    private val dispatcher: CoroutineDispatcher
): ShiftRepo {
    override suspend fun getAllShiftEntries(): List<ShiftEntry> {
        return dao.getAllShiftEntries().toShiftEntryList()
    }

    override suspend fun getSingleShiftById(id: Int): ShiftEntry? {
        return dao.getSingleShiftEntryById(id)?.toEntry()
    }

    override suspend fun addShiftEntry(entry: ShiftEntry) {
        dao.addSingleShiftEntry(entry.toLocalEntry())
    }

    override suspend fun updateShiftEntry(entry: ShiftEntry) {
        dao.updateShiftEntry(entry.toLocalEntry())
    }

    override suspend fun updateShiftEntries(entries: List<ShiftEntry>) {
        dao.updateAllShiftEntries(entries.toLocalShiftEntryList())
    }

    override suspend fun deleteShiftEntry(entry: ShiftEntry) {
        dao.deleteShiftEntry(entry.toLocalEntry())
    }

    override suspend fun getAllPaidShiftEntries(): List<ShiftEntry> {
        return dao.getAllPaidShiftEntries().toShiftEntryList()
    }

    override suspend fun deleteAllPaidShiftEntries() {
        dao.deleteAllPaidShiftEntries()
    }

    override suspend fun deleteAllShiftEntries() {
        dao.deleteAllShiftEntries()
    }
}