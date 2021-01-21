/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.dao;

import app.model.bo.Ligne;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author ISMAIL
 */
public class DAOLigne {
     private static DAOLigne instance;
    private DAOLigne(){}
    
    public static DAOLigne GetInstance(){
        if(instance == null) instance = new DAOLigne();
        
        return instance;
    }
    
    public void create(Ligne C) {
        Transaction tx = null;
        
        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.save(C);
            tx.commit();
               
        }
        catch(HibernateException e){
            e.printStackTrace();
            tx.rollback();
        }
    }
}
