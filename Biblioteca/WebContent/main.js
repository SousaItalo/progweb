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

function SomenteNumero(e){
    var tecla=(window.event)?event.keyCode:e.which;   
    if((tecla>47 && tecla<58)) return true;
    else{
    	if (tecla==8 || tecla==0) return true;
	else  return false;
    }
}

function renovar(isbn){
	var form = document.createElement("form");
	form.setAttribute("method", "post");
    form.setAttribute("action", "ControllerServlet");
    
    var input = document.createElement("input");
    input.setAttribute("type", "hidden");
    input.setAttribute("name", "isbn")
    input.setAttribute("value", isbn);
    
    var logic = document.createElement("input");
    logic.setAttribute("type", "hidden");
    logic.setAttribute("name", "logica")
    logic.setAttribute("value", "RenovacaoLogic");
    
    form.appendChild(input);
    form.appendChild(logic);
    
    form.submit();
}