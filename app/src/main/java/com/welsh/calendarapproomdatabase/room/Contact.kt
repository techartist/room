package com.welsh.calendarapproomdatabase.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.welsh.calendarapproomdatabase.domain.ContactDomain

@Entity
data class Contact(
    @PrimaryKey
    @field:ColumnInfo(name = "contact_id")
    val contactID: Long,
    val legacyContactNo: Long,
    val acctId: Long,
    val accountNo: String,
    val contactType: String,
    val name: String,
    val accountTyDesc: String,
    val relationshipId: Long
)

fun Contact.toDomain(): ContactDomain {
    return ContactDomain(
        this.contactID,
        this.legacyContactNo,
        this.acctId,
        this.accountNo,
        this.contactType,
        this.name,
        this.accountTyDesc,
        this.relationshipId
    )

}