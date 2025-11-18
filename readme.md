[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/qWlo9Zcj)
# Tutor-Task-Management-System :Update

Sistem Manajemen Tugas yang dibangun oleh Ucok dan Butet telah menjadi semakin canggih, namun mereka merasa belum puas dengan hasil karyanya karena masih terdapat kelemahan dalam aplikasi yang telah mereka bangun. Salah satu kelemahan yang ditemukan dalam aplikasi tersebut adalah ketidakmampuannya untuk mengupdate status tugas setelah tugas tersebut selesai dikerjakan dan disubmit. Oleh karena itu, Ucok dan Butet memutuskan untuk menambahkan fitur Update. Update hanya akan dilakukan terhadap mata kuliah yang ingin diupdate. Pemilihan mata kuliah yang akan diupdate dilakukan berdasarkan kode mata kuliah yang dimasukkan.

Sebelum beralih ke coding, Ucok berpikir bahwa menerapkan konsep fungsi pada program yang telah mereka bangun adalah solusi agar pemeliharaan program menjadi lebih mudah ke depannya seiring dengan banyaknya program yang telah mereka buat. Kebetulan, materi yang dibahas dalam perkuliahan minggu ini adalah fungsi, sehingga mereka memutuskan untuk menerapkannya.

Dalam kasus ini, Anda diminta untuk membuat fitur update untuk status tugas mahasiswa. Namun, sebelum itu, terdapat beberapa perubahan pada inputan sebelumnya. Pada kasus kali ini, ada perintah tambahan di setiap tindakan yang akan dilakukan oleh program. `(Add task)` adalah perintah yang digunakan untuk menambahkan daftar tugas ke program. Perintah ini akan diikuti oleh input untuk setiap atribut tugas.`(Update task status)` adalah perintah yang akan digunakan untuk melakukan update dari status tugas. Perintah ini akan diikuti oleh input **kode mata kuliah** yang statusnya akan diupdate dan **status baru** dari tugas. `(Show assignment)` adalah perintah yang digunakan untuk menampilkan semua daftar tugas yang sebelumnya telah ditambahkan.Perlu di ingat bahawa ketika status dari tugas studah **Selesai**,maka ketika akan menampilkan tugas tersebut atribut **dedlain** dan **keterangan** tidak perlu lagi ditampilkan.Kemudian Program akan menampilkan daftar tugas di urutkan berdasarkan **prioritas** paling besar
Program akan terus menerima input dari pengguna. Karena program akan terus menerima input dan adanya fitur tambahan yaitu update status, akan sangat baik jika setiap informasi tugas disimpan dalam sebuah array. Maksimum tugas yang dapat diterima oleh program adalah 10. Program akan berhenti menerima input ketika pengguna memberikan masukan terhadap Deskripsi Tugas yaitu `---` atau sudah mencapai maksimum.

Cara menghitung prioritas:
prioritas =TingkatKesulitan x (1.0 / hariHinggaDeadline)

Berdasarkan prioritas, sistem akan memberikan rekomendasi tindakan kepada mahasiswa.

Jika prioritas di atas 3: "Penting! Anda harus mengerjakan tugas ini segera"
Jika prioritas di antara 1.5 hingga 3: "Tugas ini memiliki prioritas menengah"
Jika prioritas di bawah 1.5: "Tugas ini relatif ringan, namun jangan tunda terlalu lama"

## Input - Output Simulation

Dalam simulasi ini, pengguna akan memasukkan perintah awal dan kemudian akan diikuti oleh setiap tindakan yang akan dilakukan oleh program sesuai dengan perintah sebelumnya.Berikut adalah contoh simulasi Input - Output

### Example 1

**Input**:

```bash

Add task    ##Perintah untuk menambah list tugas
Buat program untuk simulasi ATM sederhana
12S1103
Pemrograman Lanjutan
Dr. Emily Watson
4 November 2023, pukul 15.00 WIB
12S22005_ButetMarpaung_PemrogramanLanjutan
5   # Tingkat Kesulitan (1-5)
3   # Hari hingga deadline
Belum Selesai   # Status (Selesai/Belum Selesai)
Add task   ##Perintah untuk menambah list tugas
Buat program face recognition
12S1104
Kecerdasan buatan
Dr. Samuel
10 November 2023, pukul 15.00 WIB
12S22005_ButetMarpaung_Kecerdasan_buatan
5   # Tingkat Kesulitan (1-5)
1   # Hari hingga deadlinne
Belum Selesai   # Status (Selesai/Belum Selesai)
Update task status ##Perintah untuk meng-update status tugas
12S1103
Selesai
Show assigment  ##Perintah untuk menampilkan list tugas
---

```

**Output**:

```bash
Prioritas: 5.00
Buat program face recognition|12S1104|Kecerdasan buatan|Dr. Samuel|10 November 2023, pukul 15.00 WIB|12S22005_ButetMarpaung_Kecerdasan_buatan|Belum Selesai|Penting! Anda harus mengerjakan tugas ini segera
Prioritas: 1.67
Buat program untuk simulasi ATM sederhana|12S1103|Pemrograman Lanjutan|Dr. Emily Watson|12S22005_ButetMarpaung_Kecerdasan_buatan|Selesai

```

### example 2

**Input**:

```bash

Add task
Adversarial Search and Constraint Satisfaction Problem
10S3001
Artificial Intelligence
Dr. Sam
16 November 2023, pukul 15.00 WIB
12S22017_Joseph_PemrogramanLanjutan
8
4
Belum Selesai
Add task
Physical Storage Systems
12S3102
Advanced Database
Dr. Toni
21 November 2023, pukul 15.00 WIB
12S22017_Joseph_AdvancedDatabase
6
2
Belum Selesai
Update task status
12S3102
Selesai
Show assigment
Add task
Project Management Information System
12S1101
Information System Foundation
Dr. Natalia
18 November 2023, pukul 15.00 WIB
12S22017_Joseph_InformationSystemFoundation
7
5
Belum Selesai
Show assigment
Add task
Problem Decompositon and Problem Identification
TIS1101
Digital Innovation
Dr. Sari
15 November 2023, pukul 15.00 WIB
12S22017_Joseph_DigitalInnovation
5
2
Belum Selesai
Update task status
TIS1101
Selesai
Show assigment
---

```

**Output**:

```bash

Prioritas: 3.00
Physical Storage Systems|12S3102|Advanced Database|Dr. Toni|12S22017_Joseph_AdvancedDatabase|Selesai
Prioritas: 2.00
Adversarial Search and Constraint Satisfaction Problem|10S3001|Artificial Intelligence|Dr. Sam|16 November 2023, pukul 15.00 WIB|12S22017_Joseph_AdvancedDatabase|Belum Selesai|Tugas ini memiliki prioritas menengah
Prioritas: 3.00
Physical Storage Systems|12S3102|Advanced Database|Dr. Toni|12S22017_Joseph_AdvancedDatabase|Selesai
Prioritas: 2.00
Adversarial Search and Constraint Satisfaction Problem|10S3001|Artificial Intelligence|Dr. Sam|16 November 2023, pukul 15.00 WIB|12S22017_Joseph_AdvancedDatabase|Belum Selesai|Tugas ini memiliki prioritas menengah
Prioritas: 1.40
Project Management Information System|12S1101|Information System Foundation|Dr. Natalia|18 November 2023, pukul 15.00 WIB|12S22017_Joseph_InformationSystemFoundation|Belum Selesai|Tugas ini relatif ringan, namun jangan tunda terlalu lama
Prioritas: 3.00
Physical Storage Systems|12S3102|Advanced Database|Dr. Toni|12S22017_Joseph_AdvancedDatabase|Selesai
Prioritas: 2.50
Problem Decompositon and Problem Identification|TIS1101|Digital Innovation|Dr. Sari|15 November 2023, pukul 15.00 WIB|12S22017_Joseph_DigitalInnovation|Belum Selesai|Tugas ini memiliki prioritas menengah
Prioritas: 2.00
Adversarial Search and Constraint Satisfaction Problem|10S3001|Artificial Intelligence|Dr. Sam|16 November 2023, pukul 15.00 WIB|12S22017_Joseph_DigitalInnovation|Belum Selesai|Tugas ini memiliki prioritas menengah
Prioritas: 1.40
Project Management Information System|12S1101|Information System Foundation|Dr. Natalia|18 November 2023, pukul 15.00 WIB|12S22017_Joseph_DigitalInnovation|Belum Selesai|Tugas ini relatif ringan, namun jangan tunda terlalu lama

```
