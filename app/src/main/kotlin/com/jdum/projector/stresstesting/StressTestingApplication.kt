package com.jdum.projector.stresstesting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StressTestingApplication

fun main(args: Array<String>) {
	runApplication<StressTestingApplication>(*args)
}
