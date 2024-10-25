/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 *
 * @author insset
 */
public interface DiscountServiceAsync {
    /**
     * Get the amount of discount after a discount percent
     * 
     * @param number
     * @param discountPercent
     * @param callback
     * @return 
     */
    void getDiscountAmount(Integer number, Integer discountPercent, AsyncCallback<Integer> callback);
    
    /**
     * Get the final price after a discount percent
     * 
     * @param number
     * @param discountPercent
     * @param callback
     * @return 
     */
    void getPriceAfterDiscount(Integer number, Integer discountPercent, AsyncCallback<Integer> callback);
}
