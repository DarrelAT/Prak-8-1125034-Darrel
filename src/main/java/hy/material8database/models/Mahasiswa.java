package hy.material8database.models;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String kodeJurusan;

    // Constructor
    public Mahasiswa(String nim, String nama, String kodeJurusan) {
        this.nim = nim;
        this.nama = nama;
        this.kodeJurusan = kodeJurusan;
    }

    // Getter dan Setter
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKodeJurusan() {
        return kodeJurusan;
    }

    public void setKodeJurusan(String kodeJurusan) {
        this.kodeJurusan = kodeJurusan;
    }
}