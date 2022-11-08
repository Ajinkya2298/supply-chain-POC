# Introduction
A library to learn:
1. Dropwizard project structure & philosophy [Link](https://www.dropwizard.io/en/latest/manual/core.html#organizing-your-project)
2. Simple REST API with Dropwizard
3. Unit testing

## Build
```shell
./gradlew :dropwizardapp:jar
```

## Start server
```shell
./gradlew :dropwizardapp:start
```

## cURL commands

### Create
```shell
curl -X POST http://localhost:8080/departments/ -H "Content-Type: application/json" -d '{"name": "FinTech"}'
```

### List
```shell
curl -X GET http://localhost:8080/departments/
```

### Get
```shell
curl -X GET http://localhost:8080/departments/47693b4c-c5bc-49a9-adb2-9ec06a797827
```

### Update
```shell
curl -X PATCH http://localhost:8080/departments/47693b4c-c5bc-49a9-adb2-9ec06a797827 -H "Content-Type: application/json" -d '{"name": "Fin Tech"}'
```

### Delete
```shell
curl -X DELETE http://localhost:8080/departments/47693b4c-c5bc-49a9-adb2-9ec06a797827
```
