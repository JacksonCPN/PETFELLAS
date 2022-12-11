
# Desafio API - Pet

API REST que será consumida por um front para criação de um sistema para uma clinica veterinária.




## Documentação

Após subir o ambiente basta clicar no link abaixo para vizualizar o swagger.

[Documentação Swagger](http://localhost:8080/swagger-ui.html#/)

Para gerar um token e executar testes diretamento no swagger, basta ir no autenticacao-controller e gerar um token com o login :
{
"email" : "veterinario@email.com",
"senha" : "1234"
}

O token para autorização é Bearer + "token gerado"

Para que um cliente possa ver o histórico de atendimento do seu pet, é preciso que um usuário seja cadastrado com o mesmo email do cliente.

Segue um arquivo para testes no Postman dentro da pasta postman no projeto.



## Funcionalidades

- CRUD de Cliente, Veterinário, Cachorro e Atendimento
- Consumo de API thedog

