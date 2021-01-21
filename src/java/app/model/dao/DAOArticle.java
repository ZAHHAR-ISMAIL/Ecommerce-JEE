/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.dao;

import app.model.bo.Article;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ISMAIL
 */
public class DAOArticle {
    private static DAOArticle instance;
    private DAOArticle(){}
    
    public static DAOArticle GetInstance(){
        if(instance == null) instance = new DAOArticle();
        
        return instance;
    }
    
    public void create(Article C) {
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

    public void update(Article C) {
        Transaction tx = null;
        
        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(C);
            tx.commit();
               
        }
        catch(HibernateException e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    public void delete(int id) {
        Transaction tx = null;
       
        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            Query q = session.createQuery("from Article where id_article="+String.valueOf(id));
            Article client = (Article) q.uniqueResult();
            
            session.delete(client); 
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    
    public List<Article> retreive() {
         List<Article> allArticles = null;
         Transaction tx = null;
         try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            Query q = session.createQuery("from Article");
            allArticles = q.list();
            //allClients = (List <Client>)session.createQuery("from client").list();
            tx.commit();
               
        }
        catch(HibernateException e){
            e.printStackTrace();
            //tx.rollback();
        }
        return  allArticles;
    }
    
    public List<Article> retreiveCategorie(String c) {
         List<Article> allArticles = null;
         Transaction tx = null;
         try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            Query q = session.createQuery("from Article where categorie='"+c+"'");
            allArticles = q.list();
            //allClients = (List <Client>)session.createQuery("from client").list();
            tx.commit();
               
        }
        catch(HibernateException e){
            e.printStackTrace();
            tx.rollback();
        }
        return  allArticles;
    }
    
   public Article retreiveOne (int id) {
        Transaction tx = null;
        Article article = null;
    	try
    	{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            Query q = session.createQuery("from Article where id_article="+String.valueOf(id));
            article = (Article) q.uniqueResult();
            tx.commit();
                        
            return article;
    	}
    	catch(HibernateException e){
            e.printStackTrace();
            tx.rollback();
        }
        return article;
    }
    
    /*public int testExist(int id) {
        Transaction tx = null;
    	try
    	{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            Query q = session.createQuery("from Client where id="+String.valueOf(id));
            Article client = (Article) q.uniqueResult();
            tx.commit();
            
            
            if (client != null) 
            {
            	if( BigDecimal.valueOf(id) ==  client.getPersonid())
            		return 1;
            }
            return 0;
    	}
    	catch(HibernateException e){
            e.printStackTrace();
            tx.rollback();
        }
		return 0;
    }*/
    
}
