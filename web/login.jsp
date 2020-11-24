<%-- 
    Document   : login
    Created on : 24/11/2020, 15:41:24
    Author     : felip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<meta charset="utf-8">
	<style type="text/css">
		
		body{
			background: #f0f0f0;
		}

		.fundo{
			box-shadow: 1px 2px 5px #ccc;
			background-color: white;
			padding: 30px;
			border-radius: 5px;
		}

		.formulario{
			width: 400px;
			margin: auto;
			padding-top: 40px;

		}

		.topo{
			text-align: center;
		}

		.baixo{
			margin-bottom: 10px;
		}

		.baixo>label{
			width: 100%;
			color: #ccc;
			display: block;
		}

		.baixo>input{
			border-radius: 5px;
			outline: 0;
			width: 100%;
			height: 25px;
			padding: 5px;
		}

		.baixo>button{
			background-image: linear-gradient(to right, black, #ccc);
			color: white;
			width: 100%;
			border-radius: 30px;
			padding: 25px;
			border: 0px;
			outline: 0;
		}

		button:hover{
			background-image: linear-gradient(to left, black, #ccc);
		}

		img{
			border-radius: 50px;
			width: 100px;
			box-shadow: 1px 1px 5px #ccc;
		}

		h2{
			color: black;
		}

		p{
			color: #ccc;
		}

	</style>

</head>
<body>

    <form class="formulario" action="cadastroProd.jsp" method="post">
		
		<div class="fundo">

			<div class="topo">
				
				<img src="Imagens/User.png">
				<h2>Sistema Administrativo</h2>
				<p>Vendas, Produtos e Clientes</p>

			</div>

			<div class="baixo">
				
				<label>EMAIL</label>
				<input type="email" name="email" placeholder="Digite o Email de Login" required>

			</div>
			<div class="baixo">
				
				<label>SENHA</label>
				<input type="password" name="senha" placeholder="Digite a senha de Login" required>

			</div>
			<div class="baixo">
				
				<label><input type="checkbox" name="lembrar"> Lembre-me</label>
				
			</div>

			<div class="baixo">
				
				<button type="submit" name="btnoperação" value="Logar">LOGAR</button>
				
			</div>
			
		</div>

	</form>

</body>
</html>