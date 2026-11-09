package kelas;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kelas.controller.DetailController;
import kelas.model.Produk;

/**
 * Mengatur perpindahan halaman (scene) pada aplikasi.
 */
public class Navigator {

    private static Stage stage;

    private Navigator() {
    }

    public static void setStage(Stage s) {
        stage = s;
    }

    public static void keDaftar() {
        tampilkan(muat("daftar.fxml").root);
    }

    public static void keForm() {
        tampilkan(muat("form.fxml").root);
    }

    /** Membuka halaman detail dengan mengirim objek Produk yang dipilih. */
    public static void keDetail(Produk produk) {
        Halaman h = muat("detail.fxml");
        DetailController controller = h.loader.getController();
        controller.setProduk(produk);
        tampilkan(h.root);
    }

    private static Halaman muat(String namaFile) {
        try {
            FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(namaFile));
            Parent root = loader.load();
            return new Halaman(loader, root);
        } catch (IOException e) {
            throw new RuntimeException("Gagal memuat " + namaFile, e);
        }
    }

    private static void tampilkan(Parent root) {
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(Navigator.class.getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }

    private static class Halaman {
        final FXMLLoader loader;
        final Parent root;

        Halaman(FXMLLoader loader, Parent root) {
            this.loader = loader;
            this.root = root;
        }
    }
}
