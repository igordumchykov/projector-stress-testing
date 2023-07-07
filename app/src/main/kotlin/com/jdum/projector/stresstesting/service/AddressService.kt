package com.jdum.projector.stresstesting.service

import com.jdum.projector.stresstesting.model.AddressMongo
import com.jdum.projector.stresstesting.model.AddressTable
import com.jdum.projector.stresstesting.repository.MongoAddressRepository
import com.jdum.projector.stresstesting.repository.MysqlAddressRepository
import com.jdum.projector.stresstesting.service.dto.AddressDto
import org.springframework.stereotype.Service
import java.util.*

@Service
class AddressService(
    private val mongoRepo: MongoAddressRepository,
    private val mysqlRepo: MysqlAddressRepository,
) {

    fun createAddress(address: AddressDto): AddressDto {
        val id = UUID.randomUUID().toString()
        val mongoAddress = toMongoAddress(address, id)
        val mysqlAddress = toMysqlAddress(address, id)
        this.mongoRepo.save(mongoAddress)
        this.mysqlRepo.save(mysqlAddress)
        address.id = id
        return address
    }

    fun getMongoAddress(id: String): Optional<AddressMongo> = this.mongoRepo.findById(id)
    fun getMysqlAddress(id: String): Optional<AddressTable> = this.mysqlRepo.findById(id)
    fun getMysqlAddresses(): List<AddressTable> = this.mysqlRepo.findAll().toList()
    fun getMongoAddresses(): List<AddressMongo> = this.mongoRepo.findAll().toList()

    private fun toMongoAddress(address: AddressDto, id: String) = AddressMongo(
        id = id,
        country = address.country,
        city = address.city,
        street = address.street,
        phone = address.phone,
        email = address.email,
        zipCode = address.zipCode
    )

    private fun toMysqlAddress(address: AddressDto, id: String) = AddressTable(
        id = id,
        country = address.country,
        city = address.city,
        street = address.street,
        phone = address.phone,
        email = address.email,
        zipCode = address.zipCode
    )
}
