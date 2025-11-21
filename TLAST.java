//Ervinna Christine Debora - 12S25059

import java.util.*;
import java.lang.Math;

public class TLAST {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] descriptions = new String[10];
        String[] codes = new String[10];
        String[] courseNames = new String[10];
        String[] lecturers = new String[10];
        String[] deadlines = new String[10];
        String[] subIDs = new String[10];
        int[] diffs = new int[10];
        int[] days = new int[10];
        String[] statuses = new String[10];
        double[] priorities = new double[10];
        int n = 0;

        String command = "";
        while (true) {
            if (!input.hasNextLine())
                break;
            command = input.nextLine();
            if (command == null)
                break;
            command = command.trim();
            if (command.equals("---")) {
                break;
            }
            if (command.equals("")) {
                // skip empty lines
                continue;
            }

            if (command.equals("Add task")) {
                n = addTask(n, descriptions, codes, courseNames, lecturers, deadlines, subIDs, diffs, days, statuses,
                        priorities);
            } else if (command.equals("Update task status")) {
                updateTask(n, codes, statuses);
            } else if (command.equals("Show assigment") || command.equals("Show assignment")) {
                showAssignment(n, descriptions, codes, courseNames, lecturers, deadlines, subIDs, statuses, priorities,
                        diffs, days);
            } else {
                // unknown command: ignore (or you can print a message)
            }
        }
    }

    // addTask returns new n (so caller knows n increased)
    public static int addTask(int n, String[] descriptions, String[] codes, String[] courseNames, String[] lecturers,
            String[] deadlines, String[] subIDs, int[] diffs, int[] days, String[] statuses, double[] priorities) {
        if (n < 10) {
            // read fields in the exact order specified by the problem
            descriptions[n] = input.nextLine();
            codes[n] = input.nextLine();
            courseNames[n] = input.nextLine();
            lecturers[n] = input.nextLine();
            deadlines[n] = input.nextLine();
            subIDs[n] = input.nextLine();

            // diffs and days are integers
            String diffsStr = input.nextLine();
            String daysStr = input.nextLine();
            try {
                diffs[n] = Integer.parseInt(diffsStr.trim());
            } catch (Exception e) {
                diffs[n] = 0;
            }
            try {
                days[n] = Integer.parseInt(daysStr.trim());
            } catch (Exception e) {
                days[n] = 0;
            }

            statuses[n] = input.nextLine();

            if (days[n] == 0) {
                priorities[n] = diffs[n] * 1.0;
            } else {
                priorities[n] = diffs[n] * 1.0 / days[n];
            }

            n = n + 1;
        }
        return n;
    }

    // showAssignment: sort by priorities desc, then print according to status
    public static void showAssignment(int n, String[] descriptions, String[] codes, String[] courseNames,
            String[] lecturers, String[] deadlines, String[] subIDs, String[] statuses, double[] priorities,
            int[] diffs, int[] days) {
        if (n <= 0)
            return;

        // Bubble sort (descending by priority) — swap corresponding arrays
        for (int a = 0; a < n - 1; a++) {
            for (int b = 0; b < n - 1 - a; b++) {
                if (priorities[b] < priorities[b + 1]) {
                    // swap priorities
                    double tmpD = priorities[b];
                    priorities[b] = priorities[b + 1];
                    priorities[b + 1] = tmpD;

                    // swap strings
                    String tmpS;
                    tmpS = descriptions[b];
                    descriptions[b] = descriptions[b + 1];
                    descriptions[b + 1] = tmpS;
                    tmpS = codes[b];
                    codes[b] = codes[b + 1];
                    codes[b + 1] = tmpS;
                    tmpS = courseNames[b];
                    courseNames[b] = courseNames[b + 1];
                    courseNames[b + 1] = tmpS;
                    tmpS = lecturers[b];
                    lecturers[b] = lecturers[b + 1];
                    lecturers[b + 1] = tmpS;
                    tmpS = deadlines[b];
                    deadlines[b] = deadlines[b + 1];
                    deadlines[b + 1] = tmpS;
                    tmpS = subIDs[b];
                    subIDs[b] = subIDs[b + 1];
                    subIDs[b + 1] = tmpS;
                    tmpS = statuses[b];
                    statuses[b] = statuses[b + 1];
                    statuses[b + 1] = tmpS;

                    // swap ints
                    int tmpI;
                    tmpI = diffs[b];
                    diffs[b] = diffs[b + 1];
                    diffs[b + 1] = tmpI;
                    tmpI = days[b];
                    days[b] = days[b + 1];
                    days[b + 1] = tmpI;
                }
            }
        }

        // Print according to format required
        for (int i = 0; i < n; i++) {
            System.out.printf("Prioritas: %.2f%n", priorities[i]);

            if ("Selesai".equals(statuses[i])) {
                // jika Selesai -> cetak tanpa deadline dan tanpa rekomendasi
                System.out.println(
                        descriptions[i] + "|" +
                                codes[i] + "|" +
                                courseNames[i] + "|" +
                                lecturers[i] + "|" +
                                subIDs[i] + "|" +
                                "Selesai");
            } else {
                // belum selesai -> cetak deadline + rekomendasi
                String rekomendasi;
                if (priorities[i] > 3.0) {
                    rekomendasi = "Penting! Anda harus mengerjakan tugas ini segera";
                } else if (priorities[i] >= 1.5) {
                    rekomendasi = "Tugas ini memiliki prioritas menengah";
                } else {
                    rekomendasi = "Tugas ini relatif ringan, namun jangan tunda terlalu lama";
                }

                System.out.println(
                        descriptions[i] + "|" +
                                codes[i] + "|" +
                                courseNames[i] + "|" +
                                lecturers[i] + "|" +
                                deadlines[i] + "|" +
                                subIDs[i] + "|" +
                                statuses[i] + "|" +
                                rekomendasi);
            }
        }
    }

    // updateTask: change status for the given course code
    public static void updateTask(int n, String[] codes, String[] statuses) {
        if (!input.hasNextLine())
            return;
        String searchCode = input.nextLine();
        if (!input.hasNextLine())
            return;
        String newStatus = input.nextLine();

        for (int i = 0; i < n; i++) {
            if (codes[i] != null && codes[i].equals(searchCode)) {
                statuses[i] = newStatus;
            }
        }
    }
}
