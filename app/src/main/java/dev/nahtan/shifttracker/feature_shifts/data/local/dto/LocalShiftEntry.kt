package dev.nahtan.shifttracker.feature_shifts.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shift_db")
data class LocalShiftEntry(
    val startTime: Long,
    val endTime: Long?,
    val isPaid: Boolean,
    @PrimaryKey(autoGenerate = true)
    val id: Int?
)