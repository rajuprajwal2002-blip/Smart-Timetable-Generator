public class Timetable {

    Subject[] subjects;
    String[] slots;
    Subject[] assignment; // slot → subject mapping

    public Timetable(Subject[] subjects, String[] slots) {
        this.subjects = subjects;
        this.slots = slots;
        this.assignment = new Subject[slots.length];
    }

    // Check constraints
    public boolean isSafe(int slotIndex, Subject subject) {

        for (int i = 0; i < slotIndex; i++) {
            Subject assigned = assignment[i];

            if (assigned != null) {
                // Teacher conflict
                if (assigned.teacher.equals(subject.teacher)) {
                    return false;
                }

                // Room conflict
                if (assigned.room.equals(subject.room)) {
                    return false;
                }
            }
        }

        return true;
    }

    // Backtracking function
    public boolean generateTimetable(int index) {

        if (index == subjects.length) {
            return true;
        }

        for (int i = 0; i < slots.length; i++) {

            if (assignment[i] == null && isSafe(i, subjects[index])) {

                assignment[i] = subjects[index];

                if (generateTimetable(index + 1)) {
                    return true;
                }

                // backtrack
                assignment[i] = null;
            }
        }

        return false;
    }

    public void display() {
        for (int i = 0; i < slots.length; i++) {
            if (assignment[i] != null) {
                System.out.println(slots[i] + " -> " + assignment[i].name +
                        " (" + assignment[i].teacher + ", Room " + assignment[i].room + ")");
            }
        }
    }
}