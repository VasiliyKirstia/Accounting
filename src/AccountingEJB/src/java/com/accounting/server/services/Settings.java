/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.server.services;

/**
 *
 * @author vasiliy
 */
class Settings {
    private final String CONNECTION_URL = "jdbc:postgresql://localhost/accounting";
    private final String USERNAME = "test_user";
    private final String PASSWORD = "test_user";
    private final Integer PRODUCT_ADDITION_ID = 1;
    private final Integer PRODUCT_CONSUMING_ID = 2;
    private final Integer DESTINATION_STORAGE_ID = 2;
    
    private volatile static Settings instance;
    
    private Settings(){};
    
    public static Settings getInstance(){
        if( instance == null ){
            synchronized (Settings.class){
                if( instance == null ){
                    instance = new Settings();
                }
            }
        }
        return instance;
    }
    
    public String getConnectionURL(){
        return this.CONNECTION_URL;
    }
    
    public String getUserName(){
        return this.USERNAME;
    }
    
    public String getPassword(){
        return this.PASSWORD;
    }
    
    public Integer getProductAdditionId(){
        return this.PRODUCT_ADDITION_ID;
    }
    
    public Integer getProductConsumingId(){
        return this.PRODUCT_CONSUMING_ID;
    }
    
    public Integer getDestinationStorageId(){
        return this.DESTINATION_STORAGE_ID;
    }
}
