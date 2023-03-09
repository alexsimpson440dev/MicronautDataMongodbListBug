## Micronaut Data Mongo Bug
### Description:
When upgrading to Micronaut 3.8.x I noticed my integration tests started failing.
I narrowed these tests down to just the In / InList methods within repositories for nested entities on Micronaut Data 3.9.x

When trace logging Mongo I can see these nested entities are only searching mongo with the nested object

### Example Queries in Micronaut 3.7.7
findByParentChild produces - `{"parent.child": {"$eq": "child1"}}`

findByParentChildEquals produces - `{"parent.child": {"$eq": "child1"}}`

findByParentChildIn produces - `{"parent.child": {"$in": ["child1"]}}`

findByParentChildInList produces - `{"parent.child": {"$in": ["child1"]}}`

### Example Queries in Micronaut 3.8.7
findByParentChild produces - `{"parent.child": {"$eq": "child1"}}`

findByParentChildEquals produces - `{"parent.child": {"$eq": "child1"}}`

findByParentChildIn produces - `{"child": {"$in": ["child1"]}}`

findByParentChildInList produces - `{"child": {"$in": ["child1"]}}`

### Running Project
1. Run `docker compose up` this should create the database with a collection and one entry
2. Run `./gradlew run`
3. Call controller endpoints:
   1. `localhost:8080/child` - findByParentChild repository method
   2. `localhost:8080/equals` - findByParentChildEquals repository method
   3. `localhost:8080/in` - findByParentChildIn repository method (bug)
   4. `localhost:8080/list` - findByParentChildInList repository method (bug)
4. This should trace log the query into the console as shown above
5. Update the `micronautVersion` to 3.7.7 in the `gradle.properties` file and rerun
6. These queries should start working
