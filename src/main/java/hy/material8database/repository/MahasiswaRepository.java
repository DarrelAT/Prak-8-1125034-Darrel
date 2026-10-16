package hy.material8database.repository;

import hy.material8database.database.Database;
import hy.material8database.models.Mahasiswa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaRepository {

    public List<Mahasiswa> getAllMahasiswa() {
        List<Mahasiswa> list = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Mahasiswa(rs.getString("nim"), rs.getString("nama"), rs.getString("kode_jurusan")));
            }
        } catch (SQLException e) {
            System.out.println("Gagal ambil data: " + e.getMessage());
        }
        return list;
    }

    public void insertMahasiswa(String nim, String nama, String kodeJurusan) {
        String sql = "INSERT INTO mahasiswa (nim, nama, kode_jurusan) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nim);
            pstmt.setString(2, nama);
            pstmt.setString(3, kodeJurusan);
            pstmt.executeUpdate();
            System.out.println("-> Mahasiswa berhasil ditambahkan!");
        } catch (SQLException e) {
            System.out.println("Gagal tambah mahasiswa: " + e.getMessage());
        }
    }

    public void updateMahasiswa(String nimLama, String namaBaru, String kodeJurusanBaru) {
        String sql = "UPDATE mahasiswa SET nama = ?, kode_jurusan = ? WHERE nim = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, namaBaru);
            pstmt.setString(2, kodeJurusanBaru);
            pstmt.setString(3, nimLama);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("-> Mahasiswa berhasil di-update!");
            else System.out.println("-> NIM tidak ditemukan!");
        } catch (SQLException e) {
            System.out.println("Gagal update mahasiswa: " + e.getMessage());
        }
    }

    public void deleteMahasiswa(String nim) {
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nim);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("-> Mahasiswa berhasil dihapus!");
            else System.out.println("-> NIM tidak ditemukan!");
        } catch (SQLException e) {
            System.out.println("Gagal hapus mahasiswa: " + e.getMessage());
        }
    }

    public void ambilMatkul(String nim, String kodeMk) {
        String sql = "INSERT INTO mahasiswa_matakuliah (nim, kode_mk) VALUES (?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nim);
            pstmt.setString(2, kodeMk);
            pstmt.executeUpdate();
            System.out.println("-> Mahasiswa sukses mengambil mata kuliah!");
        } catch (SQLException e) {
            System.out.println("Gagal ambil matkul: " + e.getMessage());
        }
    }
}