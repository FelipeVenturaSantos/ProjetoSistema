<%-- 
    Document   : consultartodos
    Created on : 26/10/2020, 23:00:25
    Author     : felip
--%>

<%@page import="java.util.List"%>
<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Sistema Administrativo - Consulta</title>
        <link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>

	<div id="tabela" align="center">
		
		<div class="display">
			<a href="cadastroVenda.jsp" class="tab">VENDAS</a>
			<a href="cadastroProd.jsp" class="local">PRODUTOS</a>
			<a href="cadastroCli.jsp" class="tab">CLIENTES</a>
		</div>

		<div>
			<form class="corpo" action="manterproduto" method="post">
                <span class="texto">
                        CÓDIGO: <input type="text" name="txtid"> &nbsp; &nbsp; 
                        NOME PRODUTO: <input type="text" name="txtdesc">&nbsp; &nbsp; 
                        PREÇO: <input type="text" name="txtpreco">&nbsp; &nbsp;<br><br>
                        QUANTIDADE NO ESTOQUE: <input type="text" name="txtquant">&nbsp; &nbsp;
                        SOBRE: <input type="text" name="txtsobre">&nbsp; &nbsp;
                        <br><br>
                </span>

			<h3 align="center">LISTA DE PRODUTOS CADASTRADOS:</h3><%
            
        List<Produto> m = (List<Produto>) request.getAttribute("prodid");
           
        %>
        <table border="2" width="50%" align="center">
            <tr>
			            <th>Código</th>
			            <th>Produto</th>
			            <th>Valor Unidade</th>
                        <th>Quantidade</th>
                        <th>Descrição</th>
                        <th>Excluir</th>
            </tr>
            <%

        for(Produto prod : m){
        
%>
<tr align="center">
    <td><% out.print(prod.getId());%></td>
    <td><% out.print(prod.getDescricao());%></td>
    <td><% out.print(prod.getPreco());%></td>
    <td><% out.print(prod.getQuant());%></td>
    <td><% out.print(prod.getSobre());%></td>
    <td> <a href="http://localhost:8084/CRUDProduto/manterproduto?txtid=<%out.print(prod.getId());%>&btnoperacao=Delete" class="excluir"><img src="Imagens/lixeira.png" width="90"></a><% %></td>

</tr><%
            
        }
        %>          
        
           
        </table>

			<br><br>
            <span class="texto">
			BUSCAR ITEM: <input type="text" name="txtbusca">  
            </span>                      
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;

            <span class="botoes"> 
            <input type="submit" name="btnoperacao" value="Consultar Item"> &nbsp; &nbsp;
            <input type="submit" name="btnoperacao" value="Consultar Todos"><br><br>
            <input type="submit" name="btnoperacao" value="Cadastrar">
            <input type="submit" name="btnoperacao" value="Delete">
            <input type="submit" name="btnoperacao" value="Atualizar">
        </span>
           
            

		</form>
		</div>

	</div>

</body>
</html>
