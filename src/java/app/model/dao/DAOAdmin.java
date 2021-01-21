/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.dao;
import app.model.bo.Admin;
import org.hibernate.*;
import java.util.*;
/**
 *
 * @author ISMAIL
 */
public class DAOAdmin {
    Transaction tx=null;
    public List<Admin> retreive(){
        try
        {
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            List<Admin> comptes=(List<Admin>)session.createQuery("From Admin").list();
            tx.commit();
            return  comptes;
        }
        catch(HibernateException e){

            tx.rollback();
            return null;
        }
    }

/*    public static void main(String[] argv){
        for (Admin C:new DAOAdmin().retreive()){
            System.out.print(C.getUsername());
        }
    }*/
}
