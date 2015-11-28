/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.utils;

import javax.naming.NamingException;


/**
 *
 * @author vasiliy
 */
public abstract class RemoteServicesProvider<I> {
    
    public abstract I getServices() throws NamingException, Exception;
    
    public I getServicesSafely(){
        I services = null;
        try{
            services = getServices();
        }catch(NamingException ne){
            
        }catch(Exception e){
            
        }
        return services;
    }
}
