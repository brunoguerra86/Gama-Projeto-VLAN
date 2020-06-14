function autenticar(){
    var txtEmail = document.getElementById("txtEmail").value;
    var txtSenha = document.getElementById("txtSenha").value;

    //console.log(txtEmail + " / " + txtSenha);


    var loginMsg = {
        email    : txtEmail,
        senha    : txtSenha
    }

    var cabecalho = {
        method : 'POST',
        body   : JSON.stringify(loginMsg),
        headers : {
            'Content-type' : 'application/json'
        }
    }

    fetch("http://localhost:8080/login", cabecalho)
        .then(res => tratarResultado(res));
}

function tratarResultado(res){
    if (res.status == 200){
        document.getElementById("erroMSG").innerHTML = "";
        res.json().then(res => logarUsuario(res));
    }
    else if (res.status == 403){ 
        document.getElementById("erroMSG").innerHTML = "<h3>Senha Inválida</h3>";
    }
    else if (res.status == 404){
        document.getElementById("erroMSG").innerHTML = "<h3>Usuário não cadastrado</h3>";
    }
}

function logarUsuario(res){
    //em uma aplicação real não deve armazenar o objeto e sim um token
    localStorage.setItem("userVlan",JSON.stringify(res));
    window.location="perfil.html";
}

function keydown(){
    if (event.keyCode === 13) {
        autenticar();
    }
}