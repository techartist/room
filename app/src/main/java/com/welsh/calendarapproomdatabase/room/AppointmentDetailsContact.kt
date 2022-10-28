package com.welsh.calendarapproomdatabase.room

import androidx.room.Embedded
import androidx.room.Relation

data class AppointmentDetailsContact (

    @Embedded val appointmentDetails: AppointmentDetails,
    @Relation(parentColumn = "contact_id",
        entityColumn = "contact_id",
        entity = Contact::class
    )
    var contact: Contact
)