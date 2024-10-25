/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.DivideService;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class DivideConverterServiceImpl extends RemoteServiceServlet implements
        DivideService {
    
    @Override
    public Integer divide(Integer valDividende, Integer valDiviseur) throws IllegalArgumentException {
        if (valDividende == 0 || valDiviseur == 0) {
            throw new ArithmeticException("Impossible d'effectuer la division, une division ne peut diviser 0 ou être diviser par 0!");
        } else {
           return valDividende / valDiviseur;
        }
    }

}
