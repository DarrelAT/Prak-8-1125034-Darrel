package hy.material8database.repository;

import hy.material8database.database.Database;
import hy.material8database.models.Jurusan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JurusanRepository {
    public List<Jurusan> getAllJurusan() {
        List<Jurusan> list = new ArrayList<>();
        String sql = "SELECT * FROM jurusan";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Jurusan(rs.getString("kode_jurusan"), rs.getString("nama_jurusan")));
            }
        } catch (SQLException e) { System.out.println("Gagal ambil jurusan: " + e.getMessage()); }
        return list;
    }

    public void insertJurusan(String kode, String nama) {
        String sql = "INSERT INTO jurusan (kode_jurusan, nama_jurusan) VALUES (?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, kode);
            pstmt.setString(2, nama);
            pstmt.executeUpdate();
            System.out.println("-> Jurusan berhasil ditambahkan!");
        } catch (SQLException e) { System.out.println("Gagal tambah jurusan: " + e.getMessage()); }
    }

    public void updateJurusan(String kode, String namaBaru) {
        String sql = "UPDATE jurusan SET nama_jurusan = ? WHERE kode_jurusan = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, namaBaru);
            pstmt.setString(2, kode);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("-> Jurusan berhasil di-update!");
            else System.out.println("-> Kode jurusan tidak ditemukan!");
        } catch (SQLException e) { System.out.println("Gagal update jurusan: " + e.getMessage()); }
    }

    public void deleteJurusan(String kode) {
        String sql = "DELETE FROM jurusan WHERE kode_jurusan = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, kode);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("-> Jurusan berhasil dihapus!");
            else System.out.println("-> Kode jurusan tidak ditemukan!");
        } catch (SQLException e) { System.out.println("Gagal hapus jurusan: " + e.getMessage()); }
    }
}