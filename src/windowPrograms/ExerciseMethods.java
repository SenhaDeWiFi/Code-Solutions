package windowPrograms;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExerciseMethods {

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
	
	//Remove repeated characters inside a string
    public static String removeDups(String toRemoveDup){

        // *Supposing only alphanumeric characters
        boolean[] verifiedChars = new boolean[256];
        String dupsRemoved = "";
        
        for (int i = 0; i < toRemoveDup.length(); i++) {
            char charToTest = toRemoveDup.charAt(i);

            // Verifies if the char-indexed position hasn't been 'visited before'
            if (!verifiedChars[charToTest]){
                verifiedChars[charToTest] = true;

            // If it is the first occurrence of the char, it concatenates to the new string
                dupsRemoved += charToTest;
            }

        }
        return dupsRemoved;
    }
    
    //Gets the longest palindrome inside a string
    public static String longestPalindromeIn(String input){
    	
    	//"Decapitalize" the user input
        input = input.replaceAll(" ", "");
        input = input.toLowerCase();
        
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
    
    //Makes every sentence in a string starts with a uppercase char
    public static String upperCaseFirst(String input){

        // Get the regex pattern of a ending and starting sentence
        Pattern regex = Pattern.compile("(?<=(\\;|\\?|\\!|\\.)\\s|^)[a-z]");

        Matcher matcher = regex.matcher(input);
        StringBuilder sb = new StringBuilder();

        int currentEnd = 0;
        
        // Appends and modifies to uppercase for each match of the pattern inside the text  
        while (matcher.find()) {
            sb.append(input, currentEnd, matcher.start());
            sb.append(matcher.group().toUpperCase());
            currentEnd = matcher.end(); 
        }
        
        sb.append(input.substring(currentEnd));

        return sb.toString();
    }
    
    //Checks if a string is a anagram of a palindrome
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
