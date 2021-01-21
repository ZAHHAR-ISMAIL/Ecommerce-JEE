/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controler;

import app.model.bo.Admin;
import app.model.bo.Article;
import app.model.bo.ArticleModel;
import app.model.bo.ClientModel;
import app.model.bo.PanierModel;
import app.model.dao.DAOAdmin;
import app.model.dao.DAOArticle;
import app.model.dao.DAOClient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ISMAIL
 */
public class adminServlet extends HttpServlet {

     private DAOArticle DAOarticle;
     private DAOClient DAOclient;
     //private DAOAdmin DAOadmin;
     
     PanierModel Pmodel;// = new PanierModel();
     ArticleModel Amodel;
     ClientModel Cmodel;
     
     boolean admin;
	@Override
	public void init() throws ServletException {
		DAOarticle = DAOArticle.GetInstance();
                DAOclient = DAOClient.GetInstance();
                Pmodel = new PanierModel();
                Amodel = new ArticleModel();
                Cmodel = new ClientModel();
                admin = false;
	}
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        doPost(request, response);
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
        
        Amodel.setArticles(DAOarticle.retreive());
        request.setAttribute("Amodel", Amodel);
        
        String action = request.getParameter("action");
        if (action != null) 
        {
            if (action.equals("LogIn")) 
            {
                for(Admin C:new DAOAdmin().retreive()){
                if(C.getUsername().equals(request.getParameter("ll")) && C.getPassword().equals(request.getParameter("pp")))
                //if(C.getEmail().equals(request.getParameter("ee")) && C.getMdp().equals(request.getParameter("pp")))
                    {
                        //Cmodel.setClient(C);
                        admin = true;
                        request.getRequestDispatcher("/AdminListArticles.jsp").forward(request, response);
                        return; 
                    }
                }
                
                request.getRequestDispatcher("/LoginAdmin.jsp?err=true").forward(request, response);
                return; 
            }
            else if (action.equals("add")){
                request.getRequestDispatcher("/AdminAddArticle.jsp").forward(request, response);
                return; 
            }
            else if (action.equals("addArticle")){
                 DAOarticle.create( new Article(request.getParameter("i"),
					Integer.parseInt( request.getParameter("n") ),
					Double.parseDouble( request.getParameter("p") ),
                                        request.getParameter("c"),
                                        request.getParameter("d")
                                       
                                    ));
                                    
                 Amodel.setArticles(DAOarticle.retreive());              
                
                request.getRequestDispatcher("/AdminListArticles.jsp").forward(request, response);
                return; 
            }
        }
        if(admin){
            request.getRequestDispatcher("/AdminListArticles.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("/LoginAdmin.jsp").forward(request, response);
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
