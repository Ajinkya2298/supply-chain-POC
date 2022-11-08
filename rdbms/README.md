# Introduction
A library to manage changes to database via Liquibase

# Steps

## Login to Local Postgres
```shell
psql -h localhost -U postgres
```

## Create DB
```sql
CREATE DATABASE kotlin_monorepo;
```

## Create a change file
Check output of the following command!
```shell
./gradlew :rdbms:createChangeLog -Pdesc='short-change-description'
```

## Add change file to main changelog
Get `FILE_NAME` from previous step output
```
Add "<include file="FILE_NAME" relativeToChangelogFile="true"/>" to changelog.xml
```

## Run changes
```shell
./gradlew rdbms:update
```
