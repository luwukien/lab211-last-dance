package fibonacci;

/**
 *
 * @author IdeaPad
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println("The 45 sequence Fibonacci: ");
        Fibonacci fibo = new Fibonacci();
        
        fibo.fiboHelper(45, 0, 1);
    
    }
    public  void fiboHelper(int term, int preNumber, int nextNumber) {
        if (term == 0) {
            return;
        }
        
        System.out.print(preNumber);
        
        if (term > 1) {
            System.out.print( ", ");
        }
        
        fiboHelper(term - 1, nextNumber, preNumber + nextNumber);
    }
}
