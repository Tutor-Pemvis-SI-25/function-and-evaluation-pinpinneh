//Ervinna Christine Debora - 12S25059

import java.util.*;
import java.lang.Math;

public class TLAST {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int mAX;

        mAX = 10;
        int jlhData;

        jlhData = 0;
        boolean running;

        running = true;
        String perintah;
        String[] kodeMK = new String[mAX];
        String[] namaMK = new String[mAX];
        String[] keterangan = new String[mAX];
        String[] status = new String[mAX];
        int[] deadline = new int[mAX];
        int[] kesulitan = new int[mAX];
        double[] prioritas = new double[mAX];

        while (running) {
            perintah = input.nextLine();
            if (perintah.equals("Add task")) {
                if (jlhData < mAX) {
                    jlhData = tambahTugas(jlhData, kodeMK, namaMK, deadline, kesulitan, keterangan, status, prioritas);
                } else {
                    System.out.println("Array Penuh!");
                }
            } else {
                if (perintah.equals("(Update task status)")) {
                    updateStatus(jlhData, kodeMK, status);
                } else {
                    if (perintah.equals("(Show assignment)")) {
                        tampilTugas(jlhData, kodeMK, namaMK, status, deadline, kesulitan, keterangan, prioritas);
                    } else {
                        if (perintah.equals("Exit")) {
                            running = false;
                        } else {
                            System.out.println("Perintah salah.");
                        }
                    }
                }
            }
        }
    }

    public static String tambahTugas(int currentCount, String[] kodeMK, String[] namaMK, int[] deadline,
            int[] kesulitan, String[] keterangan, String[] status, double[] prioritas) {
        int newCount;

        namaMK[currentCount] = input.nextLine();
        kodeMK[currentCount] = input.nextLine();
        deadline[currentCount] = Integer.parseInt(input.nextLine());
        kesulitan[currentCount] = Integer.parseInt(input.nextLine());
        keterangan[currentCount] = input.nextLine();
        if (keterangan[currentCount].equals("---")) {
            System.out.println("Input Dibatalkan.");
            newCount = currentCount;
        } else {
            System.out.println("Masukkan Status (Belum/Selesai):");
            status[currentCount] = input.nextLine();
            if (deadline[currentCount] > 0) {
                prioritas[currentCount] = kesulitan[currentCount] * 1.0 / deadline[currentCount];
            } else {
                prioritas[currentCount] = kesulitan[currentCount] * 100;
            }
            newCount = currentCount + 1;
            System.out.println("Berhasil Disimpan.");
        }

        return newCount;
    }

    public static void tampilTugas(int jlhData, String[] kodeMK, String[] namaMK, String[] status, int[] deadline,
            int[] kesulitan, String[] keterangan, double[] prioritas) {
        int i, j;
        double tempPrio;
        String tempKode, tempNama, tempStat, tempKet;
        int tempDead, tempSulit;

        for (i = 0; i <= jlhData - 2; i++) {
            for (j = 0; j <= jlhData - 2 - i; j++) {
                if (prioritas[j] < prioritas[j + 1]) {
                    tempPrio = prioritas[j];
                    prioritas[j] = prioritas[j + 1];
                    prioritas[j + 1] = tempPrio;
                    tempKode = kodeMK[j];
                    kodeMK[j] = kodeMK[j + 1];
                    kodeMK[j + 1] = tempKode;
                    tempNama = namaMK[j];
                    namaMK[j] = namaMK[j + 1];
                    namaMK[j + 1] = tempNama;
                    tempStat = status[j];
                    status[j] = status[j + 1];
                    status[j + 1] = tempStat;
                    tempDead = deadline[j];
                    deadline[j] = deadline[j + 1];
                    deadline[j + 1] = tempDead;
                    tempSulit = kesulitan[j];
                    kesulitan[j] = kesulitan[j + 1];
                    kesulitan[j + 1] = tempSulit;
                    tempKet = keterangan[j];
                    keterangan[j] = keterangan[j + 1];
                    keterangan[j + 1] = tempKet;
                }
            }
        }
        System.out.println("--- DAFTAR TUGAS (URUT PRIORITAS) ---");
        for (i = 0; i <= jlhData - 1; i++) {
            System.out.println("[Kode: " + kodeMK[i] + "] " + namaMK[i]);
            System.out.println("Status: " + status[i]);
            System.out.println("Prioritas: " + prioritas[i]);
            if (prioritas[i] > 3) {
                System.out.println(">> PENTING! Kerjakan segera.");
            } else {
                if (prioritas[i] >= 1.5) {
                    System.out.println(">> Prioritas Menengah.");
                } else {
                    System.out.println(">> Tugas Ringan.");
                }
            }
            if (status[i].equals("Selesai")) {
            } else {
                System.out.println("Deadline: " + deadline[i] + " hari");
                System.out.println("Keterangan: " + keterangan[i]);
            }
            System.out.println("--------------------------------");
        }
    }

    public static void updateStatus(int jlhData, String[] kodeMK, String[] status) {
        String cariKode, statusBaru;
        boolean found;
        int i;

        System.out.println("Kode Mata Kuliah yang diupdate:");
        cariKode = input.nextLine();
        System.out.println("Status Baru:");
        statusBaru = input.nextLine();
        found = false;
        for (i = 0; i <= jlhData - 1; i++) {
            if (kodeMK[i].equals(cariKode)) {
                status[i] = statusBaru;
                found = true;
                System.out.println("Status Berhasil Diupdate!");
            }
        }
        if (!found) {
            System.out.println("Kode tidak ditemukan.");
        }
    }
}
