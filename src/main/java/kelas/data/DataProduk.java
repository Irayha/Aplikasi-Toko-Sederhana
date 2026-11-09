package kelas.data;

import java.util.ArrayList;
import java.util.List;
import kelas.model.Produk;

//pwnyimpanan
public class DataProduk {

    private static final List<Produk> DAFTAR = new ArrayList<>();

    private DataProduk() {
    }

    public static void tambah(Produk produk) {
        for (Produk p : DAFTAR) {
            if (p.getKode().equalsIgnoreCase(produk.getKode())) {
                throw new IllegalArgumentException("Kode produk sudah digunakan.");
            }
        }
        DAFTAR.add(produk);
    }

    public static List<Produk> semua() {
        return new ArrayList<>(DAFTAR);
    }

    //cari
    public static List<Produk> cari(String kataKunci) {
        List<Produk> hasil = new ArrayList<>();
        String kunci = kataKunci == null ? "" : kataKunci.trim().toLowerCase();
        for (Produk p : DAFTAR) {
            if (p.getNama().toLowerCase().contains(kunci)) {
                hasil.add(p);
            }
        }
        return hasil;
    }
}
