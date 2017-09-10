/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

/**
 *
 * @author Matt
 */
public class AtBash {
    String text;
    AtBash(String text) {
        this.text = text;
    }
    
    public String encrypt(){
        String ret = "";
        int l = text.length();
        int i = 0;
        
        while (i < l){
            char c = text.charAt(i);
            int ic = (int) c;
            if (ic >= 97 && ic <= 122){
                ret = ret + (char) (122 - (ic - 97));
            }
            else if (ic >= 65 && ic <= 90){
                ret = ret + (char) (90 - (ic - 65));
            }
            else 
                ret = ret + c;
            i++;
        }
        return ret;
    }
}
