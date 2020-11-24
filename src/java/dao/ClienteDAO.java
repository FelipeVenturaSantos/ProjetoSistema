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
import util.Conexao;

/**
 *
 * @author felip
 */
public class ClienteDAO {
    //CLIENTE DAO
    
    //CADASTRAR
    
     public void cadastrarCli(Cliente p) throws ClassNotFoundException, SQLException{
    
        Connection cone = Conexao.getConexao();
        PreparedStatement comando = cone.prepareStatement("insert into cliente (id, nome, cep, ende, bairro, uf, cidade, numero) values(?,?,?,?,?,?,?,?)");
        comando.setInt(1, p.getId());
        comando.setString(2, p.getNome());
        comando.setInt(3, p.getCep());
        comando.setString(4, p.getEnde());
        comando.setString(5, p.getBairro());
        comando.setString(6, p.getUf());
        comando.setString(7, p.getCidade());
        comando.setInt(8, p.getNumero());
        
        comando.execute();
        cone.close();
        
    }
     
     //UPDATE
    public void Update (Cliente p) throws ClassNotFoundException, SQLException{
    Connection cone = Conexao.getConexao();
    PreparedStatement comando = cone.prepareStatement("update cliente set nome = ?, cep = ?, ende = ?, bairro = ?, uf = ?, cidade = ?, numero = ? where id=?");
        comando.setInt(8, p.getId());
        comando.setString(1, p.getNome());
        comando.setInt(2, p.getCep());
        comando.setString(3, p.getEnde());
        comando.setString(4, p.getBairro());
        comando.setString(5, p.getUf());
        comando.setString(6, p.getCidade());
        comando.setInt(7, p.getNumero());

    comando.execute();
    comando.close();
    }
    
     //DELETE
    public void Delete (Cliente p) throws ClassNotFoundException, SQLException{
    
        Connection cone = Conexao.getConexao();
        PreparedStatement comando = cone.prepareStatement("delete from cliente where id=?");
        comando.setInt(1, p.getId());
        comando.execute();
        comando.close();
        
    }
    //CONSULTAR UM SÓ
        public Cliente consultarById(Cliente cli) throws ClassNotFoundException, SQLException{
    
        Connection cone = Conexao.getConexao();
        PreparedStatement comandocli = cone.prepareStatement("select id, nome, cep, ende, bairro, uf, cidade, numero from cliente where id=?");
        comandocli.setInt(1, cli.getId());
        
        ResultSet result = comandocli.executeQuery();
        Cliente p = new Cliente();
        
        if(result.next()){
        
            p.setId(result.getInt("id"));
            p.setNome(result.getString("nome"));
            p.setCep(result.getInt("cep"));
            p.setEnde(result.getString("ende"));
            p.setBairro(result.getString("bairro"));
            p.setUf(result.getString("uf"));
            p.setCidade(result.getString("cidade"));
            p.setNumero(result.getInt("numero"));
            

            
        }
        cone.close();
        return p;
        
    }
    
    //CONSULTAR TODOS
    public List<Cliente> consultarTodos() throws ClassNotFoundException, SQLException {
    
        Connection cone = Conexao.getConexao();
        PreparedStatement comando = cone.prepareStatement("select id, nome, cep, ende, bairro, uf, cidade, numero from cliente");
        
        ResultSet result = comando.executeQuery();
        
        List<Cliente> todosClientes = new ArrayList<Cliente>();
        
        while(result.next()){
            
            Cliente p = new Cliente();
             p.setId(result.getInt("id"));
            p.setNome(result.getString("nome"));
            p.setCep(result.getInt("cep"));
            p.setEnde(result.getString("ende"));
            p.setBairro(result.getString("bairro"));
            p.setUf(result.getString("uf"));
            p.setCidade(result.getString("cidade"));
            p.setNumero(result.getInt("numero"));
            
            todosClientes.add(p);
            
        }
        cone.close();
        return todosClientes;
        }
    
   
    
    
    
   
    }
    

