/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.server.services;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author vasiliy
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
            com.accounting.server.services.OperationsServicesTest.class,
            com.accounting.server.services.ProductUnitsServicesTest.class,
            com.accounting.server.services.DestinationsServicesTest.class,
            com.accounting.server.services.ProductsServicesTest.class,
            com.accounting.server.services.CurrencysServicesTest.class,
            com.accounting.server.services.ProductGroupsServicesTest.class,
            com.accounting.server.services.AccountsServicesTest.class,
            com.accounting.server.services.TransactionsServicesTest.class,
            com.accounting.server.services.DocumentsServicesTest.class,
            com.accounting.server.services.EmployeesServicesTest.class
        }
)
public class ServicesTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
