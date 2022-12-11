
# PETFELLAS
###### (Projeto Petshop)

## ATIVIDADE AVALIATIVA DE DESENVOLVIMENTO DE APLICAÇÕES PARA A INTERNET.

#### Igor Sobral - 01383796
#### jackson Nascimento - 01368457
#### Luiz Oliveira - 01227047
#### Victor Vasconcelos - 01348102
#### Rodrigo Calvalcanti - 01362638
#### Vitor Veras - 01535603
#### Mateus Martorano - 01351757
#### Matheus Moraes - 01361823
#### Denys Wildson - 01380977
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
- Consumo de API

