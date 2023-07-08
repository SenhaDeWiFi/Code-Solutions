/* 
 * Ex2: Remove todo caractere duplicado dentro de uma string// Removes every duplicate char in a string
 * Data: 08/07/2023
 * P.I.Bonaldi 
 * 
*/
import java.io.IOException;

public class pwcEx2 {
    public static void main(String[] args) throws IOException {
        
        //User Input
        System.out.print("Digite sua frase:");
        String input = System.console().readLine();
 
        //Call of function and print
        System.out.println(removeDups(input));
    }
    
    //Remove repeated charaters inside a string
    public static String removeDups(String toRemoveDup){

        // *Supposing only alphanumeric characters
        boolean[] verifiedChars = new boolean[256];
        String dupsRemoved = "";
        
        for (int i = 0; i < toRemoveDup.length(); i++) {
            char charToTest = toRemoveDup.charAt(i);

            // Verifies if the char-indexed position hasn't been 'visited before'
            if (!verifiedChars[charToTest]){
                verifiedChars[charToTest] = true;

            // If it is the first occurence of the char, it concatenates to the new string
                dupsRemoved += charToTest;
            }

        }
        return dupsRemoved;
    }
}
