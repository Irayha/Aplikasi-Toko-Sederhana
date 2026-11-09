package kelas.model;

public class Produk {

    private final String kode;
    private final String nama;
    private final String kategori; 
    private final long harga;

    public Produk(String kode, String nama, String kategori, long harga) {
        if (kode == null || kode.trim().isEmpty()) {
            throw new IllegalArgumentException("Kode produk tidak boleh kosong.");
        }
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong.");
        }
        if (kategori == null || kategori.trim().isEmpty()) {
            throw new IllegalArgumentException("Kategori harus dipilih.");
        }
        if (harga <= 0) {
            throw new IllegalArgumentException("Harga harus lebih dari nol.");
        }
        this.kode = kode.trim();
        this.nama = nama.trim();
        this.kategori = kategori;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public long getHarga() {
        return harga;
    }
}
