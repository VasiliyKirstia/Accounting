/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.client.utils;

/*
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;
*/
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
public class RemoteServicesProvider {
    
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
            
    private IAccountsServices accountsServices;
    private ICurrencysServices currencysServices;
    private IDestinationsServices destinationsServices;
    private IDocumentsServices documentsServices;
    private IEmployeesServices employeesServices;
    private IOperationsServices operationsServices;
    private IProductGroupsServices productGroupsServices;
    private IProductUnitsServices productUnitsServices;
    private IProductsServices productsServices;
    private ITransactionsServices transactionsServices;
    
    private RemoteServicesProvider(){
        /*  
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        Map<String, String> settings;
        
        settings = new Gson().fromJson(
            new InputStreamReader(EJBProvider.class.getResourceAsStream("/deploy.json")),
            type
        );
        */
        
        
        
    }

    private IAccountsServices lookupAccountsServicesRemote() {
        try {
            Context c = new InitialContext();
            return (IAccountsServices) c.lookup("java:comp/env/AccountsServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ICurrencysServices lookupCurrencysServicesRemote() {
        try {
            Context c = new InitialContext();
            return (ICurrencysServices) c.lookup("java:comp/env/CurrencysServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private IDestinationsServices lookupDestinationsServicesRemote() {
        try {
            Context c = new InitialContext();
            return (IDestinationsServices) c.lookup("java:comp/env/DestinationsServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private IDocumentsServices lookupDocumentsServicesRemote() {
        try {
            Context c = new InitialContext();
            return (IDocumentsServices) c.lookup("java:comp/env/DocumentsServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private IEmployeesServices lookupEmployeesServicesRemote() {
        try {
            Context c = new InitialContext();
            return (IEmployeesServices) c.lookup("java:comp/env/EmployeesServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private IOperationsServices lookupOperationsServicesRemote() {
        try {
            Context c = new InitialContext();
            return (IOperationsServices) c.lookup("java:comp/env/OperationsServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private IProductGroupsServices lookupProductGroupsServicesRemote() {
        try {
            Context c = new InitialContext();
            return (IProductGroupsServices) c.lookup("java:comp/env/ProductGroupsServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private IProductUnitsServices lookupProductUnitsServicesRemote() {
        try {
            Context c = new InitialContext();
            return (IProductUnitsServices) c.lookup("java:comp/env/ProductUnitsServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private IProductsServices lookupProductsServicesRemote() {
        try {
            Context c = new InitialContext();
            return (IProductsServices) c.lookup("java:comp/env/ProductsServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ITransactionsServices lookupTransactionsServicesRemote() {
        try {
            Context c = new InitialContext();
            return (ITransactionsServices) c.lookup("java:comp/env/TransactionsServices");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
