package dev.nahtan.shifttracker.feature_shifts.domain.model

data class ShiftEntry(
    val startTime: Long,
    val endTime: Long?,
    val isPaid: Boolean,
    val id: Int?
)