module com.example.tugasakhir2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.tugasakhir2 to javafx.fxml;
    exports com.example.tugasakhir2;
}