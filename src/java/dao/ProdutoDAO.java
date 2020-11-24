/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Produto;
import util.Conexao;

/**
 *
 * @author felip
 */
public class ProdutoDAO {
    //INSERIR
    public void cadastrar(Produto p) throws ClassNotFoundException, SQLException{
    
        Connection cone = Conexao.getConexao();
        PreparedStatement comando = cone.prepareStatement("insert into Produto (id, descricao, preco, quant, sobre) values(?,?,?,?,?)");
        comando.setInt(1, p.getId());
        comando.setString(2, p.getDescricao());
        comando.setDouble(3, p.getPreco());
        comando.setInt(4, (int) p.getQuant());
        comando.setString(5, p.getSobre());
        comando.execute();
        cone.close();
        
    }
    
    //CONSULTAR UM SÓ
        public Produto consultarById(Produto prod) throws ClassNotFoundException, SQLException{
    
        Connection cone = Conexao.getConexao();
        PreparedStatement comando = cone.prepareStatement("select id, descricao, preco, quant, sobre from produto where id=?");
        comando.setInt(1, prod.getId());
        
        ResultSet resultado = comando.executeQuery();
        Produto p = new Produto();
        if(resultado.next()){
        
            p.setId(resultado.getInt("id"));
            p.setDescricao(resultado.getString("descricao"));
            p.setPreco(resultado.getDouble("preco"));
            p.setQuant(resultado.getInt("quant"));
            p.setSobre(resultado.getString("sobre"));
            
        }
        cone.close();
        return p;
        
    }
    //CONSULTAR TODOS
    public List<Produto> consultarTodos() throws ClassNotFoundException, SQLException {
    
        Connection cone = Conexao.getConexao();
        PreparedStatement comando = cone.prepareStatement("select id, descricao, preco, quant, sobre from Produto");
        
        ResultSet resultado = comando.executeQuery();
        
        List<Produto> todosProdutos = new ArrayList<Produto>();
        
        while(resultado.next()){
            
            Produto p = new Produto();
            p.setId(resultado.getInt("id"));
            p.setDescricao(resultado.getString("descricao"));
            p.setPreco(resultado.getDouble("preco"));
            p.setQuant(resultado.getInt("quant"));
            p.setSobre(resultado.getString("sobre"));
            todosProdutos.add(p);
            
        }
        cone.close();
        return todosProdutos;
        }
    
    //UPDATE
    public void Update (Produto p) throws ClassNotFoundException, SQLException{
    Connection cone = Conexao.getConexao();
    PreparedStatement comando = cone.prepareStatement("update Produto set Descricao = ?, Preco = ?, quant = ?, sobre = ? where id=?");
    comando.setString(1, p.getDescricao());
    comando.setDouble(2, p.getPreco());    
    comando.setInt(3, (int) p.getQuant());
    comando.setString(4, p.getSobre());
    comando.setInt(5, p.getId());
    comando.execute();
    comando.close();
    }

    //DELETE
    public void Delete (Produto p) throws ClassNotFoundException, SQLException{
    
        Connection cone = Conexao.getConexao();
        PreparedStatement comando = cone.prepareStatement("delete from Produto where id=?");
        comando.setInt(1, p.getId());
        comando.execute();
        comando.close();
        
    }
    
    
   
    }
    

