package com.welsh.calendarapproomdatabase.repository

import com.welsh.calendarapproomdatabase.room.*
import kotlinx.coroutines.flow.Flow
import java.time.Instant
import javax.inject.Inject

class CalendarRepositoryImpl @Inject constructor(val dao: CalendarDao) : CalendarRepository {
    override fun getAllUserConfigBranchAssociates(): Flow<List<UserConfigBranchAssociate>> {
        return dao.getAllUserConfigBranchAssociates()
    }

    override fun getAllBranchAssociatesFromUserConfig(id: Long): Flow<List<BranchAssociateForUserConfig>> {
        return dao.getAllBranchAssociatesFromUserConfig(id)
    }

    override fun getUserConfigFromBranchAssociate(id: Long): Flow<List<UserConfigFromBranchAssociate>> {
        return dao.getUserConfigFromBranchAssociate(id)
    }

    override fun getAppointmentDetails(activityId: Long): Flow<AppointmentDetailsContact> {
        return dao.getAppointmentDetails(activityId)
    }

    override fun selectAllAppointments(): Flow<List<Appointment>> {
        return selectAllAppointments()
    }

    override fun insertAppointment(appointment: Appointment) {
        dao.insertAppointment(appointment)
    }

    override fun insertContact(contact: Contact) {
        dao.insertContact(contact)
    }

    override fun selectAllAppointmentsFromCertainTime(
        startTime: Instant,
        endtime: Instant
    ): Flow<List<Appointment>> {
        return dao.selectAllAppointmentsFromCertainTime(startTime.toEpochMilli(), endtime.toEpochMilli())
    }

    override fun updateAppointment(appointment: Appointment) {
        dao.updateAppointment(appointment)
    }

    override fun updateAppointmentDetails(appointmentDetails: AppointmentDetails) {
        dao.updateAppointmentDetails(appointmentDetails)
    }

    override fun updateContact(contact: Contact) {
        dao.updateContact(contact)
    }
}