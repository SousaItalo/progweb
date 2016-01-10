<jsp:include page="header.jsp"/> 
<h1>Cadastrar Emprestimo</h1>
<form action="ControllerServlet" method="post">
    CPF:<br>
    <input type="text" name="cpf" maxlength="11" onkeypress="return SomenteNumero(event)"><br>
    Senha:<br>
    <input type="password" name="senha"><br>
    Código do(s) livro(s):<br>
    <table id="tabela-livros">
        <tr>
            <td><input type="text" name="isbn"><br></td>
            <td onclick="addCampo('isbn')">Add Livro</td>
        </tr>
    </table>
    <input type="hidden" name="logica" value="CadastraEmprestimoLogic">
    <input type="submit" value="Cadastrar">
</form>
<jsp:include page="footer.jsp"/>