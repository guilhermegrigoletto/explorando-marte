# Explorando Marte

## Introducao
Teste tecnico de desenvolvedor da Elo7 em que um conjunto de sondas e enviada para Marte e deve permitir
que elas sejam comandadas para explorar o local em uma malha retangular.

## Regras
Foi assumido uma malha (planalto) padrao de 10x10 (sendo 10 posicoes maximas na horizontal e 10 na horizontal)
podendo ser alterado pela API /malhas.

No caso da sonda ultrapassar o limite maximo da malha (posicao 11, por exemplo) ela voltara a posicao 0. 

## Comandos
Para controlar as sondas, a NASA envia uma simples sequência de letras. As letras possíveis são "L", "R" e "M". Destas, "L" e "R" fazem a sonda virar 90 graus para a esquerda ou direita, respectivamente, 
sem mover a sonda. "M" faz com que a sonda mova-se para a frente um ponto da malha, mantendo a mesma direção.

## Tecnologias usadas
+ Java 11
+ Spring Boot 2.3
+ Swagger/OpenApi
+ JUnit 5
+ Maven
+ Docker
+ Banco de dados H2

## Iniciando a aplicacao
Para fazer build com Maven
```
mvn clean install
```

Rodando com Docker
1. Build
```
docker build -t explorando-marte .
```

2.Rodar com o comando:
```
docker run -p 8080:8080 explorando-marte
```


## Documentacao API
Para ver os endpoints disponiveis, inicie a aplicacao e consulte swagger por meio da URL:

http://localhost:8080/swagger-ui.html


## Uso
### Para criar uma sonda
```
POST http://localhost:8080/api/sondas
```
Com a entrada desejada para as coordenadas e direcao iniciais:
```
{
    "x":2,
    "y":3,
    "direcao":"N"
}
```
Obs: as direcoes seguem o nome em ingles e sao validos portanto: N, S, W e E (respectivamente, North, South, West e East).

### Movimentar uma sonda
```
PUT http://localhost:8080/api/sondas/{idSonda}/{comandoMovimento}
```

Sendo idSonda uma sonda previamente criada e comandoMovimento sendo "L", "R" ou "M".
"L" faz a sonda virar 90 graus para a esquerda, sem mover a sonda. 
"R" faz a sonda virar 90 graus para a direita, sem mover a sonda. 
"M" faz com que a sonda mova-se para a frente um ponto da malha, mantendo a mesma direção


### Obter a posicao atual de uma sonda
```
http://localhost:8080/api/sondas/{idSonda}
```
Sendo idSonda uma sonda previamente criada


### Alterar o tamanho da malha 
O tamanho padrao da mmalha pela qual a sonda navega e de 10x10 mas pode ser alterada com o endpoint:

```
http://localhost:8080/api/malhas
```

E as novas coordenadas

```
{
    "x": "12",
    "y": "12"
}
```

Para mais informacoes dos parametros e retornos consulte o Swagger do projeto (ver DocumentcaoApi)

