package com.bug.controllers

import com.bug.repositories.TestRepository
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class TestController(private val testRepository: TestRepository) {

    @Get("equals")
    suspend fun getEquals() = testRepository.findByParentChildEquals("child1")

    @Get("child")
    suspend fun getChild() = testRepository.findByParentChild("child1")

    @Get("in")
    suspend fun getIn() = testRepository.findByParentChildIn(listOf("child1"))

    @Get("list")
    suspend fun getInList() = testRepository.findByParentChildInList(listOf("child1"))
}
