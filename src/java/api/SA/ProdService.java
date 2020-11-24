/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.SA;

import com.google.gson.Gson;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Cliente;
import model.Produto;
import model.Venda;

/**
 * REST Web Service
 *
 * @author felip
 */
@Path("produtoservico")
public class ProdService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProdService
     */
    public ProdService() {
    }

    /**
     * Retrieves representation of an instance of api.SA.ProdService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
       return "Minha primeira API Rest";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Produto/get/{id}")
    public String getProduto(@PathParam("id")int id) {
    
        Produto prod = new Produto();
        
        prod.setId(id);
        
        ProdutoDAO prodao = new ProdutoDAO();
        
        try {
            prod = prodao.consultarById(prod);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Gson g = new Gson();
        
        return g.toJson(prod);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Cliente/get/{id}")
    public String getCliente(@PathParam("id")int id) {
    
        Cliente cli = new Cliente();
        
        cli.setId(id);
        
        ClienteDAO clidao = new ClienteDAO();
        
        try {
            cli = clidao.consultarById(cli);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Gson g = new Gson();
        
        return g.toJson(cli);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Venda/get/{id}")
    public String getVenda(@PathParam("id")int id) {
    
        Venda vend = new Venda();
        
        vend.setId(id);
        
        VendaDAO vendao = new VendaDAO();
        
        try {
            vend = vendao.consultarById(vend);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Gson g = new Gson();
        
        return g.toJson(vend);
    }

    /**
     * PUT method for updating or creating an instance of ProdService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
