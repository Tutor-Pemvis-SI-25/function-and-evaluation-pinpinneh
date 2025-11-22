// 12S25035-Sintia Geni Audi Nainggolan
// 12S25059- Ervinna Christine Debora

import java.util.*;
import java.lang.Math;

public class TLA {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] descriptions = new String[10], codes = new String[10], courseNames = new String[10], lecturers = new String[10], deadlines = new String[10], subIDs = new String[10], statuses = new String[10];
        int[] diffs = new int[10];
        int[] days = new int[10];
        double[] priorities = new double[10];
        String[] recommendations = new String[10];
        String command;
        int i, n;

        n = 0;
        initialize(descriptions, codes, courseNames, lecturers, deadlines, subIDs, diffs, days, statuses, priorities, recommendations);
        for (i = 0; i <= 9; i++) {
            command = input.nextLine();
            if (command.equals("Add task")) {
                n = addTask(descriptions, codes, courseNames, lecturers, deadlines, subIDs, diffs, days, statuses, priorities, recommendations, i, n);
            } else {
                if (command.equals("Update task status")) {
                    updateStatus(codes, statuses, n);
                    i = i - 1;
                } else {
                    if (command.equals("Show assigment") || command.equals("Show assignment")) {
                        i = i - 1;
                    } else {
                        if (command.equals("---")) {
                            i = 10;
                        }
                    }
                }
            }
        }
        sortTasks(descriptions, codes, courseNames, lecturers, deadlines, subIDs, diffs, days, statuses, priorities, recommendations, n);
        showAssignment(descriptions, codes, courseNames, lecturers, deadlines, subIDs, statuses, priorities, recommendations, n);
    }
    
    public static int addTask(String[] descriptions, String[] codes, String[] courseNames, String[] lecturers, String[] deadlines, String[] subIDs, int[] diffs, int[] days, String[] statuses, double[] priorities, String[] recommendations, int i, int n) {
        descriptions[i] = input.nextLine();
        codes[i] = input.nextLine();
        courseNames[i] = input.nextLine();
        lecturers[i] = input.nextLine();
        deadlines[i] = input.nextLine();
        subIDs[i] = input.nextLine();
        diffs[i] = Integer.parseInt(input.nextLine());
        days[i] = Integer.parseInt(input.nextLine());
        statuses[i] = input.nextLine();
        if (days[i] == 0) {
            priorities[i] = diffs[i] * 1.0;
        } else {
            priorities[i] = diffs[i] * 1.0 / days[i];
        }
        if (priorities[i] > 3) {
            recommendations[i] = "Penting! Anda harus mengerjakan tugas ini segera";
        } else {
            if (priorities[i] <= 3 && priorities[i] >= 1.5) {
                recommendations[i] = "Tugas ini memiliki prioritas menengah";
            } else {
                if (priorities[i] < 1.5) {
                    recommendations[i] = "Tugas ini relatif ringan, namun jangan tunda terlalu lama";
                } else {
                    recommendations[i] = "---";
                }
            }
        }
        n = n + 1;
        
        return n;
    }
    
    public static void initialize(String[] descriptions, String[] codes, String[] courseNames, String[] lecturers, String[] deadlines, String[] subIDs, int[] diffs, int[] days, String[] statuses, double[] priorities, String[] recommendations) {
        int a;

        for (a = 0; a <= 9; a++) {
            descriptions[a] = "";
            codes[a] = "";
            courseNames[a] = "";
            lecturers[a] = "";
            deadlines[a] = "";
            subIDs[a] = "";
            diffs[a] = 0;
            days[a] = 0;
            statuses[a] = "";
            priorities[a] = 0;
            recommendations[a] = "";
        }
    }
    
    public static void showAssignment(String[] descriptions, String[] codes, String[] courseNames, String[] lecturers, String[] deadlines, String[] subIDs, String[] statuses, double[] priorities, String[] recommendations, int n) {
        int i;

        for (i = 0; i <= n - 1; i++) {
            if (statuses[i].equals("Selesai")) {
                System.out.println("Prioritas: " + toFixed(priorities[i],2));
                System.out.println(descriptions[i] + "|" + codes[i] + "|" + courseNames[i] + "|" + lecturers[i] + "|" + subIDs[i] + "|" + statuses[i]);
            } else {
                if (statuses[i].equals("Belum Selesai")) {
                    System.out.println("Prioritas: " + toFixed(priorities[i],2));
                    System.out.println(descriptions[i] + "|" + codes[i] + "|" + courseNames[i] + "|" + lecturers[i] + "|" + deadlines[i] + "|" + subIDs[i] + "|" + statuses[i] + "|" + recommendations[i]);
                }
            }
        }
    }
    
    public static void sortTasks(String[] descriptions, String[] codes, String[] courseNames, String[] lecturers, String[] deadlines, String[] subIDs, int[] diffs, int[] days, String[] statuses, double[] priorities, String[] recommendations, int n) {
        int i, j;
        String tempStr;
        double tempReal;
        int tempInt;

        for (i = 0; i <= n - 1; i++) {
            for (j = i + 1; j <= n - 1; j++) {
                if (priorities[i] < priorities[j]) {
                    tempStr = descriptions[j];
                    descriptions[j] = descriptions[i];
                    descriptions[i] = tempStr;
                    tempStr = codes[j];
                    codes[j] = codes[i];
                    codes[i] = tempStr;
                    tempStr = courseNames[j];
                    courseNames[j] = courseNames[i];
                    courseNames[i] = tempStr;
                    tempStr = lecturers[j];
                    lecturers[j] = lecturers[i];
                    lecturers[i] = tempStr;
                    tempStr = deadlines[j];
                    deadlines[j] = deadlines[i];
                    deadlines[i] = tempStr;
                    tempStr = subIDs[j];
                    subIDs[j] = subIDs[i];
                    subIDs[i] = tempStr;
                    tempInt = diffs[j];
                    diffs[j] = diffs[i];
                    diffs[i] = tempInt;
                    tempInt = days[j];
                    days[j] = days[i];
                    days[i] = tempInt;
                    tempStr = statuses[j];
                    statuses[j] = statuses[i];
                    statuses[i] = tempStr;
                    tempReal = priorities[j];
                    priorities[j] = priorities[i];
                    priorities[i] = tempReal;
                    tempStr = recommendations[j];
                    recommendations[j] = recommendations[i];
                    recommendations[i] = tempStr;
                }
            }
        }
    }
    
    public static void updateStatus(String[] codes, String[] statuses, int n) {
        String searchCode, newStatus;
        int i;

        searchCode = input.nextLine();
        for (i = 0; i <= n - 1; i++) {
            if (searchCode.equals(codes[i])) {
                newStatus = input.nextLine();
                statuses[i] = newStatus;
            }
        }
    }
    
    private static String toFixed(double value, int digits) {
        return String.format("%." + digits + "f", value);
    }
}
