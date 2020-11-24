/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author felip
 */
@WebServlet(name = "mantercliente", urlPatterns = {"/mantercliente"})
public class mantercliente extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
               
        String mensagem = "";
        
        try{
            
            String opcadastrar = request.getParameter("btnoperacao");
            //CADASTRAR
            if(opcadastrar.equals("Cadastrar")){
            
                int id = Integer.parseInt(request.getParameter("txtid"));
                
                String nome = request.getParameter("txtnome");
                int cep = Integer.parseInt(request.getParameter("txtcep"));
                String cidade = request.getParameter("txtcidade");
                String bairro = request.getParameter("txtbairro");
                String ende = request.getParameter("txtende");
                String uf = request.getParameter("txtuf");
                int numero =  Integer.parseInt(request.getParameter("txtnum"));
                
                //criar obj da classe produto
                Cliente cliente = new Cliente();
                
                //setar a descricao entre o obj e o que o usuario digitou, populando
                cliente.setId(id);
              
                cliente.setNome(nome);
                cliente.setCep(cep);
                cliente.setCidade(cidade);
                cliente.setBairro(bairro);
                cliente.setEnde(ende);
                cliente.setUf(uf);
                cliente.setNumero(numero);
                
                //criar um obj do produto DAO
                ClienteDAO clidao = new ClienteDAO();
                
                //invocar o cadastrar
                clidao.cadastrarCli(cliente);
                
                
                mensagem = "Cadastrado com Sucesso";
            }
            
            //ATUALIZAR
            else if(opcadastrar.equals("Atualizar")){
            
                int id = Integer.parseInt(request.getParameter("txtid"));
                
                String nome = request.getParameter("txtnome");
                int cep = Integer.parseInt(request.getParameter("txtcep"));
                String cidade = request.getParameter("txtcidade");
                String bairro = request.getParameter("txtbairro");
                String ende = request.getParameter("txtende");
                String uf = request.getParameter("txtuf");
                int numero =  Integer.parseInt(request.getParameter("txtnum"));
                
                Cliente cliente = new Cliente();
                
                cliente.setId(id);
                
                cliente.setNome(nome);
                cliente.setCep(cep);
                cliente.setCidade(cidade);
                cliente.setBairro(bairro);
                cliente.setEnde(ende);
                cliente.setUf(uf);
                cliente.setNumero(numero);
                
                ClienteDAO clidao = new ClienteDAO();
                
                clidao.Update(cliente);
                
               mensagem = "Cadastrado com Sucesso";
                
            }
            
            //DELETAR
            else if(opcadastrar.equals("Delete")){
            
                int id = Integer.parseInt(request.getParameter("txtid"));
                
                Cliente cliente = new Cliente();
                
                cliente.setId(id);
                
                ClienteDAO clidao = new ClienteDAO();
                
                clidao.Delete(cliente);
                
               mensagem = "Cadastrado com Sucesso";
            }
            
            //CONSULTAR UM ITEM
            else if(opcadastrar.equals("Consultar Item")){
            
                 int id = Integer.parseInt(request.getParameter("txtbuscar"));
                 
                 Cliente cliente = new Cliente();
                 
                 cliente.setId(id);
                 
                 ClienteDAO clidao = new ClienteDAO();
                 
                 Cliente cliid = clidao.consultarById(cliente);
                 
                 request.setAttribute("cliid", cliid);
                request.getRequestDispatcher("/consultarumcli.jsp").forward(request, response);
            }
                       
            
            //CONSULTAR TODOS
            else if(opcadastrar.equals("Consultar Todos")){
           
                ClienteDAO clidao = new ClienteDAO();
                
                List<Cliente> cliid = clidao.consultarTodos();
                 
                 request.setAttribute("cliid", cliid);
                request.getRequestDispatcher("/consultartodoscli.jsp").forward(request, response);
                
            }
            
            
            
            
        } catch (ClassNotFoundException ex) {
        mensagem = "Erro com Sucesso: "+ ex.getMessage();
        }
       catch(NumberFormatException ex){
           mensagem = "Erro com Sucesso: Está sem dados!!";
       }
        catch (SQLException ex) {
        mensagem = "Erro com Sucesso no SQL: "+ ex.getMessage();
        }
        
        request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("/SucessoCli.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
