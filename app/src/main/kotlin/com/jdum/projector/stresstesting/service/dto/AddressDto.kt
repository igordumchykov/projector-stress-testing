package com.jdum.projector.stresstesting.service.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_EMPTY)
class AddressDto(
    var id: String?,
    var country: String,
    var city: String,
    var street: String,
    var phone: String,
    var email: String,
    var zipCode: String
) {

}
