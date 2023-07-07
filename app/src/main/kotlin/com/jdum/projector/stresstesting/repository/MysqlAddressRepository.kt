package com.jdum.projector.stresstesting.repository

import com.jdum.projector.stresstesting.model.AddressTable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MysqlAddressRepository : CrudRepository<AddressTable, String> {
}
