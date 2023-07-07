package com.jdum.projector.stresstesting.repository

import com.jdum.projector.stresstesting.model.AddressMongo
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MongoAddressRepository: MongoRepository<AddressMongo, String> {
}
