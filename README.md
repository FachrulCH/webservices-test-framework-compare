

## Cara jalanin:
### Codeception
install dependency nya
`./codeception/composer install`
jalanin test
`./codeception/vendor/codeception/codeception/codecept run -vvv` verbose mode

### Postman
Collection bisa di import di postman web, atau klo mau pake cli mode bisa menggunakan newman
Install dependency nya
`./postman/npm install`
Jalanin test
`npm test` atau `newman run StarWarsAPI.postman_collection.json`
