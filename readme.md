## Demo

+ spring boot

+ Hateoas

+ elasticsearch

+ es script
```js
put {host}/parent-child
{
  "mappings": {
    "_doc": {
      "properties": {
        "sub": { 
          "type": "join",
          "relations": {
            "father": "son" 
          }
        }
      }
    }
  }
}
```