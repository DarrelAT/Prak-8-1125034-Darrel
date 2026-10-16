package hy.material8database.repository;

import hy.material8database.database.Database;
import hy.material8database.models.MataKuliah;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MataKuliahRepository {
    public List<MataKuliah> getAllMataKuliah() {
        List<MataKuliah> list = new ArrayList<>();
        String sql = "SELECT * FROM matakuliah";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new MataKuliah(rs.getString("kode_mk"), rs.getString("nama_mk"), rs.getInt("sks")));
            }
        } catch (SQLException e) { System.out.println("Gagal ambil matakuliah: " + e.getMessage()); }
        return list;
    }

    public void insertMataKuliah(String kode, String nama, int sks) {
        String sql = "INSERT INTO matakuliah (kode_mk, nama_mk, sks) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, kode);
            pstmt.setString(2, nama);
            pstmt.setInt(3, sks);
            pstmt.executeUpdate();
            System.out.println("-> Mata Kuliah berhasil ditambahkan!");
        } catch (SQLException e) { System.out.println("Gagal tambah matakuliah: " + e.getMessage()); }
    }

    public void updateMataKuliah(String kode, String namaBaru, int sksBaru) {
        String sql = "UPDATE matakuliah SET nama_mk = ?, sks = ? WHERE kode_mk = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, namaBaru);
            pstmt.setInt(2, sksBaru);
            pstmt.setString(3, kode);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("-> Mata Kuliah berhasil di-update!");
            else System.out.println("-> Kode MK tidak ditemukan!");
        } catch (SQLException e) { System.out.println("Gagal update matakuliah: " + e.getMessage()); }
    }

    public void deleteMataKuliah(String kode) {
        String sql = "DELETE FROM matakuliah WHERE kode_mk = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, kode);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("-> Mata Kuliah berhasil dihapus!");
            else System.out.println("-> Kode MK tidak ditemukan!");
        } catch (SQLException e) { System.out.println("Gagal hapus matakuliah: " + e.getMessage()); }
    }
}