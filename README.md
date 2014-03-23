bktree-spellcheck
=================

A spell speck service that is implemented using a BK-Tree.
This service can also be used for auto completion.

### Starting the Service Using Maven
```bash
mvn install
mvn jetty:run -Djetty.port=9999
```

### How to Use
#### Start Session
```bash
 curl --data "words=apple,orange,pear"  http://localhost:9999/spellcheck-service
```
Example Response: {"id":1395598771557}

#### Add More Words
```bash
curl --data "words=kiwi,cantaloupe,strawberry&id=1395598771557"  http://localhost:9999/spellcheck-service
```

#### Check Spelling
```bash
curl "http://localhost:9999/spellcheck-service?id=1395598771557&word=cantelope&edit_distance=2"
```
Example Response: {"results":[["cantaloupe"]]}