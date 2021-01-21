/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.bo;

/**
 *
 * @author ISMAIL
 */
public class ModelCollection {
    private Article article;
    private int qte;

    public ModelCollection(Article a, int q){
        this.article = a;
        this.qte = q;
    }
    
    public void setArticle(Article t){
        this.article = t;
    }
    
    public Article getArticle() {
	return this.article;
    }
    
    public void setQte(int q){
        this.qte = q;
    }
    
    public int getQte() {
	return this.qte;   
    }         
}

