package com.welsh.calendarapproomdatabase.room

import androidx.room.Embedded
import androidx.room.Relation

class UserConfigFromBranchAssociate(
    @Embedded
    var userConfigBranchAssociateCrossRef: UserConfigBranchAssociateCrossRef,
    @Relation(
        parentColumn = "user_config_id",
        entityColumn = "_id"
    )
    var userConfig: UserConfig
)