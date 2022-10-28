package com.welsh.calendarapproomdatabase.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import java.io.File

private const val DB_NAME = "calendar"

@Database(
    entities =
    [Appointment::class, BranchAssociate::class, UserConfig::class,
        Contact::class, UserConfigBranchAssociateCrossRef::class, AppointmentDetails::class],
    version = 1, exportSchema = false
)
@TypeConverters(Converters::class)
public abstract class CalendarDatabase : RoomDatabase() {

    abstract fun calendarDao(): CalendarDao

    companion object {
        @Volatile
        private var INSTANCE: CalendarDatabase? = null

        fun getDatabase(context: Context): CalendarDatabase? {
            val tempInstance = INSTANCE
            if (tempInstance != null  || context.databaseFileExists()) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CalendarDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }


}

private fun Context.databaseFileExists(): Boolean {
    return try {
        File(this.getDatabasePath("$DB_NAME.db").absolutePath).exists()
    }catch (e: Exception){
        false
    }
}