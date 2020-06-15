function logout(){
    localStorage.removeItem("userVlan");
    window.location = "login.html";
}

function buscaDepartamentos(){
    fetch("http://localhost:8080/departamentos")
        .then(resultado => resultado.json())
        .then(resultado => preenchLinhas(resultado));
}

function preenchLinhas(lista){

    var templateDep  =  '<div class="row">'+
                            '<div class="col px-md-12">'+
                                '<a>'+
                                    'ID: {{NUMDEP}} Nome: {{NOME}}  VLan: {{VLAN}}'+
                                '</a>'+
                            '</div>'+
                        '</div>';
    var strDep = "";
    for (i=0 ; i<lista.length ; i++){
        var dep = lista[i];   // apenas para simplificar
        strDep = strDep + templateDep.replace("{{NUMDEP}}",dep.id)
                                      .replace("{{NOME}}",dep.nome)
                                      .replace("{{VLAN}}",dep.vlan);
    }
    document.getElementById("listaDepartamentos").innerHTML = strDep;                    

}