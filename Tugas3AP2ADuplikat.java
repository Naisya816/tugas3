// Import semua class dari package java.util (seperti Map, List, ArrayList, LinkedHashMap)
import java.util.*;

// Deklarasi class utama dengan nama Tugas3AP2ADuplikat
public class Tugas3AP2ADuplikat {

    // Fungsi untuk mencari elemen ganda dalam array 1 dimensi
    public static void cariDuplikat1D(int[] array) {
        // Membuat map untuk menyimpan elemen dan list indeksnya
        Map<Integer, List<Integer>> indeksMap = new LinkedHashMap<>();
        
        // Iterasi array untuk mengisi map
        for (int i = 0; i < array.length; i++) {
            // Jika elemen belum ada di map, tambahkan dengan list baru
            indeksMap.putIfAbsent(array[i], new ArrayList<>());
            // Tambahkan indeks elemen saat ini ke list
            indeksMap.get(array[i]).add(i);
        }

        int count = 1; // Untuk penomoran elemen ganda
        System.out.println("- Output 1D:");
        
        // Cek setiap entry dalam map
        for (Map.Entry<Integer, List<Integer>> entry : indeksMap.entrySet()) {
            // Jika elemen muncul lebih dari 1 kali
            if (entry.getValue().size() > 1) {
                System.out.println("Elemen ganda " + count + ": " + entry.getKey());
                System.out.println("Lokasi : " + entry.getValue()); // Tampilkan semua indeksnya
                count++;
                System.out.println();
            }
        }
    }

    // Fungsi untuk mencari elemen ganda dalam array 2 dimensi
    public static void cariDuplikat2D(int[][] array) {
        // Map untuk menyimpan elemen dan posisi-posisinya dalam bentuk string [i][j]
        Map<Integer, List<String>> posisiMap = new LinkedHashMap<>();
        
        // Iterasi seluruh elemen dalam array 2D
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int elemen = array[i][j];
                // Jika elemen belum ada, tambahkan dengan list kosong
                posisiMap.putIfAbsent(elemen, new ArrayList<>());
                // Tambahkan posisi elemen sebagai string [i][j]
                posisiMap.get(elemen).add("[" + i + "][" + j + "]");
            }
        }

        int count = 1; // Penomoran elemen ganda
        System.out.println("- Output 2D:");

        // Cek map dan tampilkan elemen yang duplikat
        for (Map.Entry<Integer, List<String>> entry : posisiMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println("Elemen ganda " + count + ": " + entry.getKey());
                System.out.println("Lokasi : " + String.join(" dan ", entry.getValue()));
                count++;
                System.out.println();
            }
        }
    }

    // Fungsi main untuk menjalankan program
    public static void main(String[] args) {
        // Deklarasi dan inisialisasi array 1D dengan beberapa elemen ganda
        int[] array1D = {5, 0, 21, 21, 0, 7};
        // Panggil fungsi untuk cari duplikat di array 1D
        cariDuplikat1D(array1D);

        // Deklarasi dan inisialisasi array 2D dengan elemen ganda
        int[][] array2D = {
            {5, 8, 19, 7},
            {3, 7, 6, 19}
        };
        // Panggil fungsi untuk cari duplikat di array 2D
        cariDuplikat2D(array2D);
    }
}
