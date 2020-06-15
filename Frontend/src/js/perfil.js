var templateFoto = '<img src="{{FOTO}}" width="100px">';

var templateBio = '<h3> {{NOME}} </h3>' +
                  '<p> ' +
                  '<strong>RACF : </strong> {{RACF}} <br>'+
                  '<strong>EMAIL: </strong> {{EMAIL}} <br>'+
                  '<strong>DEPTO: </strong> {{DEPARTAMENTO}}'+
                  '</p>'+
                  '<strong> Computador </strong> <br>'+
                  'Num Serie : {{NUMSERIE}} <br>'+
                  'Conector  : {{CONECTOR}} <br>'+
                  'Descricao : {{DESCRICAO}} </p>';

var templateSol = '<div class="row">' +
                        '<div class="col-md-12">' + 
                            '<a href="#void" onclick="recuperaDetalhe({{NUMSOL}})" data-toggle="modal" data-target="#popupSolicitacao">' + 
                                '{{ID}} {{DATA}} DE: {{ORIGEM}} | PARA: {{DESTINO}}' +
                            '</a>' +
                        '</div>' +
                    '</div>';

var templateDetSol = '<div class="row">' +
                        '<div class="col-md-12">' + 
                            '<p><strong>Data :</strong> {{DATA}}</p>' +
                            '<p><strong>Departamento Origem :</strong> {{ORIGEM}}</p>' +
                            '<p><strong>Departamento Destino:</strong> {{DESTINO}}</p>' +
                            '<br>'+
                            '<p><strong>Justificativa       :</strong> {{JUSTIFICATIVA}}</p>' +
                            '<p><strong>Comando             :</strong> {{COMANDO}}</p>' +
                        '</div>' +
                    '</div>';

function mostrarPerfil(){
    var userTxt = localStorage.getItem("userVlan");

    if(!userTxt){
        windows.location = "login.html" //não tenho o "token", voltar pro index
    }

    var user = JSON.parse(userTxt); //converti o texto para um objeto javascript

    // a ideia aqui é preencher as coisas

    //foto
    var strFoto = templateFoto.replace("{{FOTO}}",user.linkFoto);
    document.getElementById("fotoUser").innerHTML = strFoto;

    var strBio = templateBio.replace("{{NOME}}",user.nome)
                            .replace("{{RACF}}",user.racf)
                            .replace("{{EMAIL}}",user.email)
                            .replace("{{DEPARTAMENTO}}",user.departamento.nome)
                            .replace("{{NUMSERIE}}",user.computador.numSerie)
                            .replace("{{CONECTOR}}",user.computador.conectorRede)
                            .replace("{{DESCRICAO}}",user.computador.descricao)
    document.getElementById("bioUser").innerHTML = strBio;

    // aqui vem a lista de solicitacoes
    var strSol = "";
    for (i=0; i<user.solicitacoes.length; i++){
        var solic = user.solicitacoes[i]; //apenas para simplificar

        strSol = strSol + templateSol.replace("{{NUMSOL}}", i)
                                     .replace("{{ID}}", solic.numero)
                                     .replace("{{DATA}}", solic.dataSolicitacao)
                                     .replace("{{ORIGEM}}", solic.origem.nome)
                                     .replace("{{DESTINO}}", solic.destino.nome);
    }
    document.getElementById("listaSolicitacoes").innerHTML = strSol;

}

function recuperaDetalhe(sol){
    var userTxt = localStorage.getItem("userVlan");
    var user = JSON.parse(userTxt); //converti o texto para um objeto javascript
    
    var solic = user.solicitacoes;
    //console.log(solic);

    var strDetSol;
    strDetSol =  templateDetSol.replace("{{DATA}}", solic[sol].dataSolicitacao)
                                          .replace("{{ORIGEM}}", solic[sol].origem.nome)
                                          .replace("{{DESTINO}}", solic[sol].destino.nome)
                                          .replace("{{JUSTIFICATIVA}}", solic[sol].justificativa)
                                          .replace("{{COMANDO}}", solic[sol].comandoRoteador);

    
    document.getElementById("detalheSolicitacao").innerHTML = strDetSol;
}

function logout(){
    localStorage.removeItem("userVlan");
    window.location = "login.html";
}