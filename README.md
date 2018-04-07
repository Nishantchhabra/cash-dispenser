# Project Title
cash dispenser machine

## Prerequisites

What things you need to install the software and how to install them

```
Java 1.7, maven and SoapUI or postman to test
```

### Build

```
mvn clean install
```

## Run


`mvn spring-boot:run`

### Testing



    uri:http://localhost:8080/withdraw

    HttpMthod: POST



## Sample accounts to test: 

```
 amount: 11000
 debitnum: 4561234561237894
 pin: 6057
```

```
 amount: 10000
 debitnum: 8888999977776666
 pin: 4561
```


```
 amount: 12000
 debitnum: 2222555599996666
 pin: 7894
```


#### Sample JSON

```json
{
    "amount" : 11000,
	"debitnum" : "4561234561237894",
	"pin" :"6057"
}
```

 



