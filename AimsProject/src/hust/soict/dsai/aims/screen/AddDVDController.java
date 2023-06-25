package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddDVDController {
    private Store store;

    @FXML
    private Button btnSave;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfDirector;

    @FXML
    private TextField tfLength;

    @FXML
    private TextField tfTitle;

    private boolean checkAllFields = false;

    @FXML
    void btnSavePressed(ActionEvent event) {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String director = tfDirector.getText();
        float cost = 0.0f;
        int length = 0;
        try {
            cost = Float.parseFloat(tfCost.getText());
            length = Integer.parseInt(tfLength.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to parse number!");
            alert.setTitle("Wrong type");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
        store.addMedia(dvd);
        tfTitle.clear();
        tfCategory.clear();
        tfCost.clear();
        tfDirector.clear();
        tfLength.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "DVD has been added to the store!");
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        btnSave.setDisable(true);

        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkTextFields());
        tfCategory.textProperty().addListener((observable, oldValue, newValue) -> checkTextFields());
        tfCost.textProperty().addListener((observable, oldValue, newValue) -> checkTextFields());
        tfLength.textProperty().addListener((observable, oldValue, newValue) -> checkTextFields());
        tfDirector.textProperty().addListener((observable, oldValue, newValue) -> checkTextFields());
    }

    private void checkTextFields(){
        if (!tfTitle.getText().isEmpty() && !tfCategory.getText().isEmpty() && !tfCost.getText().isEmpty() && !tfDirector.getText().isEmpty() && !tfLength.getText().isEmpty()){
            checkAllFields = true;
        } else {
            checkAllFields = false;
        }
        btnSave.setDisable(!checkAllFields);
    }

    public AddDVDController(Store store){
        super();
        this.store = store;
    }
}
