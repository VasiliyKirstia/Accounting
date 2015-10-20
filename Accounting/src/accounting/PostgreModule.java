/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting;

import com.google.inject.AbstractModule;
import accounting.Interfaces.*;
import accounting.PostgreManagers.*;
import com.google.inject.Scopes;

/**
 *
 * @author vasiliy
 */
public class PostgreModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(IAccountsManager.class)
                .to(PostgreAccountsManager.class)
                .in(Scopes.SINGLETON);
        
        bind(ICurrencysManager.class)
                .to(PostgreCurrencysManager.class)
                .in(Scopes.SINGLETON);
        
        bind(IDestinationsManager.class)
                .to(PostgreDestinationsManager.class)
                .in(Scopes.SINGLETON);
        
        bind(IDocumentsManager.class)
                .to(PostgreDocumentsManager.class)
                .in(Scopes.SINGLETON);
        
        bind(IEmployeesManager.class)
                .to(PostgreEmployeesManager.class)
                .in(Scopes.SINGLETON);
        
        bind(IOperationsManager.class)
                .to(PostgreOperationsManager.class)
                .in(Scopes.SINGLETON);
        
        bind(IProductGroupsManager.class)
                .to(PostgreProductGroupsManager.class)
                .in(Scopes.SINGLETON);
        
        bind(IProductUnitsManager.class)
                .to(PostgreProductUnitsManager.class)
                .in(Scopes.SINGLETON);
        
        bind(IProductsManager.class)
                .to(PostgreProductsManager.class)
                .in(Scopes.SINGLETON);
        
        bind(ITransactionsManager.class)
                .to(PostgreTransactionsManager.class)
                .in(Scopes.SINGLETON);
    }
    
}
