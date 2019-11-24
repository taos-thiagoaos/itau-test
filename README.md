# Relatório Técnico

## Aderência ao Planejamento


## Tecnologias Utilizadas

- Ferramentas, IDE, Editores
    - vscode para node e front-end
    - idea community para java
    - sequel pro no mac para mysql
    - mysql workbench no linux para mysql
    - docker e docker compose
    - terminal hyper
    - git

- Twitter Collect
    - nodejs 12.13
    - mysql
    - sequelize lib
    - node-fetch

    > Este app connecta a api do twitter para pegar os tweets por tags pré definidas. O tweets encontrados são transformados e armazenados em uma base mysql

- API
    - java 11
    - spring boot 2.2
    - spring data
    - springfox to swagger
    - jdbc mysql driver

    > Este app publica 3 APIs REST. É utilizado a base mysql pré populada (pelo app nodejs) para adquirir as informações 

        - GET http://localhost:8080/api/v1/tweets/total-by-tag-lang
        - GET http://localhost:8080/api/v1/tweets/total-by-hour
        - GET http://localhost:8080/api/v1/users/top5-followers

    > swagger api
        
        - http//localhost:8080/swagger-ui.html
        - http://localhost:8080/v2/api-docs

- Gateway
 
    - Apigee
    - oAuth2

     > APIs

        - GET https://thiagoaos-eval-prod.apigee.net/users/top-5-followers
        - GET https://thiagoaos-eval-prod.apigee.net/tweets/total-by-tag-lang
        - GET https://thiagoaos-eval-prod.apigee.net/tweets/total-by-hour
        - POST https://thiagoaos-eval-prod.apigee.net/oauth/client_credential/accesstoken


- Front-end
    - react with react hooks strategy
    - react material with pre defined template
    - fetch api

    > Endpoint
        
        - http://localhost:3000

## Instalação

- Database

        - docker-compose up db;

- Data collect (Rode somente 1 vez e antes da api e front)

        - cp twitter_collect/env.template twitter_collect/.env
        - set twitter token in .env TWITTER_BEARER_TOKEN directive
        - docker-compose up data_collect;

- api

        - docker-compose up api

- front

        - docker-compose up front