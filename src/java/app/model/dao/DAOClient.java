/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.dao;

import app.model.bo.Client;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author ISMAIL
 */
public class DAOClient {
    private static DAOClient instance;
    private DAOClient(){}
    
    public static DAOClient GetInstance(){
        if(instance == null) instance = new DAOClient();
        
        return instance;
    }
    
    public void create(Client C) {
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
    
    public List<Client> retreive() {
         List<Client> allClients = null;
         Transaction tx = null;
         try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            //List<Democlient> li = session.createQuery("SELECT * FROM demoClient", Democlient.class).getResultList();
            Query q = session.createQuery("from Client");
            allClients = q.list();
            //allClients = (List <Client>)session.createQuery("from client").list();
            tx.commit();
               
        }
        catch(HibernateException e){
            e.printStackTrace();
            tx.rollback();
        }
        return  allClients;
    }
    
    public int testExist(String id) {
        Transaction tx = null;
    	try
    	{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            Query q = session.createQuery("from Client where email="+id);
            Client client = (Client) q.uniqueResult();
            tx.commit();
            
            
            if (client != null) 
            {
            	if( id.equals(client.getEmail()) )
            		return 1;
            }
            return 0;
    	}
    	catch(HibernateException e){
            e.printStackTrace();
            tx.rollback();
        }
		return 0;
    }
}
