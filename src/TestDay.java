import java.util.Scanner;

public class TestDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Specify your day in number:" +
                "\n1 for Monday" +
                "\n2 for Tuesday" +
                "\n3 for Wednesday" +
                "\n4 for Thursday" +
                "\n5 for Friday" +
                "\n6 for Saturday" +
                "\n7 for Sunday");
        int input = sc.nextInt();
        Day d = new Day(input);
        System.out.println(d);
        System.out.println("How many days to add to the specified/current day (" + d.getDay() + ")? : ");
        int add = sc.nextInt();
        System.out.println("The new day after the addition of " + add + " day(s) is : " + d.add(add));
    }
}
