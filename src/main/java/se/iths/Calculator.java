package se.iths;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    //To expose the private method for testing
    public int subtractVisibleToAll(int a, int b) {
        return subtract( a, b);
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public String add(String s1, String s2) {
        return s1 + s2;
    }

    public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean containsSubstring(String stringToSearch, String substring) {
        boolean containsSubstring = stringToSearch.contains(substring);
        return containsSubstring;
    }

    public static String reverse(String a) {
        StringBuilder sb = new StringBuilder(a);

        return sb.reverse().toString();
    }

    public static boolean checkNumber(int number) {
        if(number > 10) {
            throw new ArithmeticException("Your number is bigger than 10");
        }
        else
            return true;
    }

    public static void main(String[] args) {
        System.out.println("2 + 2 is " + new Calculator().add(2, 2) + ".");
        System.out.println("Exception not thrown when number is 9 . Output is: " + checkNumber(9));
    }
}