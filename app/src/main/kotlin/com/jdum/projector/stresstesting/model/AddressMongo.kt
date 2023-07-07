package com.jdum.projector.stresstesting.model

import com.jdum.projector.stresstesting.TableNames
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(TableNames.ADDRESS)
class AddressMongo(
    @Id
    var id: String,
    @Field
    var country: String,
    @Field
    var city: String,
    @Field
    var street: String,
    @Field
    var phone: String,
    @Field
    var email: String,
    @Field
    var zipCode: String
)
