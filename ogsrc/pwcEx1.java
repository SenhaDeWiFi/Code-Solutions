package ogsrc;
/* 
 * Ex1: Reverte ordem de palavras dentro de uma string // Reverse the order of a string preserving the words
 * Data: 08/07/2023
 * P.I.Bonaldi 
 * 
*/
import java.io.IOException;

public class pwcEx1 {
    public static void main(String[] args) throws IOException {
        
        //User Input
        System.out.print("Digite sua frase:");
        String input = System.console().readLine();
        
        //Call of function and print
        System.out.println(reveString(input));
    }

    //Reverses the string order
    public static String reveString(String toReverse){
        //Splitting the string words
        String[] separated = toReverse.split(" ");
        String reconstructed = "";

        //Reversing their order and storing it on another string
        for (int i = separated.length - 1; i >= 0; i--) {
            reconstructed += separated[i] + " ";
        }

        reconstructed.trim();
        return reconstructed;
    }
}
