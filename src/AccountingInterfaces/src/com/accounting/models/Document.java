/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.models;

import java.io.Serializable;

/**
 *
 * @author vasiliy
 */
public class Document implements Serializable{
    public final int Id;
    public final String Name;
    
    public Document(int id, String name){
        this.Id = id;
        this.Name = name;
    }
    
    @Override
    public String toString(){
        return this.Name;
    }
}
