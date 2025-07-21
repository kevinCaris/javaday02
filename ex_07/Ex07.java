import java.util.*;
public class Ex07{
    public static double myDivisionModulo(double firstNumber,char operChar, double secondNumber){ 
        if(operChar == '/'){
            return firstNumber / secondNumber;
        }else if(operChar == '%'){
            return firstNumber % secondNumber;
        }else{
            throw new IllegalArgumentException("The given arguments aren't good.\n");
        }
    }
    public static void main(String[] args) {
        try {
            System.out.println(myDivisionModulo(3, '/', 4)); // 0.75
            System.out.println(myDivisionModulo(3, '%', 2)); // 1.0
            System.out.println(myDivisionModulo(3, '+', 1)); // throw
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 

        
    }
}