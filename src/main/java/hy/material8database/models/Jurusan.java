package hy.material8database.models;

public class Jurusan {
    private String kodeJurusan;
    private String namaJurusan;

    public Jurusan(String kodeJurusan, String namaJurusan) {
        this.kodeJurusan = kodeJurusan;
        this.namaJurusan = namaJurusan;
    }

    public String getKodeJurusan() { return kodeJurusan; }
    public void setKodeJurusan(String kodeJurusan) { this.kodeJurusan = kodeJurusan; }

    public String getNamaJurusan() { return namaJurusan; }
    public void setNamaJurusan(String namaJurusan) { this.namaJurusan = namaJurusan; }
}