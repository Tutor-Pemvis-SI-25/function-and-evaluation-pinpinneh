// 12S25035-Sintia Geni Audi Nainggolan
// 12S25059- Ervinna Christine Debora

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
        int n;

        n = 0;
        String command;

        command = "";
        while (!command.equals("---")) {
            command = input.nextLine();
            if (command.equals("---")) {
            } else {
                if (command.equals("Add task")) {
                    addTask(n, descriptions, codes, courseNames, lecturers, deadlines, subIDs, diffs, days, statuses,
                            priorities);
                } else {
                    if (command.equals("Update task status")) {
                        updateTask(n, codes, statuses);
                    } else {
                        if (command.equals("Show assigment") || command.equals("Show assignment")) {
                            sortTasks(n, priorities, descriptions, codes, courseNames, lecturers, deadlines, subIDs,
                                    statuses, diffs, days);
                            showAssignment(n, descriptions, codes, courseNames, lecturers, deadlines, subIDs, statuses,
                                    priorities);
                        }
                    }
                }
            }
        }
        sortTasks(n, priorities, descriptions, codes, courseNames, lecturers, deadlines, subIDs, statuses, diffs, days);
        showAssignment(n, descriptions, codes, courseNames, lecturers, deadlines, subIDs, statuses, priorities);
    }

    public static void addTask(int n, String[] descriptions, String[] codes, String[] courseNames, String[] lecturers,
            String[] deadlines, String[] subIDs, int[] diffs, int[] days, String[] statuses, double[] priorities) {
        if (n < 10) {
            descriptions[n] = input.nextLine();
            codes[n] = input.nextLine();
            courseNames[n] = input.nextLine();
            lecturers[n] = input.nextLine();
            deadlines[n] = input.nextLine();
            subIDs[n] = input.nextLine();
            diffs[n] = Integer.parseInt(input.nextLine());
            days[n] = Integer.parseInt(input.nextLine());
            statuses[n] = input.nextLine();
            if (days[n] == 0) {
                priorities[n] = diffs[n] * 1.0;
            } else {
                priorities[n] = diffs[n] * 1.0 / days[n];
            }
            n = n + 1;
        }
    }

    public static void showAssignment(int n, String[] descriptions, String[] codes, String[] courseNames,
            String[] lecturers, String[] deadlines, String[] subIDs, String[] statuses, double[] priorities) {
        int i;
        String rekomendasi;

        if (n == 0) {
            System.out.println("Tidak ada tugas yang tersedia.");
        } else {
            for (i = 0; i <= n - 1; i++) {
                rekomendasi = "";
                System.out.println("Prioritas: " + toFixed(priorities[i], 2));
                if (statuses[i].equals("Selesai")) {
                    System.out.println(descriptions[i] + " | " + codes[i] + " | " + courseNames[i] + " | "
                            + lecturers[i] + " | " + subIDs[i] + " | " + statuses[i]);
                } else {
                    if (priorities[i] > 3) {
                        rekomendasi = "Penting! Anda harus mengerjakan tugas ini segera";
                    } else {
                        rekomendasi = "Tugas ini relatif ringan, namun jangan tunda terlalu lama";
                    }
                    System.out.println(
                            descriptions[i] + " | " + codes[i] + " | " + courseNames[i] + " | " + lecturers[i] + " | "
                                    + deadlines[i] + " | " + subIDs[i] + " | " + statuses[i] + " | " + rekomendasi);
                }
                System.out.println("----------------------------------------");
            }
        }
    }

    public static void sortTasks(int n, double[] priorities, String[] descriptions, String[] codes,
            String[] courseNames, String[] lecturers, String[] deadlines, String[] subIDs, String[] statuses,
            int[] diffs, int[] days) {
        int i, j;
        String tempStr;
        double tempReal;
        int tempInt;

        for (i = 0; i <= n - 1; i++) {
            for (j = 0; j <= n - 2 - i; j++) {
                if (priorities[j] < priorities[j + 1]) {
                    tempReal = priorities[j];
                    priorities[j] = priorities[j + 1];
                    priorities[j + 1] = tempReal;
                    tempStr = descriptions[j];
                    descriptions[j] = descriptions[j + 1];
                    descriptions[j + 1] = tempStr;
                    tempStr = codes[j];
                    codes[j] = codes[j + 1];
                    codes[j + 1] = tempStr;
                    tempStr = courseNames[j];
                    courseNames[j] = courseNames[j + 1];
                    courseNames[j + 1] = tempStr;
                    tempStr = lecturers[j];
                    lecturers[j] = lecturers[j + 1];
                    lecturers[j + 1] = tempStr;
                    tempStr = deadlines[j];
                    deadlines[j] = deadlines[j + 1];
                    deadlines[j + 1] = tempStr;
                    tempStr = subIDs[j];
                    subIDs[j] = subIDs[j + 1];
                    subIDs[j + 1] = tempStr;
                    tempStr = statuses[j];
                    statuses[j] = statuses[j + 1];
                    statuses[j + 1] = tempStr;
                    tempInt = diffs[j];
                    diffs[j] = diffs[j + 1];
                    diffs[j + 1] = tempInt;
                    tempInt = days[j];
                    days[j] = days[j + 1];
                    days[j + 1] = tempInt;
                }
            }
        }
    }

    public static void updateTask(int n, String[] codes, String[] statuses) {
        String searchCode;
        String newStatus;
        int i;
        boolean found;

        found = false;
        searchCode = input.nextLine();
        newStatus = input.nextLine();
        for (i = 0; i <= n - 1; i++) {
            if (codes[i].equals(searchCode)) {
                statuses[i] = newStatus;
                found = true;
                System.out.println("Status tugas berhasil diupdate!");
            }
        }
        if (!found) {
            System.out.println("Kode tugas tidak ditemukan!");
        }
    }

    private static String toFixed(double value, int digits) {
        return String.format("%." + digits + "f", value);
    }
}
