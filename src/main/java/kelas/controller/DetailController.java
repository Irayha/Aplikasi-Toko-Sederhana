package kelas.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import kelas.Navigator;
import kelas.model.Produk;

public class DetailController {

    @FXML private Label lblKode;
    @FXML private Label lblNama;
    @FXML private Label lblKategori;
    @FXML private Label lblHarga;

    /** Dipanggil oleh Navigator untuk mengirim produk yang dipilih. */
    public void setProduk(Produk produk) {
        lblKode.setText(produk.getKode());
        lblNama.setText(produk.getNama());
        lblKategori.setText(produk.getKategori());
        lblHarga.setText(DaftarController.formatRupiah(produk.getHarga()));
    }

    @FXML
    private void handleKembali() {
        Navigator.keDaftar();
    }
}
