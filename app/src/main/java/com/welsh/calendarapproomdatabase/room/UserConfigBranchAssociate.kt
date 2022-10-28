package com.welsh.calendarapproomdatabase.room

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.welsh.calendarapproomdatabase.room.BranchAssociate
import com.welsh.calendarapproomdatabase.room.UserConfig
import com.welsh.calendarapproomdatabase.room.UserConfigBranchAssociateCrossRef

data class UserConfigBranchAssociate(
    @Embedded var userConfigBranchAssociateCrossRef: UserConfigBranchAssociateCrossRef,
    @Relation(
        parentColumn = "user_config_id",
        entityColumn = "_id"
    ) var userConfig: UserConfig,
    @Relation(
        parentColumn = "branch_associate_id",
        entityColumn = "_id"
    )
    var branchAssociate: BranchAssociate
    )

