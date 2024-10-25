/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.RomanConverterService;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {

    
    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        
        String day = convertArabeToRoman(Integer.parseInt(nbr.substring(0, 2)));
        String month = convertArabeToRoman(Integer.parseInt(nbr.substring(3, 5)));
        String year = convertArabeToRoman(Integer.parseInt(nbr.substring(6, 10)));
            
        return day + "/" + month + "/" + year;
        
    }

    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        Map<Character, Integer> romanToDecimalMap = new HashMap<>();
        romanToDecimalMap.put('I', 1);
        romanToDecimalMap.put('V', 5);
        romanToDecimalMap.put('X', 10);
        romanToDecimalMap.put('L', 50);
        romanToDecimalMap.put('C', 100);
        romanToDecimalMap.put('D', 500);
        romanToDecimalMap.put('M', 1000);
        
        int total = 0; 
        int prevValue = 0; 
        
        for (int i = nbr.length() - 1; i >= 0; i--) {
            char currentChar = nbr.charAt(i);
            int currentValue = romanToDecimalMap.get(currentChar);
            
            if (currentValue < prevValue) {
                total -= currentValue;
        } else {
            total += currentValue;
        }
            prevValue = currentValue;
        }
        

        return total;
    }
    

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        // Ensure number is within supproted range.
        if (nbr <= 0 || nbr > 3000) {
            throw new IllegalArgumentException("Input number musdt be between 0 and 3000.");
        }
        
        // Define Roman numerals symbols and their corresponding values.
        int[] values = new int[]{ 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{ "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        
        StringBuilder romanNumeral = new StringBuilder();
        
        // Convert the integer to Roman numeral by iteratinh over symbol-value pa
        for (int i = 0; i < values.length; i++)
        {
            while (nbr >= values[i])
            {
                romanNumeral.append(symbols[i]);
                nbr -= values[i];
            }
        }
        
        return romanNumeral.toString();
    }

}
