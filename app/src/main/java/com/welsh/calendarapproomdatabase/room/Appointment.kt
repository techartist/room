package com.welsh.calendarapproomdatabase.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.welsh.calendarapproomdatabase.domain.AppointmentDomain
import java.time.Instant

@Entity(
    tableName = "appointment", indices = arrayOf(
        Index(value = ["activity_id"], unique = true), Index(value = ["activityStartTimestamp"]),
        Index(value = ["activityEndTimestamp"]), Index(value = ["appointmentTypeCode"]),
        Index(value = ["contactName"])
    )
)
data class Appointment(

    @PrimaryKey
    @field:ColumnInfo(name = "activity_id")
    val activityId: Long,

    val activityStartTimestamp: Instant,

    val activityEndTimestamp: Instant,

    val activityRevisionTimestamp: Instant?,

    val appointmentTypeCode: AppointmentTypeCode,

    val contactName: String?,

    val activityDescription: String?,

    val recurringId: Int?,

    val cancelled: Boolean,

    val deleteDate: Instant? // would like to get this to be a boolean if possible, if not convert to instant
)

fun Appointment.toDomain() : AppointmentDomain {
    val typeCode = this.appointmentTypeCode.name
    return AppointmentDomain(
        this.activityId,
        this.activityStartTimestamp,
        this.activityEndTimestamp,
        this.activityRevisionTimestamp,
        typeCode,
        this.contactName,
        this.activityDescription,
        this.recurringId,
        this.cancelled,
        this.deleteDate
    )
}

enum class AppointmentTypeCode {

    IN_OFFICE,

    OUT_OF_OFFICE,

    PHONE,

    REVIEW,

    TIME_BLOCK,

    WALK_IN,

    WEB_EX,

    NOT_RECOGNIZED

}