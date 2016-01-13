function addCampo(nome) {
    "use strict";
    var row = document.createElement("tr");
    var td1 = document.createElement("td");
    
    row.appendChild(td1);
    
    var input = document.createElement("input");
     
    input.setAttribute("type", "text");
    input.setAttribute("name", nome);
    input.setAttribute("class", "form-control");
    
    td1.appendChild(input);
    
    
    var table = document.getElementById("tabela-livros");
    table.appendChild(row);
}

function SomenteNumero(e){
    var tecla=(window.event)?event.keyCode:e.which;   
    if((tecla>47 && tecla<58)) return true;
    else{
    	if (tecla==8 || tecla==0) return true;
	else  return false;
    }
}
