/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.utils;

import com.accounting.interfaces.*;
import java.util.HashMap;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 *
 * @author vasiliy
 */
public class RemoteServicesProvider {
    
    private Map<Class,String> servicesDictionary;
    
    private RemoteServicesProvider(){
        servicesDictionary = new HashMap<Class, String>();
        servicesDictionary.put(IAccountsServices.class, "AccountsServices");
        servicesDictionary.put(ICurrencysServices.class, "CurrencysServices");
        servicesDictionary.put(IDestinationsServices.class, "DestinationsServices");
        servicesDictionary.put(IDocumentsServices.class, "DocumentsServices");
        servicesDictionary.put(IEmployeesServices.class, "EmployeesServices");
        servicesDictionary.put(IOperationsServices.class, "OperationsServices");
        servicesDictionary.put(IProductGroupsServices.class, "ProductGroupsServices");
        servicesDictionary.put(IProductUnitsServices.class, "ProductUnitsServices");
        servicesDictionary.put(IProductsServices.class, "ProductsServices");
        servicesDictionary.put(ITransactionsServices.class, "TransactionsServices");
    }
    
    public <I> I getServices(Class serviceInterface) throws NotSupportedServicesException{
        if(!servicesDictionary.keySet().contains(serviceInterface))
            throw new NotSupportedServicesException();
        try{
            Context c = new InitialContext();
            return (I) c.lookup("java:comp/env/" + servicesDictionary.get(serviceInterface) );
        }catch(NamingException ne){
            return null;
        }
    }
    
    private static RemoteServicesProvider instance;
    
    public static RemoteServicesProvider getInstance(){
        if( instance == null ){
            synchronized (RemoteServicesProvider.class){
                if( instance == null ){
                    instance = new RemoteServicesProvider();
                }
            }
        }
        return instance;
    }
}