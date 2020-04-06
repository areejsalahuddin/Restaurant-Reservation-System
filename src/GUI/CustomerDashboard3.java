package GUI;
import Restaurant.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;


public class CustomerDashboard3 {
    private Stage stage;
    private Scene scene;
    private Restaurant restaurant;
    private Table table;
    private Customer customer;
    private LoginScene loginScene;
    private CookDashboard cookDashboard;
    private CustomerDashboard2 customerDashboard2;
    private ManagerDashboard managerDashboard;
    private WaiterDashboard waiterDashboard;
     CustomerOrder customerOrder;

    public void setOrder(CustomerOrder customerOrder){
        this.customerOrder = customerOrder;
    }
    public void setCustomerDashboard2(CustomerDashboard2 customerDashboard2) {
        this.customerDashboard2 = customerDashboard2;
    }


    public void setLoginScene(LoginScene loginScene) {
        this.loginScene = loginScene;
    }

    public CustomerDashboard3(Stage stage) {
        this.stage = stage;
    }
    public void setCookDashboard(CookDashboard cookDashboard) {
        this.cookDashboard = cookDashboard;
    }

    public void setManagerDashboard(ManagerDashboard managerDashboard) {
        this.managerDashboard = managerDashboard;
    }
    public void setWaiterDashboard(WaiterDashboard waiterDashboard) {this.waiterDashboard = waiterDashboard;}
    public void setTable(Table table){
        this.table = table;
    }
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public Restaurant getRestaurant() {
        return this.restaurant;
    }
    public void setCustomer(Customer customer){
          this.customer = customer;
      }
    public String receiptBuilder(List<Dish> chosenDishes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Dish dish : chosenDishes) {
            stringBuilder.append(dish.getDishName() + " (" + dish.getDishPrice() + "EGP)\n");
        }
        return stringBuilder.toString();
    }
    public void prepareScene() {

        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.UP);
        Label checkoutLabel = new Label(" CHECKOUT ");
        checkoutLabel.setFont(Font.font("Century Gothic Font – Safe for Web", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 30));
        checkoutLabel.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
        Label orderLabel = new Label("You Order:");
        orderLabel.setFont(Font.font("Courier New Web Safe Font", FontWeight.BOLD, FontPosture.ITALIC, 17));
        Label summary = new Label("Summary:");
        summary.setFont(Font.font("Courier New Web Safe Font", FontWeight.BOLD, FontPosture.ITALIC, 17));
        Label printing = new Label("\n"+receiptBuilder(customerOrder.getChosenDishes()));
        printing.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 13));
        double taxesPercentage = ((customerOrder.getTotalPriceAfterTaxes()- customerOrder.getTotalPriceBeforeTaxes())/customerOrder.getTotalPriceBeforeTaxes())*100;
        Label totalPriceLabel = new Label("\nTaxes: \n(15% on Main courses)\n(10% on Appetizers)\n(20% on Desserts)"+"\n\nTotal Price of your order=  " + customerOrder.getTotalPriceBeforeTaxes()+ "EGP" +"\nTotal Tax = " + df.format(taxesPercentage) +"%\nTotal Price after Taxes = "+ customerOrder.getTotalPriceAfterTaxes()+ "EGP");
        totalPriceLabel.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 13));
        Label tableInfoLabel = new Label("Table Information:");
        tableInfoLabel.setFont(Font.font("Courier New Web Safe Font", FontWeight.BOLD, FontPosture.ITALIC, 17));
        Label tableInfo = new Label("\nTable Number is " + table.getTableNumber() + "\nNumber of Seats is " + table.getNumberOfSeats() + "\nTable Type : Smoking? " + table.getTableType());
        tableInfo.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 13));
        Label customerInfoLabel = new Label("Customer's Information: ");
        customerInfoLabel.setFont(Font.font("Courier New Web Safe Font", FontWeight.BOLD, FontPosture.ITALIC, 17));
        Label customerInfo = new Label("\nCustomer Name is "+ customer.getName() +"\nUsername = " + customer.getUsername());
        customerInfo.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 13));
        Button logout = new Button("Logout");
        Button back = new Button("Back");
        Button save =  new Button("Save");
        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(30,20,20,20));
        flowPane.setVgap(10);
        flowPane.setHgap(10);
        flowPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, new CornerRadii(10), new BorderWidths(10))));
        HBox hBox = new HBox(15,customerInfoLabel,customerInfo);
        HBox hBox1 = new HBox(20,tableInfoLabel,tableInfo);
        HBox hBox2 = new HBox(15,orderLabel,printing);
        HBox hBox4 = new HBox(15,summary,totalPriceLabel);
        HBox hBox5 = new HBox(15,logout,back,save);
        VBox vBox5 = new VBox(15,hBox2,hBox4);
        HBox hBox3 =  new HBox(15,vBox5);
        VBox vBox1 = new VBox(15,hBox);
        VBox vBox2= new VBox(15,hBox1);
        VBox vBox3 = new VBox(15,hBox5);
        VBox vBox4 = new VBox(15,hBox3);
        VBox vbox = new VBox(20,checkoutLabel,vBox1,vBox2,vBox4,vBox3);
        flowPane.getChildren().addAll(vbox);
        scene = new Scene(flowPane, 650, 600);

        logout.setOnAction(e->{
            cookDashboard.setRestaurant(restaurant);
            managerDashboard.setRestaurant(restaurant);
            waiterDashboard.setRestaurant(restaurant);
            loginScene.prepareScene();
            stage.setScene(loginScene.getScene());
        });
        back.setOnAction(e2->{
            stage.setScene(customerDashboard2.getScene());
        });
        save.setOnAction(e3->{
            try {
                customer.saveReservation(customer.getName(),table.getTableNumber(),table.getTableType(),table.getNumberOfSeats(),customerOrder.getChosenDishes(),customerOrder.getTotalPriceAfterTaxes());
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        });
    }

    public Scene getScene() {

        return this.scene;
    }


}
