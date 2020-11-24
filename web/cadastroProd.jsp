<%-- 
    Document   : cadastroProd
    Created on : 26/10/2020, 18:43:04
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
			<a href="cadastroProd.jsp" class="local">PRODUTOS</a>
			<a href="cadastroCli.jsp" class="tab">CLIENTES</a>
		</div>

		<div>
			<form class="corpo" action="manterproduto" method="post">
                            <span class="texto">
                                CÓDIGO: <input type="text" name="txtid" placeholder="01, 02, 03...">
                                &nbsp; &nbsp; 
                                NOME PRODUTO: <input type="text" name="txtdesc" placeholder="Produto...">
                                &nbsp; &nbsp; 
                                PREÇO: <input type="text" name="txtpreco" placeholder="Valor...">
                                &nbsp; &nbsp;<br><br>
                                QUANTIDADE NO ESTOQUE: <input type="text" name="txtquant" placeholder="Quantidade disponivel...">
                                &nbsp; &nbsp;
                                SOBRE: <input type="text" name="txtsobre" placeholder="Descrição Não Obrigatória">
                                &nbsp; &nbsp;<br><br>
                                <br><br>

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
                            <input type="submit" name="btnoperacao" value="API" title="Por favor, Digite o ID!">
                        </span>
            

		</form>
		</div>

	</div>

</body>
</html>
