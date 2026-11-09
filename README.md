

Aplikasi desktop sederhana berbasis **JavaFX** untuk mencatat produk toko (makanan dan minuman). Dibuat sebagai **Tugas Individu mata kuliah Pemrograman Lanjut**, hasil modifikasi dari aplikasi praktikum.

## Tampilan Aplikasi

### Halaman Daftar Produk
Menampilkan tabel produk, kolom pencarian, serta tombol Tambah Produk dan Lihat Detail.

<p align="center">
  <img src="assets/View.png" alt="Preview Aplikasi Kalkulator BMI" width="350"/>

</p>

---



### Halaman Tambah Produk
Form untuk mengisi kode, nama, kategori, dan harga produk.

<p align="center">
  <img src="assets/View.png" alt="Preview Aplikasi Kalkulator BMI" width="350"/>

</p>

---



### Validasi Input
Nama kosong atau harga tidak valid akan ditolak dengan pesan kesalahan.

<p align="center">
  <img src="assets/View.png" alt="Preview Aplikasi Kalkulator BMI" width="350"/>

</p>

---



### Hasil Pencarian
Produk dicari berdasarkan nama melalui tombol **Cari**.

<p align="center">
  <img src="assets/View.png" alt="Preview Aplikasi Kalkulator BMI" width="350"/>

</p>

---



### Halaman Detail Produk
Menampilkan data produk yang dipilih dari tabel.

<p align="center">
  <img src="assets/View.png" alt="Preview Aplikasi Kalkulator BMI" width="350"/>

</p>

---



## Fitur

- **Tambah produk** lewat form (kode, nama, kategori, harga).
- **Tabel produk** yang menampilkan kode, nama, kategori, dan harga.
- **Cari produk** berdasarkan nama lewat tombol **Cari** (tidak peka huruf besar/kecil).
- **Lihat Detail** untuk membuka halaman detail produk yang dipilih.
- **Validasi input** agar data yang masuk selalu benar.

## Aturan Validasi

| Input | Aturan | Pesan jika salah |
|-------|--------|------------------|
| Kode produk | Tidak boleh kosong dan tidak boleh kembar | Kode produk tidak boleh kosong. / Kode produk sudah digunakan. |
| Nama produk | Tidak boleh kosong | Nama produk tidak boleh kosong. |
| Kategori | Harus dipilih (Makanan atau Minuman) | Kategori harus dipilih. |
| Harga | Harus angka dan lebih dari nol | Harga harus berupa angka bulat yang valid. / Harga harus lebih dari nol. |

## Teknologi

- Java 17+
- JavaFX 17 (FXML + CSS)
- Maven
- NetBeans IDE

## Struktur Proyek

```
ProdukTokoApp
├── pom.xml
├── nbactions.xml
├── screenshots/                      # gambar tampilan untuk README
└── src/main
    ├── java/kelas
    │   ├── MainApp.java              # titik masuk aplikasi
    │   ├── Navigator.java            # perpindahan halaman
    │   ├── controller
    │   │   ├── DaftarController.java # halaman daftar, pencarian, lihat detail
    │   │   ├── FormController.java   # halaman tambah produk + validasi
    │   │   └── DetailController.java # halaman detail (menerima objek Produk)
    │   ├── data
    │   │   └── DataProduk.java       # penyimpanan data selama aplikasi berjalan
    │   └── model
    │       └── Produk.java           # atribut private, constructor, getter
    └── resources/kelas
        ├── daftar.fxml
        ├── form.fxml
        ├── detail.fxml
        └── style.css                 # tampilan dan warna
```

## Cara Menjalankan

### Prasyarat

- JDK 17 atau lebih baru
- NetBeans (dengan dukungan Maven) atau Maven yang terpasang di terminal
- Koneksi internet saat pertama kali membuka proyek, untuk mengunduh dependensi JavaFX

### Lewat NetBeans

1. Clone repository ini:
   ```bash
   https://github.com/Irayha/Aplikasi-Toko-Sederhana/tree/main
   ```
2. Buka NetBeans, pilih **File > Open Project**, lalu pilih folder proyek.
3. Klik kanan project, pilih **Reload POM**, dan tunggu dependensi JavaFX terunduh.
4. Klik kanan project, pilih **Run** (atau tekan `F6`).

### Lewat terminal

```bash
mvn clean javafx:run
```

## Alur Penggunaan

1. Pada halaman **Daftar Produk**, klik **Tambah Produk**.
2. Isi kode, nama, kategori, dan harga, lalu klik **Simpan**.
3. Produk yang tersimpan muncul di tabel.
4. Ketik nama produk di kolom pencarian, lalu klik **Cari**. Klik **Reset** untuk menampilkan semua produk lagi.
5. Pilih satu baris pada tabel, lalu klik **Lihat Detail**.

## Skenario Pengujian

Tambahkan minimal tiga produk, misalnya:

| Kode | Nama | Kategori | Harga |
|------|------|----------|-------|
| P001 | Seblak | Makanan | 10000 |
| P002 | Teh Botol | Minuman | 4000 |
| P003 | Mie Jebew | Makanan | 8000 |

Lalu periksa:

- [x] Ketiga produk muncul pada tabel.
- [x] Pencarian (misalnya "teh") menampilkan produk yang sesuai.
- [x] Tombol **Lihat Detail** menampilkan produk yang dipilih.
- [x] Nama kosong atau harga tidak valid (kosong, huruf, nol, negatif) ditolak.

## Kustomisasi Tampilan

Seluruh warna dan gaya diatur di satu file:

```
src/main/resources/kelas/style.css
```

Ubah kode warna hex (misalnya `#1E6FD9`) sesuai selera, simpan, lalu jalankan ulang aplikasi.

## Catatan

- Data hanya disimpan selama aplikasi berjalan (tanpa database), sehingga hilang saat aplikasi ditutup.
- Aplikasi ini tidak memakai gambar produk, perhitungan transaksi, maupun inheritance.

## Pembuat

- Nama: Dirga Raya Ahyari
- NIM: 2504618
- Mata kuliah: Pemrograman Lanjut
