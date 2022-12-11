var TOKEN_LOGIN

function login() {
    const campos = camposLogin()

    const result = loginService.login(campos).then((item) => {
        window.location.href = "Menu.html"
        setToken(item)
    }).catch(error => {
        alert(error)
    })
}

function getToken(){
    const token = JSON.parse(this.TOKEN_LOGIN)
    return token.token
}

function setToken(token){
    this.TOKEN_LOGIN = token
    const auth = JSON.parse(this.TOKEN_LOGIN)
    localStorage.setItem('token' , auth.token)
}

// function GetClientes() {
//     const result = callApi({
//         method: "GET",
//         url: "http://localhost:8080/v1/clientes"
//     })
// }



const loginService = {
    login: campos => {
        return callApi({
            method: "POST",
            url: "http://localhost:8080/v1/login",
            params: campos
        })
    },

    get: campos => {
        return callApi({
            method: "POST",
            url: "http://localhost:8080/v1/cachorros",
        })
    }
}

function camposLogin() {
    return {
        email: form.email().value,
        senha: form.senha().value
    }
}

const form = {
    email: () => document.getElementById("emailLogin"),
    senha: () => document.getElementById("passwordLogin")
}

function callApi({ method, url, params }) {
    return new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest();

        xhr.open(method, url, true);
        //xhr.setRequestHeader('Authorization', await firebase.auth().currentUser.getIdToken())
        xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
        // xhr.setRequestHeader('Access-Control-Allow-Origin', '')
        xhr.onreadystatechange = function () {
            if (this.readyState == 4) {
                const json = this.responseText;
                console.log(this.status)
                if (this.status != 200) {
                    reject(json || 'Falha ao logar');
                } else {
                    resolve(json);
                }
            }
        };

        xhr.responseType = "text"
        xhr.send(JSON.stringify(params));
    })
}

async function GetClientes() {
    // const response = await fetch('http://localhost:8080/v1/clientes');
    const result = ClienteService.Find().then((item) => {
        var data = JSON.parse(item)
       ShowData(data);
  
    }).catch(error => {
        alert(error)
    })
    

}

// getapi("http://localhost:8080/v1/clientes");

function ShowData(data) {
    let tab = 
          `<tr>
              <th>id</th>
              <th>nome</th>
              <th>email</th>
              <th>telefone</th>
              <th>cep</th>
              <th>logradouro</th>
          </tr>`;
    
    for (let r of data) {
        tab += `<tr> 
                    <td>${r.id} </td>
                    <td>${r.nome}</td>
                    <td>${r.email}</td> 
                    <td>${r.telefone}</td>          
                    <td>${r.enderecoDTO.cep}</td>          
                    <td>${r.enderecoDTO.logradouro}, ${r.enderecoDTO.numero}</td>          
                </tr>`;
    }
    
    document.getElementById("clients").innerHTML = tab;
}

// Clientes
function CadastrarUser(){
    const campos = camposCadastroUser()
    const token = localStorage.getItem('token')

    const result = ClienteService.Cadastrar(campos).then((item) => {
        alert('Cliente cadastrado')
        limparCadastro()
    }).catch(error => {
        alert(error)
    })
}

function limparCadastro(){
    document.getElementById("Cadastro_User_Nome").value = ""
    document.getElementById("Cadastro_User_Cpf").value = ""
    document.getElementById("Cadastro_User_Cep").value = ""
    document.getElementById("Cadastro_User_Complemento").value = ""
    document.getElementById("Cadastro_User_Logradouro").value = ""
    document.getElementById("Cadastro_User_Numero").value = ""
    document.getElementById("Cadastro_User_Telefone").value = ""
    document.getElementById("Cadastro_User_Email").value = ""
    document.getElementById("Cadastro_User_Password").value = ""
    document.getElementById("Cadastro_User_NomePet").value = ""
    document.getElementById("Cadastro_User_IdadePet").value = ""
    document.getElementById("Cadastro_User_PesoPet").value = ""
    document.getElementById("Cadastro_User_RacaPet").value = ""
    document.getElementById("Cadastro_User_Altura").value = ""
    document.getElementById("Cadastro_User_Largura").value = ""
}

const ClienteService = {
    Find: () => {
        return callApiClientes({
            method: "GET",
            url: "http://localhost:8080/v1/clientes"
        })
    },

    Cadastrar: (campos) => {
        return callApiClientes({
            method: "POST",
            url: "http://localhost:8080/v1/clientes",
            params: campos,
        })
    },

    Deletar: (id) => {
        return callApiClientes({
            method: "DELETE",
            url: `http://localhost:8080/v1/clientes/${id}`,
        })
    },

    Update: (id,campos) => {
        return callApiClientes({
            method: "PUT",
            url: `http://localhost:8080/v1/clientes/${id}`,
            params: campos,
        })
    }
}

function camposCadastroUser(){
    return {
        cachorros: [
        {
        altura: formCadastroUser.altura().value,
        clienteId: undefined,
        idade: formCadastroUser.idadePet().value,
        largura: formCadastroUser.largura().value,
        nome: formCadastroUser.nomePet().value,
        peso: formCadastroUser.peso().value,
        racaId: formCadastroUser.racaPet().value
        }
        ],
        cpf: formCadastroUser.cpf().value,
        email: formCadastroUser.email().value,
        endereco: {
        cep: formCadastroUser.cep().value,
        complemento: formCadastroUser.complemento().value,
        logradouro: formCadastroUser.logradouro().value,
        numero: formCadastroUser.numero().value
        },
        nome: formCadastroUser.nome().value,
        telefone: formCadastroUser.telefone().value
    }
}

const formCadastroUser = {
    nome: () => document.getElementById("Cadastro_User_Nome"),
    cpf: () => document.getElementById("Cadastro_User_Cpf"),
    cep: () => document.getElementById("Cadastro_User_Cep"),
    complemento: () => document.getElementById("Cadastro_User_Complemento"),
    logradouro: () => document.getElementById("Cadastro_User_Logradouro"),
    numero: () => document.getElementById("Cadastro_User_Numero"),
    telefone: () => document.getElementById("Cadastro_User_Telefone"),
    email: () => document.getElementById("Cadastro_User_Email"),
    password: () => document.getElementById("Cadastro_User_Password"),
    nomePet: () => document.getElementById("Cadastro_User_NomePet"),
    idadePet: () => document.getElementById("Cadastro_User_IdadePet"),
    peso: () => document.getElementById("Cadastro_User_PesoPet"),
    racaPet: () => document.getElementById("Cadastro_User_RacaPet"),
    altura: () => document.getElementById("Cadastro_User_Altura"),
    largura: () => document.getElementById("Cadastro_User_Largura")
}


function callApiClientes({method, url, params}) {
    return new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest();

        xhr.open(method, url, true);
        const token = localStorage.getItem('token')
        xhr.setRequestHeader('Authorization', `Bearer ${token}`)
        xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
        xhr.onreadystatechange = function() {
            if (this.readyState == 4) {
                const json = this.responseText;
                if (this.status != 200) {
                    reject(json || 'Error');
                } else {
                    resolve(json);
                }
            }
        };
        
        xhr.responseType = "text"
        xhr.send(JSON.stringify(params));
    })
}

const formDelete = {
    id: () => document.getElementById("Id_Delete")
}

function deleteCliente(){
    const result = ClienteService.Deletar(formDelete.id().value).then((item) => {
        console.log('deletado')
        alert('Cliente deletado')
        limparDelete()
    }).catch(error => {
        alert(error)
    })
}

function limparDelete(){
    document.getElementById('Id_Delete').value = ""
}

const formUpdateUser = {
    id: () => document.getElementById("Update_User_Id"),
    nome: () => document.getElementById("Update_User_Nome"),
    cpf: () => document.getElementById("Update_User_Cpf"),
    cep: () => document.getElementById("Update_User_Cep"),
    complemento: () => document.getElementById("Update_User_Complemento"),
    logradouro: () => document.getElementById("Update_User_Logradouro"),
    numero: () => document.getElementById("Update_User_Numero"),
    telefone: () => document.getElementById("Update_User_Telefone"),
    email: () => document.getElementById("Update_User_Email"),
    password: () => document.getElementById("Update_User_Password"),
    nomePet: () => document.getElementById("Update_User_NomePet"),
    idadePet: () => document.getElementById("Update_User_IdadePet"),
    peso: () => document.getElementById("Update_User_PesoPet"),
    racaPet: () => document.getElementById("Update_User_RacaPet"),
    altura: () => document.getElementById("Update_User_Altura"),
    largura: () => document.getElementById("Update_User_Largura")
}

function camposUpdateUser(){
    return {
        cachorros: [
        {
        altura: formUpdateUser.altura().value,
        clienteId: undefined,
        idade: formUpdateUser.idadePet().value,
        largura: formUpdateUser.largura().value,
        nome: formUpdateUser.nomePet().value,
        peso: formUpdateUser.peso().value,
        racaId: formUpdateUser.racaPet().value
        }
        ],
        cpf: formUpdateUser.cpf().value,
        email: formUpdateUser.email().value,
        endereco: {
        cep: formUpdateUser.cep().value,
        complemento: formUpdateUser.complemento().value,
        logradouro: formUpdateUser.logradouro().value,
        numero: formUpdateUser.numero().value
        },
        nome: formUpdateUser.nome().value,
        telefone: formUpdateUser.telefone().value
    }
}

function updateUsuario() {
    const campos = camposUpdateUser()
    const id = formUpdateUser.id().value

    const result = ClienteService.Update(id,campos).then((item) => {
        console.log('atualizado')
        alert('Cliente atualizado')
        limparUpdate()
    }).catch(error => {
        alert(error)
    })
}

function limparUpdate(){
    document.getElementById("Update_User_Id").value = ""
    document.getElementById("Update_User_Nome").value = ""
    document.getElementById("Update_User_Cpf").value = ""
    document.getElementById("Update_User_Cep").value = ""
    document.getElementById("Update_User_Complemento").value = ""
    document.getElementById("Update_User_Logradouro").value = ""
    document.getElementById("Update_User_Numero").value = ""
    document.getElementById("Update_User_Telefone").value = ""
    document.getElementById("Update_User_Email").value = ""
    document.getElementById("Update_User_Password").value = ""
    document.getElementById("Update_User_NomePet").value = ""
    document.getElementById("Update_User_IdadePet").value = ""
    document.getElementById("Update_User_PesoPet").value = ""
    document.getElementById("Update_User_RacaPet").value = ""
    document.getElementById("Update_User_Altura").value = ""
    document.getElementById("Update_User_Largura").value = ""
}

