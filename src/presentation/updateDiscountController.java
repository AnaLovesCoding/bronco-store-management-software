package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import remoteapi.discount.Discount;
import remoteapi.discount.PostDiscountApi;
import remoteapi.professor.PostProfessorApi;

import java.io.IOException;

public class updateDiscountController {
    private Stage stage,stage1;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField errorField,studentDiscount,professorDiscount;

    @FXML
    protected void onLogoutClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("bsm_home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onAdminPageClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("admin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onUpdateDiscountClick(ActionEvent event) throws IOException {
        if(studentDiscount.getText().isEmpty() || professorDiscount.getText().isEmpty()){
            errorField.setVisible(true);
            errorField.setText(String.format("Discount cannot be empty"));
            return;
        }

        Discount discount = new Discount();
       discount.setStudentDiscount(Long.valueOf(studentDiscount.getText()));
       discount.setProfessorDiscount(Long.valueOf(professorDiscount.getText()));

        PostDiscountApi postDiscountApi = new PostDiscountApi(discount);
        postDiscountApi.setOnSucceeded(apiEvent -> {
            System.out.println("Discount saved");
        });
        new Thread(postDiscountApi).start();




            errorField.setVisible(true);
            errorField.setText(String.format("New Discount Updated Successfully"));
            studentDiscount.setText(null);
            professorDiscount.setText(null);
    }

}

