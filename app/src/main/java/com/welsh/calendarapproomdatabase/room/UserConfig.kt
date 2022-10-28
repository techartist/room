package com.welsh.calendarapproomdatabase.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "user_config",
    indices = arrayOf(Index(value = ["_id"], unique = true))
)
data class UserConfig(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    var id: Long,

    val timeZoneId: String? = null,

    val countryCode: String? = null,

    val branchNo: Int? = null,

    val privilegedUser: Boolean

)