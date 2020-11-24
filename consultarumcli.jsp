<%-- 
    Document   : consultarum
    Created on : 26/10/2020, 22:15:25
    Author     : felip
--%>

<%@page import="model.Cliente"%>
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
			<a href="cadastroVenda.jsp" class="tab">VENDAS</a>
			<a href="cadastroProd.jsp" class="tab">PRODUTOS</a>
			<a href="cadastroCli.jsp" class="local">CLIENTES</a>
		</div>

		<div>
			<form class="corpo" action="mantercliente" method="post">
                <span class="texto">
			NOME: <input type="text" name="txtnome"> &nbsp; &nbsp; 
			 
                         CEP: <input type="text" name="txtcep">&nbsp; &nbsp;
			ENDEREÇO: <input type="text" name="txtende">&nbsp; &nbsp; 
                        NUMERO <input type="text" name="txtnum">&nbsp; &nbsp;<br><br>
                        BAIRRO: <input type="text" name="txtbairro">&nbsp; &nbsp;
                         CIDADE: <input type="text" name="txtcidade">&nbsp; &nbsp;
                          UF: <input type="text" name="txtuf">&nbsp; &nbsp;
                          ID: <input type="text" name="txtid">&nbsp; &nbsp;
                        <br><br>
                    </span>

			<h3 align="center">ITEM SELECIONADO PARA CONSULTA:</h3>
			 <%
            
        Cliente m = (Cliente) request.getAttribute("cliid");
           

        %><table border="2" width="50%" align="center"><tr>
			<th>Nome</th>
			
			<th>CEP</th>
                        <th>Endereço</th>
                        <th>Número</th>
                        <th>Bairro</th>
                        <th>Cidade</th>
                        <th>UF</th>
                        <th>ID</th>
            </tr><tr align="center"><td>
                    <%out.print(m.getNome()); %></td>
                <td><%
        out.print(m.getCep());    %></td><td><%
        out.print(m.getEnde());    %></td><td><%
        out.print(m.getNumero());    %></td><td><%
        out.print(m.getBairro());    %></td><td><%
        out.print(m.getCidade());    %></td><td><%
        out.print(m.getUf());    %></td><td><%
        out.print(m.getId());    %></td>
                
          
        
           
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
