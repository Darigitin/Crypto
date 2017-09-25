/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import java.util.Scanner;

/**
 *
 * @author Matt
 */
public class Crypto {
static Scanner get = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    private static FreqText freq;
    
    public static void main(String[] args) {
       
       
       System.out.println("Please select a menu Option: \n");
       System.out.println("Press 1 for Atbash");
       System.out.println("Press 2 for Frequency Analysis");
       System.out.println("Press 3 for Vigenere");
       System.out.println("Press 4 for Friedman Test");
       int i = get.nextInt();
       get.nextLine();
        switch (i) {
            case 1:
                Atbash();
                break;
            case 2:
                FreqText();
                break;
            case 3:
                Vigenere();
                break;
            case 4:
                friedman();
                break;
            default:
                break; 
        }
    }

    private static void Atbash() {
        System.out.println("Please enter your text:");
        String text;
        text = get.nextLine();
        System.out.println(text);
        AtBash atbash = new AtBash(text);
        System.out.println(atbash.encrypt());
    }

    private static void FreqText() {
        freq = new FreqText();
        freq.analyze();
    }
    
    private static void Vigenere() {
        
        System.out.println("Enter key");
        String key = get.nextLine().toUpperCase();
        Vigenere vig = new Vigenere(key);
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        int choice = get.nextInt();

        if(choice == 1){
            String encryptedMsg = vig.encrypt();
            System.out.println("Encrypted message: " + encryptedMsg);
            System.exit(0);
        }
        else if(choice == 2){
            String decryptedMsg = vig.decrypt();
            System.out.println("Decrypted message: " + decryptedMsg + "\n");
            System.exit(0);
        }
        else{
            System.out.println("Invalid Input");
        }          
    }

    private static void friedman() {
        FreqText();
        int n = freq.getNumLetters();
        double [] letterCount = freq.getLetterCount();
        double numerator = 0;
        double denominator;
        double I;
        double k;
        
        for (int j = 0; j < letterCount.length; j++){
            numerator += letterCount[j] * (letterCount[j] - 1);
        }
        denominator = n * (n -1);
        I = numerator / denominator;
        System.out.println("Index of Coincidence is " + I);
        
        k = 0.0265 * n / ((0.065 - I)+ n * (I-0.0385));
        System.out.println("k = " + k);
    }
    
}