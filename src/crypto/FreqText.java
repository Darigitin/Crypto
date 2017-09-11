package crypto;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matt
 */
public class FreqText {
    private final String inputFile = "C:\\Users\\Matt\\Documents\\Projects\\Crypto\\src\\crypto\\freqText.txt";
    
    public void analyze(){
        double[] letterCount = new double[26];
        double lc = 0;
        try {
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null){
                for (int i = 0; i < line.length(); i++){
                    char c = line.charAt(i);
                    int ic = (int) c;
                    if (ic >= 97 && ic <= 122){
                        letterCount[ic - 97]++;
                        lc++;
                    }
                    else if (ic >= 65 && ic <= 90){
                        letterCount[ic - 65]++;
                        lc++;
                    }
                }
            }
            System.out.println("Letter | Relative Freq (%)");
            for (int i = 0; i < letterCount.length; i++){
                System.out.printf("%c      | %.2f\n", (char) (i + 65), letterCount[i]/lc * 100);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FreqText.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FreqText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
