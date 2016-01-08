/**
 * 
 */
function teste() {
    "use strict";
    var row = document.createElement("tr");
    var td1 = document.createElement("td");
    var td2 = document.createElement("td");
    
    row.appendChild(td1);
    row.appendChild(td2);
    
    var input = document.createElement("input");
    var teste = document.createTextNode("teste");
    td1.appendChild(input);
    td2.appendChild(teste);
    
    var table = document.getElementById("livros");
    table.appendChild(row);
}