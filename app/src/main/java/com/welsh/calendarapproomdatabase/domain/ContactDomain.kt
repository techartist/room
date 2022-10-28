package com.welsh.calendarapproomdatabase.domain

import com.welsh.calendarapproomdatabase.room.Contact
import com.welsh.calendarapproomdatabase.room.toDomain


data class ContactDomain(
    val contactID: Long,
    val legacyContactNo: Long,
    val acctId: Long,
    val accountNo: String,
    val contactType: String,
    val name: String,
    val accountTyDesc: String,
    val relationshipId: Long
)

fun ContactDomain.toEntity() : Contact {
    return Contact(
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

