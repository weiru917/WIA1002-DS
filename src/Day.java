public class Day {
    private String name;
    private int day;

    Day() {
        this.day = 1; // Default to Monday
        this.name = "Monday";
    }

    Day(int day) {
        this.day = day;
        this.name = getName();
    }

    public int getDay() {
        return day;
    }

    public String getName() {
        return getDayName(this.day);
    }

    private String getDayName(int day) {
        return switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> null;
        };
    }

    public String next() {
        int n = (this.day == 7? 1: this.day+1);
        return getDayName(n);
    }

    public String prev() {
        int n = (this.day == 1? 7: this.day-1);
        return getDayName(n);
    }

    public String add(int n) {
        this.day = ((this.day - 1 + n) % 7) + 1;
        this.name = getName();
        return this.name;
    }

    public String toString() {
        return "The name of the day is: " + getName() +
                "\nThe following day of " + getName() + " is: " + next() +
                "\nThe previous day of " + getName() + " is: " + prev();
    }
}
