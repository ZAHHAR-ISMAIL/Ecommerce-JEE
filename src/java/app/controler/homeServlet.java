/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controler;

import app.model.bo.ArticleModel;
import app.model.dao.DAOArticle;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import app.model.bo.ArticleModel;
import app.model.bo.Client;
import app.model.bo.ClientModel;
import app.model.bo.Ligne;
import app.model.bo.LigneId;
import app.model.bo.ModelCollection;
import app.model.bo.Panier;
import app.model.bo.PanierModel;
import app.model.dao.DAOClient;
import app.model.dao.DAOLigne;
import app.model.dao.DAOPanier;
/**
 *
 * @author ISMAIL
 */
public class homeServlet extends HttpServlet {

     private DAOArticle DAOarticle;
     private DAOClient DAOclient;
     private DAOLigne DAOligne;
     private DAOPanier DAOpanier;
     PanierModel Pmodel;// = new PanierModel();
     ArticleModel Amodel;
     ClientModel Cmodel;
             
	@Override
	public void init() throws ServletException {
		DAOarticle = DAOArticle.GetInstance();
                DAOclient = DAOClient.GetInstance();
                DAOligne = DAOLigne.GetInstance();
                DAOpanier = DAOPanier.GetInstance();
                Pmodel = new PanierModel();
                Amodel = new ArticleModel();
                Cmodel = new ClientModel();
	}
        
        public homeServlet(){
            super();
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

       int res;
        Amodel.setArticles(DAOarticle.retreive());
        request.setAttribute("Amodel", Amodel);
        request.setAttribute("Pmodel", Pmodel);
        request.setAttribute("Cmodel", Cmodel);
        
        String action = request.getParameter("action");
        if (action != null) 
        {
            if (action.equals("addToCard")) 
            {
                Pmodel.addPanier(new ModelCollection
                (
                      DAOarticle.retreiveOne(Integer.parseInt(request.getParameter("id"))), 1
                ));
                Pmodel.setTotal();
                
            }
            
            else if (action.equals("viewCart")) 
            {
                request.getRequestDispatcher("/Panier.jsp").forward(request, response);
                return; 
            }
            
            else if (action.equals("checkout")) 
            {
                if(Cmodel.getClient() == null)
                {
                    request.getRequestDispatcher("/Login.jsp").forward(request, response);
                    return; 
                }else{
                    for(ModelCollection CC: Pmodel.getArticles()){
                        if(CC.getQte() > DAOarticle.retreiveOne(CC.getArticle().getIdArticle()).getNbStock())
                        {
                            request.getRequestDispatcher("/Error.jsp").forward(request, response);					
                            return;
                        }   
                    }
                    int iid = DAOpanier.create(new Panier(Cmodel.getClient(),false));
                    Panier p = DAOpanier.retreiveLast();
                    for(ModelCollection C: Pmodel.getArticles()){
                        C.getArticle().setNbStock(C.getArticle().getNbStock() - C.getQte());
                        DAOarticle.update(C.getArticle());
                        //if( p != null){
                            DAOligne.create(new Ligne(new LigneId(iid, C.getArticle().getIdArticle()),
                            C.getArticle(), DAOpanier.retreiveOne(iid), C.getQte()));
                        //}
                    }
                    Pmodel.refreshPanier();
                    request.getRequestDispatcher("/Payement.jsp").forward(request, response);					
                    return;
                }
            }
            else if (action.equals("Register")) {
				
				res = DAOclient.testExist(request.getParameter("e"));
				if( res == 0)
				{				
                                    Cmodel.setClient(
                                        new Client(request.getParameter("l"),
					request.getParameter("f"),
					request.getParameter("e"),
                                        request.getParameter("p"),
                                        request.getParameter("a"),
                                        request.getParameter("t")
                                    ));
                                    
                                    DAOclient.create(Cmodel.getClient());
                                    request.getRequestDispatcher("/Panier.jsp").forward(request, response);
                                    return;    
                    
					
				        
				}
                                else{ 
                                    request.getRequestDispatcher("/Login.jsp?err=true").forward(request, response);					
                                    return;
                                }				
			
            }
            else if (action.equals("Login")) {
               
                for(Client C: DAOclient.retreive()){
                    if(C.getEmail().equals(request.getParameter("ee")) && C.getMdp().equals(request.getParameter("pp")))
                    {
                        Cmodel.setClient(C);
                        request.getRequestDispatcher("/Panier.jsp").forward(request, response);
                        return; 
                    }
                }
                
                request.getRequestDispatcher("/Login.jsp?err=true").forward(request, response);
                return; 
            }
            else if (action.equals("show")) {
                
                Amodel.setArticles(DAOarticle.retreiveCategorie(request.getParameter("categorie")));
                
                request.getRequestDispatcher("/Home.jsp").forward(request, response);
                return; 
            }
            
            else if (action.equals("logout")) {
                
                Cmodel.logOut();
                
                request.getRequestDispatcher("/Home.jsp").forward(request, response);
                return; 
            }
        }
        
        request.getRequestDispatcher("/Home.jsp").forward(request, response);

        
        //request.getRequestDispatcher("/index.html").forward(request, response);
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
