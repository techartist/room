package com.welsh.calendarapproomdatabase.repository

import com.welsh.calendarapproomdatabase.room.*
import kotlinx.coroutines.flow.Flow
import java.time.Instant

interface CalendarRepository {
    fun getAllUserConfigBranchAssociates() : Flow<List<UserConfigBranchAssociate>>
    fun getAllBranchAssociatesFromUserConfig(id: Long) : Flow<List<BranchAssociateForUserConfig>>
    fun getUserConfigFromBranchAssociate(id: Long) : Flow<List<UserConfigFromBranchAssociate>>
    fun getAppointmentDetails(activityId: Long) : Flow<AppointmentDetailsContact>
    fun selectAllAppointments(): Flow<List<Appointment>>
    fun insertAppointment(appointment: Appointment)
    fun insertContact(contact: Contact)
    fun selectAllAppointmentsFromCertainTime(startTime: Instant, endtime: Instant): Flow<List<Appointment>>
    fun updateAppointment(appointment: Appointment)
    fun updateAppointmentDetails(appointmentDetails: AppointmentDetails)
    fun updateContact(contact: Contact)
}