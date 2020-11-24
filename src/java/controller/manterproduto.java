/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static api.SA.Consumidora.sendGet;
import com.google.gson.Gson;
import dao.ProdutoDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

/**
 *
 * @author felip
 */
@WebServlet(name = "manterproduto", urlPatterns = {"/manterproduto"})
public class manterproduto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
               
        String mensagem = "";
        
        try{
            String opcadastrar = request.getParameter("btnoperacao");
            //CADASTRAR
            if(opcadastrar.equals("Cadastrar")){
            
                int id = Integer.parseInt(request.getParameter("txtid"));
                String desc = request.getParameter("txtdesc");
                double preco = Double.parseDouble(request.getParameter("txtpreco"));
                int quant = Integer.parseInt(request.getParameter("txtquant"));
                String sobre = request.getParameter("txtsobre");
                
                //criar obj da classe produto
                Produto produto = new Produto();
                
                //setar a descricao entre o obj e o que o usuario digitou, populando
                produto.setId(id);
                produto.setDescricao(desc);
                produto.setPreco(preco);
                produto.setQuant(quant);
                produto.setSobre(sobre);
                
                //criar um obj do produto DAO
                ProdutoDAO proddao = new ProdutoDAO();
                
                //invocar o cadastrar
                proddao.cadastrar(produto);
                
                mensagem = "Cadastrado com Sucesso";
                
            }
            //DELETAR
            else if(opcadastrar.equals("Delete")){
            
                int id = Integer.parseInt(request.getParameter("txtid"));
                
                Produto prod = new Produto();
                
                prod.setId(id);
                
                ProdutoDAO proddao = new ProdutoDAO();
                
                proddao.Delete(prod);
                
                mensagem = "Cadastrado com Sucesso";
            }
            //ATUALIZAR
            else if(opcadastrar.equals("Atualizar")){
            
                String desc = request.getParameter("txtdesc");
                double preco = Double.parseDouble(request.getParameter("txtpreco"));
                int id = Integer.parseInt(request.getParameter("txtid"));
                int quant = Integer.parseInt(request.getParameter("txtquant"));
                String sobre = request.getParameter("txtsobre");
                
                Produto prod = new Produto();
                
                prod.setDescricao(desc);
                prod.setPreco(preco);
                prod.setId(id);
                prod.setQuant(quant);
                prod.setSobre(sobre);
                
                ProdutoDAO proddao = new ProdutoDAO();
                
                proddao.Update(prod);
                
             mensagem = "Cadastrado com Sucesso";
                
            }
            //CONSULTAR UM ITEM
            else if(opcadastrar.equals("Consultar Item")){
            
                 int id = Integer.parseInt(request.getParameter("txtbusca"));
                 
                 Produto prod = new Produto();
                 
                 prod.setId(id);
                 
                 ProdutoDAO proddao = new ProdutoDAO();
                 
                 Produto prodid = proddao.consultarById(prod);
                 
                 request.setAttribute("prodid", prodid);
                request.getRequestDispatcher("/consultarum.jsp").forward(request, response);
            }
            
            //CONSULTAR TODOS
            else if(opcadastrar.equals("Consultar Todos")){
            
                ProdutoDAO proddao = new ProdutoDAO();
                
                List<Produto> prodid = proddao.consultarTodos();
                 
                 request.setAttribute("prodid", prodid);
                request.getRequestDispatcher("/consultartodos.jsp").forward(request, response);
                
            }
            
            else if(opcadastrar.equals("API")){
            
                /* public class Consumidora {*/
                
                int codigoID = Integer.parseInt(request.getParameter("txtid"));
       
        String urlAPI = "http://localhost:8084/CRUDProduto/webresources/produtoservico/Produto/get/"+codigoID;
        String send = sendGet(urlAPI);
        Produto prod = new Gson().fromJson(send, Produto.class);
        
        
        ProdutoDAO proddao = new ProdutoDAO();
        Produto prodid = proddao.consultarById(prod);
                 
                 request.setAttribute("prodid", prodid);
                request.getRequestDispatcher("/consultarum.jsp").forward(request, response);
    
                
            }}
            
            
            
        catch (ClassNotFoundException ex) {
        mensagem = "Erro com Sucesso: "+ ex.getMessage();
        }
        catch(NumberFormatException ex){
           mensagem = "Erro com Sucesso: Está sem dados!!";
       }
        catch (SQLException ex) {
        mensagem = "Erro com Sucesso no SQL: "+ ex.getMessage();
        }
        
                 
                 request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("/Sucesso.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(manterproduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(manterproduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
