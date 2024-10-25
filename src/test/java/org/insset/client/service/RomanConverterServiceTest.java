/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.service;

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
    
    public RomanConverterServiceTest() {
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
        System.out.println("convertRomanToArabe");
        String nbr = "";
        RomanConverterService instance = new RomanConverterServiceImpl();
        Integer expResult = null;
        Integer result = instance.convertRomanToArabe(nbr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertArabeToRoman method, of class RomanConverterService.
     */
    @Test
    public void testConvertArabeToRoman() {
        System.out.println("convertArabeToRoman");
        
        int[] testBattery = new int[] { 4, 7, 12, 23, 54, 102, 203, 1289};
        String[] expResults = new String[] { "IV", "VII", "XXIII", "e" };
        
        Integer nbr = null;
        RomanConverterService instance = new RomanConverterServiceImpl();
        String expResult = "";
        String result = instance.convertArabeToRoman(nbr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertDateYears method, of class RomanConverterService.
     */
    @Test
    public void testConvertDateYears() {
        System.out.println("convertDateYears");
        String nbr = "";
        RomanConverterService instance = new RomanConverterServiceImpl();
        String expResult = "";
        String result = instance.convertDateYears(nbr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class RomanConverterServiceImpl implements RomanConverterService {

        public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
            return null;
        }

        public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
            return "";
        }

        public String convertDateYears(String nbr) throws IllegalArgumentException {
            return "";
        }
    }
    
}
