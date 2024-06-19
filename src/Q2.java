import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Q2 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new FileInputStream("C:\\Users\\USER\\IdeaProjects\\ds2016s2\\src\\BracMatch.txt"))) {
            while(in.hasNextLine()) {
                String input = in.nextLine();
                System.out.println("String: " + input);
                if (hasNoBracket(input))
                    System.out.println("There is no bracket in the input");
                else
                    System.out.println(isMatched(input)? "Yes - All matched!":"Not all brackets are matched");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean hasNoBracket(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (isOpen(line.charAt(i)) || isClose(line.charAt(i)))
                return false;
        }
        return true;
    }
    public static boolean isMatched(String line) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            if (isOpen(line.charAt(i))) {
                stack.push(line.charAt(i));
            } else if (isClose(line.charAt(i))) {
                if (stack.isEmpty() || !isPair(stack.peek(),line.charAt(i)))
                    return false;
                else
                    stack.pop();
            }
        }
        return true;
    }

    public static boolean isOpen(char i) {
        return i=='(' || i=='[' || i=='<' || i=='{';
    }

    public static boolean isClose(char i) {
        return i==')' || i==']' || i=='>' || i=='}';
    }

    public static boolean isPair(char open, char close) {
        return (open=='(' && close==')') ||
                (open=='[' && close==']') ||
                (open=='<' && close=='>') ||
                (open=='{' && close=='}');
    }
}
