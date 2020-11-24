<%-- 
    Document   : consultarum
    Created on : 26/10/2020, 22:15:25
    Author     : felip
--%>

<%@page import="model.Venda"%>
<%@page import="model.Cliente"%>
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
			<a href="cadastroVenda.jsp" class="local">VENDAS</a>
			<a href="cadastroProd.jsp" class="tab">PRODUTOS</a>
			<a href="cadastroCli.jsp" class="tab">CLIENTES</a>
		</div>

		<div>
			<form class="corpo" action="mantervenda" method="post">
                <span class="texto">
			CÓDIGO DA VENDA: <input type="text" name="txtid"> &nbsp; &nbsp; 
			CÓDIGO DO PRODUTO: <input type="text" name="txtidprod">&nbsp; &nbsp; 
			VALOR DO PRODUTO: <input type="text" name="txtpreco">&nbsp; &nbsp;<br><br>
                        QUANTIDADE VENDIDA: <input type="text" name="txtquant">&nbsp; &nbsp;
                         ID CLIENTE: <input type="text" name="txtsobre">&nbsp; &nbsp;
                        <br><br>
                    </span>

			<h3 align="center">ITEM SELECIONADO PARA CONSULTA:</h3>
			 <%
            
        Venda m = (Venda) request.getAttribute("vendaid");
           

        %><table border="2" width="50%" align="center"><tr>
			<th>Código</th>
			<th>Produto</th>
			<th>Valor Unidade</th>
                        <th>Quantidade Vendida</th>
                        <th>ID Cliente</th>
            </tr><tr align="center"><td><% out.print(m.getId());%></td><td><%
            out.print(m.getIdprod());%></td><td><%
                out.print(m.getPreco());%></td><td><%
                out.print(m.getQuant());%></td><td><%
                out.print(m.getClient());%></td></tr>
                
          
        
           
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
