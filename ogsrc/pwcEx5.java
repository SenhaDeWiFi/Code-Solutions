package ogsrc;
/* 
 * Ex5: Verifica se dada qualquer string, ela é um anagrama de um palindromo// Verifies if any given string is a anagram of a palindrome
 * Data: 08/07/2023
 * P.I.Bonaldi 
 * 
*/
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class pwcEx5 {
    public static void main(String[] args) throws IOException {
        
        //User Input
        System.out.print("Digite sua string:");
        String input = System.console().readLine();
 
        //Call of function and print
        System.out.println(isPalinagram(input));
    }

    public static boolean isPalinagram(String input){

        //"Decapitalize" the user input
        input = input.replaceAll(" ", "");
        input = input.toLowerCase();
        char[] charArray = input.toCharArray();

        Map<Character , Integer> charMapper = new HashMap<>();

        //Counts the number of each char repetition using a key-value pair map
        for (int i = 0; i < charArray.length; i++) {
            charMapper.put(charArray[i], charMapper.getOrDefault(charArray[i], 0) + 1);
        }

        int oddCounter = 0;

        // Get how many odd numbers are mapped
        for (int currentValue : charMapper.values()){
            if (currentValue % 2 != 0) {
                oddCounter++;
            }
        }
        
        // if only one char at maximum have a odd count, still a anagram that can form a palindrome
        if (oddCounter <= 1) {
        
            return true;   
        
        }else return false;
    }
}
