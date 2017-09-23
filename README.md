

## Cara jalanin:
### Codeception
install dependency nya
`./composer install`
jalanin test (udah di dalam folder codeception)
`./vendor/codeception/codeception/codecept run -vvv` verbose mode
`./vendor/codeception/codeception/codecept run --html` disertai dengan report HTML di folder `_output`

### Postman
Collection bisa di import di postman web, atau klo mau pake cli mode bisa menggunakan newman
Install dependency nya
`./postman/npm install`
Jalanin test
`npm test` atau `newman run StarWarsAPI.postman_collection.json`
