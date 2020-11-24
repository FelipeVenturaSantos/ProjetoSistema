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
			<a href="cadastroVenda.jsp" class="tab">VENDAS</a>
			<a href="cadastroProd.jsp" class="tab">PRODUTOS</a>
			<a href="cadastroCli.jsp" class="local">CLIENTES</a>
		</div>

		<div>
			<form class="corpo" action="mantercliente" method="post">
                            <span class="texto">
                                NOME: <input type="text" name="txtnome" placeholder="Nome..."> 
							&nbsp; &nbsp; 
							
                         	CEP: <input type="text" name="txtcep" placeholder="Não Obrigatório">
                         	&nbsp; &nbsp;
							ENDEREÇO: <input type="text" name="txtende" placeholder="Endereço...">
							&nbsp; &nbsp; 
                        	NUMERO: <input type="text" name="txtnum" placeholder="Número...">
                        	&nbsp; &nbsp;<br><br>
                        	BAIRRO: <input type="text" name="txtbairro" placeholder="Não Obrigatório">
                        	&nbsp; &nbsp;
                         	CIDADE: <input type="text" name="txtcidade" placeholder="Cidade...">
                         	&nbsp; &nbsp;
                          	UF: <input type="text" name="txtuf" placeholder="Não Obrigatório">
                          	&nbsp; &nbsp;
                         	ID: <input type="text" name="txtid" placeholder="Código de Cliente...">
                         	&nbsp; &nbsp;
                        	<br><br>	
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