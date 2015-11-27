/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;

import com.accounting.interfaces.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
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
