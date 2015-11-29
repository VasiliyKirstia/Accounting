/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.server;

import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
/**
 *
 * @author vasiliy
 */
public class Settings {

    private volatile static Settings instance;
    
    private final String CONNECTION_URL;
    private final String USERNAME;
    private final String PASSWORD;
    private final Integer PRODUCT_ADDITION_ID;
    private final Integer PRODUCT_CONSUMING_ID;
    private final Integer DESTINATION_STORAGE_ID;
    
    private Settings(){
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        Map<String, String> settings;
        
        settings = new Gson().fromJson(
            new InputStreamReader(Settings.class.getResourceAsStream("/deploy.json")),
            type
        );
        
        this.CONNECTION_URL = settings.get("url");
        this.USERNAME = settings.get("username");
        this.PASSWORD = settings.get("password");
        
        try{
            this.PRODUCT_ADDITION_ID = Integer.valueOf(settings.get("productAdditionId"));
            this.PRODUCT_CONSUMING_ID = Integer.valueOf(settings.get("ProductConsumingId"));
            this.DESTINATION_STORAGE_ID = Integer.valueOf(settings.get("DestinationStorageId"));
        }catch(NumberFormatException e){
            throw new RuntimeException(e);
        }
    }
    
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
