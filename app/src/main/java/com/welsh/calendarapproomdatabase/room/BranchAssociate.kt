package com.welsh.calendarapproomdatabase.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "branch_associate")
data class BranchAssociate(

    @field:PrimaryKey(autoGenerate = true)
    @field:ColumnInfo(name = "_id") val id: Long,
    @field:ColumnInfo(name = "owner_id") val ownerId: Long,

    val ownerCode: String?,

    val faNo: Int?,

    val nameFormatted: String?
)