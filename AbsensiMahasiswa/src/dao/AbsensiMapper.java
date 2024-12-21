package dao;

import model.Absensi;
import java.util.List;

public interface AbsensiMapper {
    List<Absensi> ambilSemuaAbsensi();
    void tambahAbsensi(Absensi absensi);
    void updateAbsensi(Absensi absensi);
    void hapusAbsensi(int idMahasiswa);
}
