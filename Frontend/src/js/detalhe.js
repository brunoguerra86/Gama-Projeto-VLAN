function recuperaDetalhe(){
    var parametro = window.location.search;
    var numero = parametro.substr(8);
    
    //console.log("link da url: " + parametro);
    //console.log("numero: " + numero);

    fetch("http://localhost:8080/solicitacoes/"+numero)
        .then(res => res.json())
        .then(res => console.log(res));


}

