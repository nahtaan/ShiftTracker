package dev.nahtan.shifttracker.feature_shifts.data.mapper

import dev.nahtan.shifttracker.feature_shifts.data.local.dto.LocalShiftEntry
import dev.nahtan.shifttracker.feature_shifts.domain.model.ShiftEntry

fun LocalShiftEntry.toEntry(): ShiftEntry{
    return ShiftEntry(
        startTime = startTime,
        endTime = endTime,
        isPaid = isPaid,
        id = id
    )
}
fun List<LocalShiftEntry>.toShiftEntryList(): List<ShiftEntry>{
    return this.map {item -> item.toEntry()}
}
fun ShiftEntry.toLocalEntry(): LocalShiftEntry{
    return LocalShiftEntry(
        startTime = startTime,
        endTime = endTime,
        isPaid = isPaid,
        id = id
    )
}
fun List<ShiftEntry>.toLocalShiftEntryList(): List<LocalShiftEntry>{
    return this.map {item -> item.toLocalEntry()}
}