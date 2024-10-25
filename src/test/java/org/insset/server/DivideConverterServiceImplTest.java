/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

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
public class DivideConverterServiceImplTest {
    
    public DivideConverterServiceImplTest() {
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
     * Test of divide method, of class DivideConverterServiceImpl.
     */
    @Test
    public void testDivideSuccess() {
        System.out.println("divide");
        Integer valDividende = 6;
        Integer valDiviseur = 2;
        DivideConverterServiceImpl instance = new DivideConverterServiceImpl();
        Integer expResult = 3;
        Integer result = instance.divide(valDividende, valDiviseur);
        assertEquals(expResult, result);
    }
    
    
}
