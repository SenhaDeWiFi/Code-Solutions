package ogsrc;
/* 
 * Ex3: Encontra o maior palíndromo dentro de uma string// Finds the longest palindrome substring inside a given string
 * Data: 08/07/2023
 * P.I.Bonaldi 
 * 
*/
import java.io.IOException;

public class pwcEx3 {
    public static void main(String[] args) throws IOException{
        
         //User Input
         System.out.print("Digite sua string:");
         String input = System.console().readLine();
  
         //Call of function and print
         System.out.println(longestPalindromeIn(input));
    }

    public static String longestPalindromeIn(String input){
        String longestP = "";

        // Checks for every possible substring 
        for (int i = 0; i < input.length(); i++) {
            for (int j = input.length(); i + 1 < j; j--) {

                String currentSubstring = input.substring(i, j);
            
                // Check if the current substring is a palindrome and if it's longer than previous found palindromes
                if (isPalindrome(currentSubstring) && currentSubstring.length() > longestP.length()) {
                    longestP = currentSubstring;
                }
            }
        }
        if (longestP.length() > 0) {
            return longestP;
        }else{
            return "Não existem palíndromos na string dada.";
        }
    }

    // Checks if a string is a palindrome
    public static boolean isPalindrome(String toVerify){
        
        boolean palindromeStatus = true;
        int right = toVerify.length() - 1;
        
        // Iterates through the string comparing chars starting from both ends
        for (int left = 0; left < right; left++) {
            if (toVerify.charAt(left) != toVerify.charAt(right)) {
                palindromeStatus = false;
            }
            right--;
        }
        
        return palindromeStatus;
    }
}
