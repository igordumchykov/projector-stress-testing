package com.jdum.projector.stresstesting.controller

import com.jdum.projector.stresstesting.model.AddressMongo
import com.jdum.projector.stresstesting.model.AddressTable
import com.jdum.projector.stresstesting.service.AddressService
import com.jdum.projector.stresstesting.service.dto.AddressDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/address")
class AddressController(
    private val service: AddressService
) {

    @PostMapping
    fun createAddress(@RequestBody address: AddressDto): ResponseEntity<AddressDto> {
        this.service.createAddress(address)
        return ResponseEntity.ok().body(address)
    }

    @GetMapping("/mongo/{id}")
    fun getMongoAddress(@PathVariable id: String): ResponseEntity<AddressMongo> {
        val address = this.service.getMongoAddress(id)
        return address.map { ResponseEntity.ok().body(it) }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/mysql/{id}")
    fun getMysqlAddress(@PathVariable id: String): ResponseEntity<AddressTable> {
        val address = this.service.getMysqlAddress(id)
        return address.map { ResponseEntity.ok().body(it) }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/mongo/all")
    fun getMongoAddresses(): ResponseEntity<List<AddressMongo>> {
        val addresses = this.service.getMongoAddresses()
        return ResponseEntity.ok().body(addresses)
    }

    @GetMapping("/mysql/all")
    fun getMysqlAddresses(): ResponseEntity<List<AddressTable>> {
        val addresses = this.service.getMysqlAddresses()
        return ResponseEntity.ok().body(addresses)
    }
}
