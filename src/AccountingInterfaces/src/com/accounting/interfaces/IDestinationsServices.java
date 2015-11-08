/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accounting.interfaces;

import com.accounting.models.Destination;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Vasiliy Kirstia
 */
@Remote
public interface IDestinationsServices {
    public void addDestination(String destinationName);
    public Destination getDestinationyById(int id);    
    public List<Destination> getAllDestinations();
}
