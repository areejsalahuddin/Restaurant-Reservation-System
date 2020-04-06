package GUI;

import Restaurant.*;
import Restaurant.Table;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class CustomerDashboard1 {


    private boolean type;
    private int tableNumber;
    private int numberOfSeats;
    private Table table = new Table();
    private Stage stage;
    private Scene scene;
    private Restaurant restaurant;
    private CustomerDashboard2 customerDashboard2;
    private CustomerDashboard3 customerDashboard3;
    private LoginScene loginScene;

    public CustomerDashboard1(Stage stage) {
        this.stage = stage;
    }

    public void setCustomerDashboard2(CustomerDashboard2 customerDashboard2) {
        this.customerDashboard2 = customerDashboard2;
    }
    public void setCustomerDashboard3(CustomerDashboard3 customerDashboard3) {
        this.customerDashboard3 = customerDashboard3;
    }

    public void setLoginScene(LoginScene loginScene) {
        this.loginScene = loginScene;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public void findTable(int tableNumber)
    {
        for(Table table : restaurant.getTables().getTables())
        {
            if(table.getTableNumber() == tableNumber)
                this.table = table;
        }
    }


    public void prepareScene() //create a button that checks availability
    {
        Label welcome = new Label("Welcome Customer");  //set customer = customer name
        welcome.setPrefWidth(450);
        welcome.setFont(Font.font("Century Gothic Font – Safe for Web", FontWeight.BOLD, FontPosture.ITALIC, 35));
        Label reserveLabel = new Label("Reserve your Table here:");
        reserveLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        reserveLabel.setUnderline(true);
        Label numOfSeatsLabel = new Label("Number of Seats  ");
        numOfSeatsLabel.setFont(Font.font("Courier New Web Safe Font", FontWeight.MEDIUM, FontPosture.ITALIC, 16));
        Text tableNumberText = new Text();
        TextField numOfSeats = new TextField();
        Label message = new Label();
        Label exceptionLabel = new Label();
        Button reserveTable = new Button("Reserve Table");
        Button menuButton = new Button("Check Menu");
        Button logout = new Button("Log out");
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        Label choiceBoxLabel = new Label("Choose the Type of your Table:");
        choiceBoxLabel.setFont(Font.font("Courier New Web Safe Font", FontWeight.MEDIUM, FontPosture.ITALIC, 16));
        choiceBox.getItems().addAll("Smoking", "Non Smoking");
        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(30,20,20,20));
        flowPane.setVgap(10);
        flowPane.setHgap(10);
        flowPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, new CornerRadii(10), new BorderWidths(10))));
        HBox hBox = new HBox(15,reserveLabel);
        HBox hBox1 = new HBox(20,numOfSeatsLabel,numOfSeats,exceptionLabel,message,tableNumberText);
        HBox hBox2 = new HBox(15,choiceBoxLabel,choiceBox);
        HBox hBox3 =  new HBox(15,reserveTable,menuButton);
        HBox hBox4 = new HBox(15,logout);
        VBox vBox1 = new VBox(15,hBox);
        VBox vBox2= new VBox(15,hBox1);
        VBox vBox3 = new VBox(15,hBox2);
        VBox vBox4 = new VBox(15,hBox3);
        VBox vBox5 = new VBox(15,hBox4);
        VBox vBox6 = new VBox(20,vBox2,vBox3);
        VBox vbox = new VBox(50,welcome,vBox1,vBox6,vBox4,vBox5);
        flowPane.getChildren().addAll(vbox);
        numOfSeats.setPrefWidth(60);
        choiceBox.setValue("Smoking");
        menuButton.setDisable(true);
        reserveTable.setOnAction(e -> {
            if(numOfSeats.getText()!= "") {
                menuButton.setDisable(true);
            try{
                exceptionLabel.setText("");
                numberOfSeats = Integer.parseInt(numOfSeats.getText());
                int numSeats = numberOfSeats;
                if(numSeats < 0) throw new IllegalArgumentException();
                message.setText("");
                type = getChoice(choiceBox);
                tableNumber = table.ReserveTable(restaurant.getTables(), numberOfSeats, type);
                if (tableNumber > 0) {
                    findTable(tableNumber);
                    menuButton.setDisable(false);
                    tableNumberText.setText("Reserved Table Number: " + tableNumber);
                    message.setText("");
                    tableNumberText.setFont(Font.font("gill sans", FontWeight.BOLD, FontPosture.REGULAR, 20));
                } else {
                    tableNumberText.setText("");
                    message.setText("No tables available.");
                }
                message.setTextFill(Color.web("#FF0000"));
                message.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
            }catch (IllegalArgumentException e1){
                message.setText("");
                exceptionLabel.setText("Numbers and positive integers only accepted ");
                exceptionLabel.setTextFill(Color.web("#FF0000"));
                exceptionLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));
            }
            } else menuButton.setDisable(false);
        });
        menuButton.setOnAction(e -> {
            numOfSeats.setText("");
            exceptionLabel.setText("");
            message.setText("");
            tableNumberText.setText("");
            menuButton.setDisable(true);
            customerDashboard2.setCustomerOrder(restaurant.getCustomerOrder());
            customerDashboard2.setRestaurant(restaurant);
            customerDashboard2.setTable(table);
            customerDashboard2.prepareScene();
            stage.setScene(customerDashboard2.getScene());
            customerDashboard3.setTable(table);
            restaurant.getCustomerOrder().setTable(table);

        });
        logout.setOnAction(e -> {
            menuButton.setDisable(true);
            numOfSeats.setText("");
            exceptionLabel.setText("");
            message.setText("");
            tableNumberText.setText("");
            loginScene.prepareScene();
            stage.setScene(loginScene.getScene());
        });


        scene = new Scene(flowPane, 650, 600);
    }

    public Scene getScene() {

        return this.scene;
    }

    private boolean getChoice(ChoiceBox<String> choiceBox) { // Make class for it //
        boolean type1 = false;
        if (choiceBox.getValue().equals("Smoking"))
            type1 = true;
        return type1;
    }
}
