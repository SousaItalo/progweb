/**
 * 
 */
function addCampoAutor() {
    "use strict";
    var row = document.createElement("tr");
    var td1 = document.createElement("td");
    
    row.appendChild(td1);
    
    var input = document.createElement("input");
     
    input.setAttribute("type", "text");
    input.setAttribute("name", "autor");
    
    td1.appendChild(input);
    
    
    var table = document.getElementById("livros");
    table.appendChild(row);
}