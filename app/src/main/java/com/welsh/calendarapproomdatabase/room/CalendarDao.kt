package com.welsh.calendarapproomdatabase.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CalendarDao {
    @Transaction
    @Query("SELECT * FROM user_config_branch_assoc ucba INNER JOIN user_config uc " +
            "ON ucba.user_config_id = uc._id INNER JOIN branch_associate ba " +
            "ON ba._id = ucba.branch_associate_id")
    fun getAllUserConfigBranchAssociates() : Flow<List<UserConfigBranchAssociate>>

    @Transaction
    @Query("SELECT * FROM user_config_branch_assoc ucba " +
            "INNER JOIN user_config uc ON ucba.user_config_id = uc._id INNER JOIN branch_associate ba " +
            "ON ba._id = ucba.branch_associate_id WHERE user_config_id = :id")
    fun getAllBranchAssociatesFromUserConfig(id: Long) : Flow<List<BranchAssociateForUserConfig>>

    @Transaction
    @Query("SELECT * FROM user_config_branch_assoc ucba " +
            "INNER JOIN user_config uc ON ucba.user_config_id = uc._id INNER JOIN branch_associate ba " +
            "ON ba._id = ucba.branch_associate_id WHERE branch_associate_id = :id LIMIT 1")
    fun getUserConfigFromBranchAssociate(id: Long) : Flow<List<UserConfigFromBranchAssociate>>

    @Query("SELECT * FROM appointment")
    fun selectAllAppointments(): Flow<List<Appointment>>

    @Query("SELECT * FROM appointment WHERE activityStartTimestamp > :startTime AND activityEndTimestamp < :endtime")
    fun selectAllAppointmentsFromCertainTime(startTime: Long, endtime: Long): Flow<List<Appointment>>

    @Transaction
    @Query("SELECT * FROM appointment_details ad " +
            "INNER JOIN contact c ON ad.contact_id = c.contact_id WHERE ad.activity_id = :activityId")
    fun getAppointmentDetails(activityId: Long) : Flow<AppointmentDetailsContact>

    @Insert
    fun insertContact(contact: Contact)

    @Insert
    fun insertAppointment(appointment: Appointment)

    @Update
    fun updateAppointment(appointment: Appointment)

    @Update
    fun updateContact(contact: Contact)

    @Update
    fun updateAppointmentDetails(appointmentDetails: AppointmentDetails)


}