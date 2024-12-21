package model;

public class Absensi {
    private int idMahasiswa;
    private String namaMahasiswa;
    private String kelas;
    private String tanggalAbsen;
    private String statusKehadiran;

    // Getters and Setters
    public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(int idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getTanggalAbsen() {
        return tanggalAbsen;
    }

    public void setTanggalAbsen(String tanggalAbsen) {
        this.tanggalAbsen = tanggalAbsen;
    }

    public String getStatusKehadiran() {
        return statusKehadiran;
    }

    public void setStatusKehadiran(String statusKehadiran) {
        this.statusKehadiran = statusKehadiran;
    }
}
