<%-- 
    Document   : consultarum
    Created on : 26/10/2020, 22:15:25
    Author     : felip
--%>

<%@page import="model.Produto"%>
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

			<h3 align="center">ITEM SELECIONADO PARA CONSULTA:</h3>
			 <%
            
        Produto m = (Produto) request.getAttribute("prodid");
           

        %><table border="2" width="50%" align="center"><tr>
			<th>Código</th>
			<th>Produto</th>
			<th>Valor Unidade</th>
                        <th>Quantidade</th>
                        <th>Descricao</th>
            </tr><tr align="center"><td>
                    <%out.print(m.getId()); %></td>
                <td><%
        out.print(m.getDescricao());    %></td><td><%
        out.print(m.getPreco());    %></td><td><%
        out.print(m.getQuant());    %></td><td><%
            out.print(m.getSobre());    %></td></tr>
          
        
           
        </table>

			<br><br>
            <span class="texto">
			BUSCAR ITEM: <input type="text" name="txtbuscar">                         
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
