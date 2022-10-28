package com.welsh.calendarapproomdatabase.room

import androidx.room.Embedded
import androidx.room.Relation

data class BranchAssociateForUserConfig(
    @Embedded var userConfigBranchAssociateCrossRef: UserConfigBranchAssociateCrossRef,
    @Relation(
        parentColumn = "branch_associate_id",
        entityColumn = "_id"
    )
    var branchAssociate: BranchAssociate
)