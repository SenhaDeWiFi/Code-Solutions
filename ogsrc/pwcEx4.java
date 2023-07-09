package ogsrc;
/* 
 * Ex4: Transforma a primeira letra de qualquer dada frase em maiuscula dentro de uma string// Makes uppercase the first character of any phrase of a string
 * Data: 08/07/2023
 * P.I.Bonaldi 
 * 
*/
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pwcEx4 {
    public static void main(String[] args) throws IOException{
        
         //User Input
         System.out.print("Digite sua string:");
         String input = System.console().readLine();
  
         //Call of function and print
         System.out.println(upperCaseFirst(input));
    }

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
}
