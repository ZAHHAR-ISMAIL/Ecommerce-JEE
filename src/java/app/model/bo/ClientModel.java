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
public class ClientModel {
    private Client client = null;
    
    public void setClient(Client c){
        this.client = c;
    }
    
    public Client getClient(){
        return this.client;
    }
    
    public void logOut(){
        this.client = null;
    }
}
