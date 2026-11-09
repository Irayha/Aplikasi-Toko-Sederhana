package kelas.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class FormController {

    @FXML private TextField txtKode;
    @FXML private TextField txtNama;
    @FXML private ComboBox<String> cbKategori;
    @FXML private TextField txtHarga;
    @FXML private Label lblError;

    @FXML
    public void initialize() {
        cbKategori.getItems().addAll("Makanan", "Minuman");
    }

    @FXML
    private void handleSimpan() {
        String hargaTeks = txtHarga.getText() == null ? "" : txtHarga.getText().trim();
        long harga;
        try {
            harga = Long.parseLong(hargaTeks);
        } catch (NumberFormatException e) {
            lblError.setText("Harga harus berupa angka bulat yang valid.");
            return;
        }

        try {
            Produk produk = new Produk(
                    txtKode.getText(),
                    txtNama.getText(),
                    cbKategori.getValue(),
                    harga);
            DataProduk.tambah(produk);
            Navigator.keDaftar();
        } catch (IllegalArgumentException e) {
            lblError.setText(e.getMessage());
        }
    }

    @FXML
    private void handleBatal() {
        Navigator.keDaftar();
    }
}
