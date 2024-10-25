/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.service;

import java.util.Arrays;
import java.util.LinkedList;
import org.insset.server.RomanConverterServiceImpl;
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
public class RomanConverterServiceTest {
    
    private RomanConverterServiceImpl converterService;
    
    public RomanConverterServiceTest() {
        this.converterService = new RomanConverterServiceImpl();
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
     * Test of convertRomanToArabe method, of class RomanConverterService.
     */
    @Test
    public void testConvertRomanToArabe() {

    }

    /**
     * Test of convertArabeToRoman method, of class RomanConverterService.
     */
    @Test
    public void testConvertArabeToRoman() {
        int[] testBattery = new int[] { 1, 78, 945, 234, 1345, 28 };
        String[] expResult = new String[] { "I", "LXXVIII", "CMXLV", "CCXXXIV", "MCCCXLV", "XXVIII"};
        
        String[] result = new String[6];
        
        for (int i = 0; i < testBattery.length; i++)
        {
            result[i] = this.converterService.convertArabeToRoman(testBattery[i]);
        }
        
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(expResult));
        
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of convertDateYears method, of class RomanConverterService.
     */
    @Test
    public void testConvertDateYears() {

    }
    
}
