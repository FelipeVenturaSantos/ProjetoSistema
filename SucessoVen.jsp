<%-- 
    Document   : Sucesso
    Created on : 23/11/2020, 23:10:30
    Author     : felip
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Sistema Administrativo - Produtos</title>
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
                                CÓDIGO DA VENDA: <input type="text" name="txtid" placeholder="01, 02, 03 ..."> 
					&nbsp; &nbsp; 
					CÓDIGO DO PRODUTO: <input type="text" name="txtidprod" placeholder="Código produto cadastrado">
					&nbsp; &nbsp; 
					VALOR DO PRODUTO: <input type="text" name="txtpreco" placeholder="Valor Produtos selecionado">
					&nbsp; &nbsp;<br><br>
                    QUANTIDADE VENDIDA: <input type="text" name="txtquant" placeholder="Quantidade venda">
                    &nbsp; &nbsp;
                    ID CLIENTE: <input type="text" name="txtsobre" placeholder="Código cliente">
                    &nbsp; &nbsp;<br><br>
                                <br><br><br><br>
                                
                                <%
            String m = (String) request.getAttribute("mensagem");
            out.println(m);
        %>
<br><br><br><br>
                                BUSCAR ITEM: <input type="text" name="txtbusca" placeholder="Pesquisar um item">  
                            </span>                       
                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 

                        <span class="botoes">
                            <input type="submit" name="btnoperacao" value="Consultar Item">
                            &nbsp; &nbsp;
                            <input type="submit" name="btnoperacao" value="Consultar Todos">
                            <br><br>
                            <input type="submit" name="btnoperacao" value="Cadastrar">
                            <input type="submit" name="btnoperacao" value="Delete">
                            <input type="submit" name="btnoperacao" value="Atualizar">
                        </span>
            

		</form>
		</div>

	</div>

</body>
</html>