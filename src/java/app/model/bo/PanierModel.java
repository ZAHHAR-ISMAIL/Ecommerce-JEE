/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.bo;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ISMAIL
 */
public class PanierModel {
    private List<ModelCollection> panier;// = new ArrayList<>();
    private double total;
    private int nb;
    
    public PanierModel(){
        panier =  new ArrayList<>();
        total = 0;
        nb = 0;
    }
    
    public void setArticles(List<ModelCollection> cc) {
	this.panier = cc;
}
        
    public List<ModelCollection> getArticles() {
	return  this.panier;
    }
    
    public void addPanier(ModelCollection cc){
        for(ModelCollection m: panier){
            if(m.getArticle().getIdArticle() == cc.getArticle().getIdArticle())
            {
                m.setQte(m.getQte()+1);
                return;
            }
        }
        panier.add(cc);
        nb++;
    }
    
    public void refreshPanier(){
        panier.removeAll(panier);
        total = 0;
        nb = 0;
    }
    
    public void setTotal(){
        total = 0;
        nb = 0;
        for(ModelCollection m: panier){
            this.total = this.total + (m.getQte() * m.getArticle().getPrix());
            nb++;
        }
    }
    
    public double getTotal(){
        return this.total;
    }
    
    public int getNb(){
        return this.nb;
    }
}
