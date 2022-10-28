package com.welsh.calendarapproomdatabase.room

import androidx.room.*

@Entity(tableName = "user_config_branch_assoc",
    foreignKeys = [ForeignKey(
        entity = BranchAssociate::class,
        parentColumns = arrayOf("_id"),
        childColumns = arrayOf("user_config_id"),
        onDelete= ForeignKey.CASCADE),
        ForeignKey(
            entity = UserConfig::class,
            parentColumns = arrayOf("_id"),
            childColumns = arrayOf("user_config_id"),
            onDelete= ForeignKey.CASCADE)
    ], indices = arrayOf(Index(value = ["user_config_id", "branch_associate_id"], unique = true))
)
data class UserConfigBranchAssociateCrossRef (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    var id: Long,
    @ColumnInfo(name="user_config_id")
    var userConfigId: Long,
    @ColumnInfo(name="branch_associate_id")
    var branchAssociateId : Long,
    @field:ColumnInfo(name="active")
    var active : Int )
