package com.bug.entities

import io.micronaut.data.annotation.Embeddable
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation
import io.micronaut.serde.annotation.Serdeable
import org.bson.types.ObjectId

@Serdeable
@MappedEntity("test")
data class TestEntity(
    @field:Id val id: ObjectId = ObjectId(),
    @field:Relation(value = Relation.Kind.EMBEDDED)
    val parent: ParentObject
)

@Serdeable
@Embeddable
data class ParentObject(
    val child: String
)
