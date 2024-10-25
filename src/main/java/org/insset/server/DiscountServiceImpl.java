/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.DiscountService;

/**
 *
 * @author insset
 */
@SuppressWarnings("serial")
public class DiscountServiceImpl extends RemoteServiceServlet implements DiscountService {

    @Override
    public Integer getDiscountAmount(Integer number, Integer discountPercent) {
        if (number == null || discountPercent == null || number < 0 || discountPercent < 0 || discountPercent > 100) {
           throw new IllegalArgumentException("Invalid input values. Ensure price and discount are non-negative, and discount is within 0-100.");
        }
        return (number * discountPercent) / 100;
    }

    @Override
    public Integer getPriceAfterDiscount(Integer number, Integer discountPercent) {
        Integer discountAmount = getDiscountAmount(number, discountPercent);
        return number - discountAmount;
    }
    
}
