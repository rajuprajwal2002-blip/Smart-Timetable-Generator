public class Main {
    public static void main(String[] args) {

        Subject[] subjects = {
                new Subject("Math", "A", "101"),
                new Subject("Physics", "B", "102"),
                new Subject("Chemistry", "A", "103")
        };

        String[] slots = {"9AM", "10AM", "11AM"};

        Timetable timetable = new Timetable(subjects, slots);

        if (timetable.generateTimetable(0)) {
            System.out.println("Generated Timetable:");
            timetable.display();
        } else {
            System.out.println("No valid timetable found.");
        }
    }
}