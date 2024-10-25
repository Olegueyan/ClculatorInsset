/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.service;

import org.insset.server.DiscountServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author insset
 */
public class DiscountServiceTest {
    private DiscountServiceImpl discountService;
    
    public DiscountServiceTest() {
        this.discountService = new DiscountServiceImpl();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDiscountAmount method, of class DiscountService.
     */
    @Test
    public void testGetDiscountAmount() {
        // Typical cases
        assertTrue("20% of 100 should be 20", discountService.getDiscountAmount(100, 20).equals(20));
        assertTrue("25% of 200 should be 50", discountService.getDiscountAmount(200, 25).equals(50));
        
        // Edge cases
        assertTrue("0% discount should be 0", discountService.getDiscountAmount(100, 0).equals(0));
        assertTrue("100% discount should equal the original amount", discountService.getDiscountAmount(100, 100).equals(100));
    
        // Invalid inputs
        
        // Test for negative price
        try {
            discountService.getDiscountAmount(-100, 20);
            fail("Expected IllegalArgumentException for negative price");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input values. Ensure price and discount are non-negative, and discount is within 0-100.", e.getMessage());
        }
        
        // Test for negative discount
        try {
            discountService.getDiscountAmount(100, -20);
            fail("Expected IllegalArgumentException for negative discount");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input values. Ensure price and discount are non-negative, and discount is within 0-100.", e.getMessage());
        }
        
        // Test for discount over 100%
        try {
            discountService.getDiscountAmount(100, 120);
            fail("Expected IllegalArgumentException for discount over 100%");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input values. Ensure price and discount are non-negative, and discount is within 0-100.", e.getMessage());
        }
    }

    /**
     * Test of getPriceAfterDiscount method, of class DiscountService.
     */
    @Test
    public void testGetPriceAfterDiscount() {
        // Typical cases
        assertTrue("20% discount on 100 should yield final price 80", discountService.getPriceAfterDiscount(100, 20).equals(80));
        assertTrue("25% discount on 200 should yield final price 150", discountService.getPriceAfterDiscount(200, 25).equals(150));
       
        // Edge cases
        assertTrue("0% discount should yield the original price", discountService.getPriceAfterDiscount(100, 0).equals(100));
        assertTrue("100% discount should yield a final price of 0", discountService.getPriceAfterDiscount(100, 100).equals(0));
        
        // Invalid inputs
        
        // Test for negative price
        try {
            discountService.getPriceAfterDiscount(-100, 20);
            fail("Expected IllegalArgumentException for negative price");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input values. Ensure price and discount are non-negative, and discount is within 0-100.", e.getMessage());
        }
        
        // Test for negative discount
        try {
            discountService.getPriceAfterDiscount(100, -20);
            fail("Expected IllegalArgumentException for negative discount");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input values. Ensure price and discount are non-negative, and discount is within 0-100.", e.getMessage());
        }
        
        // Test for discount over 100%
        try {
            discountService.getPriceAfterDiscount(100, 120);
            fail("Expected IllegalArgumentException for discount over 100%");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input values. Ensure price and discount are non-negative, and discount is within 0-100.", e.getMessage());
        }
    }
    
}
