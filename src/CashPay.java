package src;


import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.table.TableColumn;

import static javafx.application.Application.launch;
//extends application for JavaFX


public class CashPay implements Initializable{
    @FXML


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    private Stage stage;
    private Scene scene;
    private  Parent root;

    // Implemented the back button to return back to the Payment Page
    public void switchBackToPaymentMethod() throws IOException {

        Main main = new Main();
        main.changeScene("PayMethod.fxml", "Dave's Burger");
    }
    public void switchToEdit() throws IOException {
        Main main = new Main();
        main.changeScene("MenuPage.fxml", "Dave's Burger");
    }

    // Get receipt when proceed to payment
    public void getReciept() throws IOException {
        //root = FXMLLoader.load(getClass().getResource("PaymentMethod.fxml"));
        //Main main = new Main();
        //main.changeScene("CashReciept.fxml", "Dave's Burger");

        String custName = nameTextField.getText();
        String mobNum = mobileNumTextField.getText();
        //String subTotal = subTotalLabel.getText();
        //String discount = discountLabel.getText();
        // String total = totalLabel.getText();
        // String paidAmnt = totalLabel.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CashReciept.fxml"));
        root = loader.load();

        CardReciept cardReciept = loader.getController();
        cardReciept.displayCustName(custName);
        cardReciept.displayMobNum(mobNum);
        //cardReciept.displaySubTotal(Float.parseFloat(subTotal));
        //cardReciept.displayDiscount(Float.parseFloat(discount));
        //cardReciept.displayTotal(Float.parseFloat(total));
        //cardReciept.displayPaidAmount(Float.parseFloat(paidAmnt));

        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
