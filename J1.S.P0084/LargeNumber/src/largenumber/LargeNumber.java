package largenumber;
import java.math.BigInteger;
import java.util.Scanner;

public class LargeNumber {
    
    public static String checkInput() {
//        regex: allowed input a digit number
//        digit number: 0 - 9 
//        +: matches one or more frequencies a element
        String pattern = "\\d+";
        
        while(true) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Input is a empty string!!!");
                continue;
            } 
            if (!input.matches(pattern)) {
                System.err.println("Input need a digit number");
                continue;
            }
            return input;
        }
    }
    
    public static void main(String[] args) {
        String numOne = checkInput();
        String numTwo = checkInput();
        
        BigInteger bigNumOne = new BigInteger(numOne);
        BigInteger bigNumTwo = new BigInteger(numTwo);
        
        System.out.println(bigNumOne.multiply(bigNumTwo));
    }
    
}
