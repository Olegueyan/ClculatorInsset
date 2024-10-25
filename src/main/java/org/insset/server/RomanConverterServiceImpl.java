/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.RomanConverterService;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {

    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        //Implement your code
        return "XV/III/MX";
    }

    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        //Implement your code
        return 3;
    }

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        // Ensure number is within supproted range.
        if (nbr <= 0 || nbr > 3000) {
            throw new IllegalArgumentException("Input number musdt be between 0 and 3000.");
        }
        
        // Define Roman numerals symbols and their corresponding values.
        int[] values = new int[]{ 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{ "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "I" };
        
        StringBuilder romanNumeral = new StringBuilder();
        
        // Convert the integer to Roman numeral by iteratinh over symbol-value pa
        for (int i = 0; i < values.length; i++)
        {
            while (nbr >= values[i])
            {
                nbr -= values[i];
                result += symbols[i];
            }
        }
        
        return result;
    }

}
