package hy.material8database;

import hy.material8database.models.Jurusan;
import hy.material8database.models.Mahasiswa;
import hy.material8database.models.MataKuliah;
import hy.material8database.repository.JurusanRepository;
import hy.material8database.repository.MahasiswaRepository;
import hy.material8database.repository.MataKuliahRepository;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MahasiswaRepository mhsRepo = new MahasiswaRepository();
        JurusanRepository jurRepo = new JurusanRepository();
        MataKuliahRepository mkRepo = new MataKuliahRepository();

        boolean running = true;
        while (running) {
            System.out.println("\n==================================");
            System.out.println("Menu:");
            System.out.println("1. mahasiswa");
            System.out.println("     1. view all");
            System.out.println("     2. create");
            System.out.println("     3. edit");
            System.out.println("     4. delete");
            System.out.println("     5. ambil matkul");
            System.out.println("2. jurusan");
            System.out.println("     1. view all");
            System.out.println("     2. create");
            System.out.println("     3. edit");
            System.out.println("     4. delete");
            System.out.println("3. mata kuliah");
            System.out.println("     1. view all");
            System.out.println("     2. create");
            System.out.println("     3. edit");
            System.out.println("     4. delete");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu utama (1-3, 0=Keluar): ");
            
            int menuUtama = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (menuUtama) {
                case 1: // MAHASISWA
                    System.out.print("Pilih sub-menu mahasiswa (1-5): ");
                    int subMhs = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (subMhs == 1) {
                        List<Mahasiswa> list = mhsRepo.getAllMahasiswa();
                        System.out.println("\n--- DATA MAHASISWA ---");
                        for (Mahasiswa m : list) {
                            System.out.println("NIM: " + m.getNim() + " | Nama: " + m.getNama() + " | Kode Jurusan: " + m.getKodeJurusan());
                        }
                    } else if (subMhs == 2) {
                        System.out.print("Masukkan NIM: "); String nim = scanner.nextLine();
                        System.out.print("Masukkan Nama: "); String nama = scanner.nextLine();
                        System.out.print("Masukkan Kode Jurusan: "); String kodeJur = scanner.nextLine();
                        mhsRepo.insertMahasiswa(nim, nama, kodeJur);
                    } else if (subMhs == 3) {
                        System.out.print("Masukkan NIM mahasiswa yang mau diedit: "); String nim = scanner.nextLine();
                        System.out.print("Masukkan Nama Baru: "); String nama = scanner.nextLine();
                        System.out.print("Masukkan Kode Jurusan Baru: "); String kodeJur = scanner.nextLine();
                        mhsRepo.updateMahasiswa(nim, nama, kodeJur);
                    } else if (subMhs == 4) {
                        System.out.print("Masukkan NIM mahasiswa yang mau dihapus: "); String nim = scanner.nextLine();
                        mhsRepo.deleteMahasiswa(nim);
                    } else if (subMhs == 5) {
                        System.out.print("Masukkan NIM mahasiswa: "); String nim = scanner.nextLine();
                        System.out.print("Masukkan Kode Mata Kuliah: "); String kodeMk = scanner.nextLine();
                        mhsRepo.ambilMatkul(nim, kodeMk);
                    }
                    break;

                case 2: // JURUSAN
                    System.out.print("Pilih sub-menu jurusan (1-4): ");
                    int subJur = scanner.nextInt();
                    scanner.nextLine();

                    if (subJur == 1) {
                        List<Jurusan> list = jurRepo.getAllJurusan();
                        System.out.println("\n--- DATA JURUSAN ---");
                        for (Jurusan j : list) {
                            System.out.println("Kode: " + j.getKodeJurusan() + " | Nama Jurusan: " + j.getNamaJurusan());
                        }
                    } else if (subJur == 2) {
                        System.out.print("Masukkan Kode Jurusan: "); String kode = scanner.nextLine();
                        System.out.print("Masukkan Nama Jurusan: "); String nama = scanner.nextLine();
                        jurRepo.insertJurusan(kode, nama);
                    } else if (subJur == 3) {
                        System.out.print("Masukkan Kode Jurusan yang mau diedit: "); String kode = scanner.nextLine();
                        System.out.print("Masukkan Nama Jurusan Baru: "); String nama = scanner.nextLine();
                        jurRepo.updateJurusan(kode, nama);
                    } else if (subJur == 4) {
                        System.out.print("Masukkan Kode Jurusan yang mau dihapus: "); String kode = scanner.nextLine();
                        jurRepo.deleteJurusan(kode);
                    }
                    break;

                case 3: // MATA KULIAH
                    System.out.print("Pilih sub-menu mata kuliah (1-4): ");
                    int subMk = scanner.nextInt();
                    scanner.nextLine();

                    if (subMk == 1) {
                        List<MataKuliah> list = mkRepo.getAllMataKuliah();
                        System.out.println("\n--- DATA MATA KULIAH ---");
                        for (MataKuliah mk : list) {
                            System.out.println("Kode MK: " + mk.getKodeMk() + " | Nama MK: " + mk.getNamaMk() + " | SKS: " + mk.getSks());
                        }
                    } else if (subMk == 2) {
                        System.out.print("Masukkan Kode MK: "); String kode = scanner.nextLine();
                        System.out.print("Masukkan Nama MK: "); String nama = scanner.nextLine();
                        System.out.print("Masukkan Jumlah SKS: "); int sks = scanner.nextInt();
                        mkRepo.insertMataKuliah(kode, nama, sks);
                    } else if (subMk == 3) {
                        System.out.print("Masukkan Kode MK yang mau diedit: "); String kode = scanner.nextLine();
                        System.out.print("Masukkan Nama MK Baru: "); String nama = scanner.nextLine();
                        System.out.print("Masukkan SKS Baru: "); int sks = scanner.nextInt();
                        mkRepo.updateMataKuliah(kode, nama, sks);
                    } else if (subMk == 4) {
                        System.out.print("Masukkan Kode MK yang mau dihapus: "); String kode = scanner.nextLine();
                        mkRepo.deleteMataKuliah(kode);
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}