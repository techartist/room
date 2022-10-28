package com.welsh.calendarapproomdatabase.domain

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.welsh.calendarapproomdatabase.room.Appointment
import com.welsh.calendarapproomdatabase.room.AppointmentTypeCode
import com.welsh.calendarapproomdatabase.room.toDomain
import java.time.Instant

class AppointmentDomain(

        val activityId: Long,

        val activityStartTimestamp: Instant,

        val activityEndTimestamp: Instant,

        val activityRevisionTimestamp: Instant?,

        val appointmentTypeCode: String,

        val contactName: String?,

        val activityDescription: String?,

        val recurringId: Int?,

        val cancelled: Boolean,

        val deleteDate: Instant? // would like to get this to be a boolean if possible, if not convert to instant

    )

fun AppointmentDomain.toEntity(): Appointment {
    val type = AppointmentTypeCode.values().first {
        it.name == this.appointmentTypeCode
    }
    return Appointment(
        this.activityId,
        this.activityStartTimestamp,
        this.activityEndTimestamp,
        this.activityRevisionTimestamp,
        type,
        this.contactName,
        this.activityDescription,
        this.recurringId,
        this.cancelled,
        this.deleteDate
    )
}

