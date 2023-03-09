db = new Mongo().getDB("list_bug");
db.createCollection('test', { capped: false });

db.test.insert([
  { "parent": { "child": "child1" } }
])
