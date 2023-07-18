# Product Manager API

## Endpoints:

- #### Home URL:  "/" -> Basic tutorial
- #### BaseURL: "/products" -> {
    - GET: getAllProducts( )
    - GET /{id}: getById( )
    - POST: createProduct( )
    - PUT /{id}: updateProduct( )
    - DELETE /{id}: deleteProduct( )
      }

## Model:

```json
{
	"name": "Myproduct",
	"description": "my description (Over 50 chars)",
	"price": 299.50,
	"available": true
}
```


## Business Rules

- Not permissed negative price values.
- Not searc products without available.
- The description must be longer than 50 characters.