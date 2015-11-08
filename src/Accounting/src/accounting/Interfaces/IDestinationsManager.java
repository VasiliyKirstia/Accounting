/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.Interfaces;

import accounting.Models.Destination;
import java.util.List;

/**
 *
 * @author Vasiliy Kirstia
 */
public interface IDestinationsManager {
    public void addDestination(String destinationName);
    public Destination getDestinationyById(int id);    
    public List<Destination> getAllDestinations();
}
