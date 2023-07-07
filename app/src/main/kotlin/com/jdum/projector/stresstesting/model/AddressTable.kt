package com.jdum.projector.stresstesting.model

import com.jdum.projector.stresstesting.TableNames
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = TableNames.ADDRESS)
class AddressTable(
    @Id
    var id: String,
    var country: String,
    var city: String,
    var street: String,
    var phone: String,
    var email: String,
    var zipCode: String
)
