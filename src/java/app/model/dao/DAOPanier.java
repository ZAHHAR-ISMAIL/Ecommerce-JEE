/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.dao;

import app.model.bo.Panier;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author ISMAIL
 */
public class DAOPanier {
    private static DAOPanier instance;
    private DAOPanier(){}
    
    public static DAOPanier GetInstance(){
        if(instance == null) instance = new DAOPanier();
        
        return instance;
    }
    
    public Integer create(Panier C) {
        Transaction tx = null;
        int id = 0;
        
        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.save(C);
            id = C.getIdPanier();
            tx.commit();
               
        }
        catch(HibernateException e){
            e.printStackTrace();
            tx.rollback();
        }
        
        return id;
    }
    
    public Panier retreiveLast () {
        Transaction tx = null;
        Panier panier = null;
    	try
    	{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            Query q = session.createQuery("from Panier ORDER BY id_panier DESC LIMIT 1");
            panier = (Panier) q.uniqueResult();
            tx.commit();
                        
            return panier;
    	}
    	catch(HibernateException e){
            e.printStackTrace();
            tx.rollback();
        }
        return panier;
    }
    
    public Panier retreiveOne (int id) {
        Transaction tx = null;
        Panier panier = null;
    	try
    	{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            Query q = session.createQuery("from Panier where id_panier="+String.valueOf(id));
            panier = (Panier) q.uniqueResult();
            tx.commit();
                        
            return panier;
    	}
    	catch(HibernateException e){
            e.printStackTrace();
            tx.rollback();
        }
        return panier;
    }
}
