/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.VendaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Venda;

/**
 *
 * @author felip
 */
@WebServlet(name = "mantervenda", urlPatterns = {"/mantervenda"})
public class mantervenda extends HttpServlet {

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
                int idprod = Integer.parseInt(request.getParameter("txtidprod"));
                double preco = Integer.parseInt(request.getParameter("txtpreco"));
                int quant = Integer.parseInt(request.getParameter("txtquant"));
                int cliente = Integer.parseInt(request.getParameter("txtsobre"));
                
                //criar obj da classe produto
                Venda venda = new Venda();
                
                //setar a descricao entre o obj e o que o usuario digitou, populando
                venda.setId(id);
                venda.setIdprod(idprod);
                venda.setPreco(preco);
                venda.setQuant(quant);
                venda.setClient(cliente);
                
                //criar um obj do produto DAO
                VendaDAO vendao = new VendaDAO();
                
                //invocar o cadastrar
                vendao.cadastrarVen(venda);
                
                mensagem = "Cadastrado com Sucesso";
            }
            
            //ATUALIZAR
            else if(opcadastrar.equals("Atualizar")){
            
               int id = Integer.parseInt(request.getParameter("txtid"));
                int idprod = Integer.parseInt(request.getParameter("txtidprod"));
                double preco = Integer.parseInt(request.getParameter("txtpreco"));
                int quant = Integer.parseInt(request.getParameter("txtquant"));
                int cliente = Integer.parseInt(request.getParameter("txtsobre"));
                
                //criar obj da classe produto
                Venda venda = new Venda();
                
                //setar a descricao entre o obj e o que o usuario digitou, populando
                venda.setId(id);
                venda.setIdprod(idprod);
                venda.setPreco(preco);
                venda.setQuant(quant);
                venda.setClient(cliente);
                
                VendaDAO vendao = new VendaDAO();
                
                vendao.Update(venda);
                
                mensagem = "Cadastrado com Sucesso";
                
            }
            
            //DELETAR
            else if(opcadastrar.equals("Delete")){
            
                int id = Integer.parseInt(request.getParameter("txtid"));
                
                Venda venda = new Venda();
                
                venda.setId(id);
                
                VendaDAO vendao = new VendaDAO();
                
                vendao.Delete(venda);
                
                mensagem = "Cadastrado com Sucesso";
            }
            
            //CONSULTAR UM ITEM
            else if(opcadastrar.equals("Consultar Item")){
            
                 int id = Integer.parseInt(request.getParameter("txtbusca"));
                 
                 Venda venda = new Venda();
                 
                 venda.setId(id);
                 
                  VendaDAO vendao = new VendaDAO();
                 
                 Venda vendaid = vendao.consultarById(venda);
                 
                 request.setAttribute("vendaid", vendaid);
                request.getRequestDispatcher("/consultarumven.jsp").forward(request, response);
            }
                       
            
            //CONSULTAR TODOS
            else if(opcadastrar.equals("Consultar Todos")){
            

                VendaDAO vendao = new VendaDAO();
                
                List<Venda> vendaid = vendao.consultarTodos();
                 
                 request.setAttribute("vendaid", vendaid);
                request.getRequestDispatcher("/consultartodosven.jsp").forward(request, response);
                
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
                request.getRequestDispatcher("/SucessoVen.jsp").forward(request, response);
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
