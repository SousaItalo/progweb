function addCampo(nome) {
    "use strict";
    var row = document.createElement("tr");
    var td1 = document.createElement("td");
    
    row.appendChild(td1);
    
    var input = document.createElement("input");
     
    input.setAttribute("type", "text");
    input.setAttribute("name", nome);
    
    td1.appendChild(input);
    
    
    var table = document.getElementById("tabela-livros");
    table.appendChild(row);
}
