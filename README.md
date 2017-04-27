# saracommerce
E-commerce

## Pré-requisitos
- criar os diretórios
  - ~/esdata
  - ~/datadir
- ter o [docker](https://www.docker.com/) instalado

## Tecnologias utilizadas
Spring Boot, Spring Data, Spring HATEOAS, MYSQL, Jenkins, ElasticSearch

## Run
1. Crie a imagem do store:
  * cd store
  * mvn clean package
2. No diretório raiz executar *docker-compose up -d*
