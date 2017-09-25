/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author matt
 */

public class Vigenere {
    private String key;
    private String plainText;
    Vigenere(String key){
        this.key = key;
        plainText = getText().toUpperCase();
    }
    private String getText(){
        FileReader fr;
        String text = "";
        try {
            String inputFile = "C:\\Users\\Matt\\Documents\\Projects\\Crypto\\src\\crypto\\vigText.txt";
               
            fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);
            text = br.readLine();
            fr.close();
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        } catch (IOException ex) {
            System.out.println("IO exception");
        }
        return text;
    }
    
    public String encrypt()
    {
        String res = "";
        for (int i = 0, j = 0; i < plainText.length(); i++)
        {
            char c = plainText.charAt(i);
            if (c < 'A' || c > 'Z')
                res += c;
            else{
                res += (char) ((c + key.charAt(j) - 130) % 26 + 65);
                j = ++j % key.length();
            }
        }
        return res;
    }
 
    public String decrypt()
    {
        String res = "";
        for (int i = 0, j = 0; i < plainText.length(); i++)
        {
            char c = plainText.charAt(i);
            if (c < 'A' || c > 'Z')
                res += c;
            else{
                res += (char) ((c - key.charAt(j) + 26) % 26 + 65);
                j = ++j % key.length();
            }
        }
        return res;
    }
 
   

}

