/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *
 * @author insset
 */
@RemoteServiceRelativePath("discount")
public interface DiscountService extends RemoteService {
    
    /**
     * Get the amount of discount after a discount percent
     * 
     * @param number
     * @param discountPercent
     * @return 
     */
    Integer getDiscountAmount(Integer number, Integer discountPercent);
    
    /**
     * Get the final price after a discount percent
     * 
     * @param number
     * @param discountPercent
     * @return 
     */
    Integer getPriceAfterDiscount(Integer number, Integer discountPercent);
}
