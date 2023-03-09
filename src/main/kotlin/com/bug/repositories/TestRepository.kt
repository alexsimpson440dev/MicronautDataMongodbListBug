package com.bug.repositories

import com.bug.entities.TestEntity
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.kotlin.CoroutineCrudRepository
import org.bson.types.ObjectId

@MongoRepository
abstract class TestRepository : CoroutineCrudRepository<TestEntity, ObjectId> {

    abstract suspend fun findByParentChildEquals(
        child: String
    ): TestEntity

    abstract suspend fun findByParentChild(
        child: String
    ): TestEntity

    abstract suspend fun findByParentChildIn(
        child: List<String>
    ): TestEntity

    abstract suspend fun findByParentChildInList(
        child: List<String>
    ): TestEntity
}
