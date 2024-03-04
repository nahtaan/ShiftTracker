package dev.nahtan.shifttracker.feature_shifts.domain.use_case

import dev.nahtan.shifttracker.feature_shifts.domain.model.ShiftEntry
import dev.nahtan.shifttracker.feature_shifts.domain.repo.ShiftRepo
import javax.inject.Inject

class ShiftUseCases @Inject constructor(
    private val repo: ShiftRepo
) {
    suspend fun addShiftEntry(entry: ShiftEntry){
        repo.addShiftEntry(entry)
    }
    suspend fun getShiftEntryById(id: Int): ShiftEntry?{
        return repo.getSingleShiftById(id)
    }
    suspend fun toggleIsShiftEntryPaid(entry: ShiftEntry){
        repo.updateShiftEntry(
            entry.copy(
                isPaid = !entry.isPaid
            )
        )
    }
}