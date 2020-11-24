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
import model.Venda;
import util.Conexao;

/**
 *
 * @author felip
 */
public class VendaDAO {
    //CLIENTE DAO
    
    //CADASTRAR
    
     public void cadastrarVen(Venda p) throws ClassNotFoundException, SQLException{
    
        Connection cone = Conexao.getConexao();          
        PreparedStatement comando = cone.prepareStatement("insert into venda (id, idprod, preco, quant, client) values(?,?,?,?,?)");
        comando.setInt(1, p.getId());
        comando.setInt(2, p.getIdprod());
        comando.setDouble(3, p.getPreco());
        comando.setInt(4, p.getQuant());
        comando.setInt(5, p.getClient());
        comando.execute();
        cone.close();
        
             
        
    }
     
     //UPDATE
    public void Update (Venda p) throws ClassNotFoundException, SQLException{
    Connection cone = Conexao.getConexao();
    PreparedStatement comando = cone.prepareStatement("update venda set idprod = ?, preco = ?, quant = ?, client = ? where id=?");
        comando.setInt(5, p.getId());
        comando.setInt(1, p.getIdprod());
        comando.setDouble(2, p.getPreco());
        comando.setInt(3, p.getQuant());
        comando.setInt(4, p.getClient());

    comando.execute();
    comando.close();
    }
    
     //DELETE
    public void Delete (Venda p) throws ClassNotFoundException, SQLException{
    
        Connection cone = Conexao.getConexao();
        PreparedStatement comando = cone.prepareStatement("delete from venda where id=?");
        comando.setInt(1, p.getId());
        comando.execute();
        comando.close();
        
    }
    //CONSULTAR UM SÓ
        public Venda consultarById(Venda ven) throws ClassNotFoundException, SQLException{
    
        Connection cone = Conexao.getConexao();
        PreparedStatement comandoven = cone.prepareStatement("select id, idprod, preco, quant, client from venda where id=?");
        comandoven.setInt(1, ven.getId());
        
        ResultSet result = comandoven.executeQuery();
        Venda p = new Venda();
        
        if(result.next()){
        
            p.setId(result.getInt("id"));
            p.setIdprod(result.getInt("idprod"));
            p.setPreco(result.getDouble("preco"));
            p.setQuant(result.getInt("quant"));
            p.setClient(result.getInt("client"));

            
        }
        cone.close();
        return p;
        
    }
    
    //CONSULTAR TODOS
    public List<Venda> consultarTodos() throws ClassNotFoundException, SQLException {
    
        Connection cone = Conexao.getConexao();
        PreparedStatement comando = cone.prepareStatement("select id, idprod, preco, quant, client from venda");
        
        ResultSet result = comando.executeQuery();
        
        List<Venda> todasVendas = new ArrayList<Venda>();
        
        while(result.next()){
            
            Venda p = new Venda();
            p.setId(result.getInt("id"));
            p.setIdprod(result.getInt("idprod"));
            p.setPreco(result.getDouble("preco"));
            p.setQuant(result.getInt("quant"));
            p.setClient(result.getInt("client"));
            todasVendas.add(p);
            
        }
        cone.close();
        return todasVendas;
    }
       
    
    
    
   
    }
    

