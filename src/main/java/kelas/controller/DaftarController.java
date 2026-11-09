package kelas.controller;

import java.util.List;
import java.util.Locale;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class DaftarController {

    @FXML private TextField txtCari;
    @FXML private TableView<Produk> tabel;
    @FXML private TableColumn<Produk, String> kolKode;
    @FXML private TableColumn<Produk, String> kolNama;
    @FXML private TableColumn<Produk, String> kolKategori;
    @FXML private TableColumn<Produk, String> kolHarga;
    @FXML private Label lblPesan;

    @FXML
    public void initialize() {
        kolKode.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getKode()));
        kolNama.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNama()));
        kolKategori.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getKategori()));
        kolHarga.setCellValueFactory(c -> new SimpleStringProperty(formatRupiah(c.getValue().getHarga())));
        tampilkan(DataProduk.semua());
    }

    @FXML
    private void handleCari() {
        List<Produk> hasil = DataProduk.cari(txtCari.getText());
        tampilkan(hasil);
        if (hasil.isEmpty()) {
            lblPesan.setText("Produk tidak ditemukan.");
        } else {
            lblPesan.setText(hasil.size() + " produk ditemukan.");
        }
    }

    @FXML
    private void handleReset() {
        txtCari.clear();
        tampilkan(DataProduk.semua());
        lblPesan.setText("");
    }

    @FXML
    private void handleTambah() {
        Navigator.keForm();
    }

    @FXML
    private void handleDetail() {
        Produk dipilih = tabel.getSelectionModel().getSelectedItem();
        if (dipilih == null) {
            lblPesan.setText("Pilih produk pada tabel terlebih dahulu.");
            return;
        }
        Navigator.keDetail(dipilih);
    }

    private void tampilkan(List<Produk> data) {
        tabel.setItems(FXCollections.observableArrayList(data));
    }

    public static String formatRupiah(long harga) {
        return String.format(Locale.forLanguageTag("id-ID"), "Rp %,d", harga);
    }
}
