package com.welsh.calendarapproomdatabase.network

import com.welsh.calendarapproomdatabase.room.Appointment
import java.time.Instant

class AppointmentNetwork(

    val activityId: Long,

    val activityStartTimestamp: String,

    val activityEndTimestamp: String,

    val activityRevisionTimestamp: String?,

    val appointmentTypeCode: String,

    val contactName: String?,

    val activityDescription: String?,

    val recurringId: Int?,

    val cancelled: Boolean,

    val deleteDate: String? // would like to get this to be a boolean if possible, if not convert to instant

)

fun AppointmentNetwork.toDomain() {

}

