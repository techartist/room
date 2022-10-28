package com.welsh.calendarapproomdatabase.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.Instant

@Entity(
    tableName = "appointment_details",
    foreignKeys = [ForeignKey(
        entity = Contact::class,
        parentColumns = arrayOf("contact_id"),
        childColumns = arrayOf("contact_id"),
        onDelete = ForeignKey.CASCADE
    ),
        ForeignKey(
            entity = Appointment::class,
            parentColumns = arrayOf("activity_id"),
            childColumns = arrayOf("activity_id"),
            onDelete = ForeignKey.CASCADE
        )]
)
data class AppointmentDetails(
    @PrimaryKey
    @field:ColumnInfo(name = "activity_id") val activityId: Long,
    val branchNo: Int,
    val ownerId: Long,
    val ownerType: String,
    val owner: String,
    val ownerName: String,
    val activityCompleteTimeStamp: Instant,
    val completed: Boolean,
    val modifiable: Boolean,
    val cancelled: Boolean,
    val activityCreateUser: String,
    val relationshipName: String,
    val releationshipId: Long,
    val activityTypeCode: String,
    val appointmentTypeCode: String,
    val reminder: Boolean,
    val personal: Boolean,
    val need: String,
    val subNeed: String,
    val description: String,
    @field:ColumnInfo(name = "contact_id") val contactId: Long
)

