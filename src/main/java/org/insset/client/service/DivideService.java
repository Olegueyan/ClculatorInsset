package org.insset.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("divide")
public interface DivideService extends RemoteService {

    Integer divide(Integer valDividende, Integer valDiviseur) throws IllegalArgumentException;
    
    
}