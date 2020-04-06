package GUI;

import Restaurant.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginScene {

    private int roleNumber;
    private LoginAuthentication authentication;
    private Users users;
    private Scene scene;
    private Stage stage;
    private CustomerDashboard1 customerDashboard1;
    private CustomerDashboard2 customerDashboard2;
    private CustomerDashboard3 customerDashboard3;
    private CookDashboard cookDashboard;
    private WaiterDashboard waiterDashboard;
    private ManagerDashboard managerDashboard;
    private Restaurant restaurant;
    private Customer customer;
    private Cooker cooker;
    private Manager manager;
    private Waiter waiter;
    public LoginScene(Stage stage) {
        this.stage = stage;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setCustomerDashboard3(CustomerDashboard3 customerDashboard) {
        this.customerDashboard3 = customerDashboard;
    }

    public void setCustomerDashboard2(CustomerDashboard2 customerDashboard2) {
        this.customerDashboard2 = customerDashboard2;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public void setCustomerDashboard1(CustomerDashboard1 customerDashboard) {
        this.customerDashboard1 = customerDashboard;
    }

    public void setCookDashboard(CookDashboard cookDashboard) {
        this.cookDashboard = cookDashboard;
    }

    public void setWaiterDashboard(WaiterDashboard waiterDashboard) {
        this.waiterDashboard = waiterDashboard;
    }

    public void setManagerDashboard(ManagerDashboard managerDashboard) {
        this.managerDashboard = managerDashboard;
    }

    public void setUserRole(String username){

       for(Customer customer : restaurant.getCustomers().getCustomers()){
            if(customer.getUsername().equals(username))
                this.customer = customer;
        }
          for(Manager manager : restaurant.getManagers().getManagers()){
              if(manager.getUsername().equals(username))
                  this.manager = manager;
         }
         for(Waiter waiter : restaurant.getWaiters().getWaiters()){
             if(waiter.getUsername().equals(username))
                 this.waiter = waiter;
         }
        for(Cooker cooker : restaurant.getCookers().getCookers()){
            if(cooker.getUsername().equals(username))
                this.cooker = cooker;
        }
    }

    public void prepareScene() {
        authentication = new LoginAuthentication(users);
        Label usernameLabel = new Label("Username");
        Label empty =  new Label("           ");
        Label empty1 =  new Label("           ");
        usernameLabel.setFont(Font.font("Courier New Web Safe Font", FontWeight.MEDIUM, FontPosture.ITALIC, 16));
        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(Font.font("Courier New Web Safe Font", FontWeight.MEDIUM, FontPosture.ITALIC, 16));
        Label welcome = new Label("WELCOME TO OUR RESTAURANT");
        welcome.setFont(Font.font("Century Gothic Font – Safe for Web", FontWeight.BOLD, FontPosture.ITALIC, 30));
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button login = new Button("Login");
        Label validationLabel = new Label();
        Label empty2 = new Label("                                            ");
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(200, 100, 250,100));
        flow.setVgap(10);
        flow.setHgap(10);
        flow.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.DASHED, new CornerRadii(10), new BorderWidths(10))));
        welcome.setPrefWidth(500);
        HBox hBox = new HBox(20,empty,usernameLabel,usernameField);
        HBox hBox1 = new HBox(20,empty1,passwordLabel,passwordField);
        HBox hBox2 = new HBox(20,empty2,login);
        VBox vBox1 = new VBox(15,hBox);
        VBox vBox2= new VBox(15,hBox1);
        VBox vBox3 = new VBox(15,hBox2,validationLabel);
        VBox vbox = new VBox(20,welcome,vBox1,vBox2,vBox3);
        usernameLabel.setPrefWidth(85);
        passwordLabel.setPrefWidth(82);
        usernameField.setPrefWidth(150);
        passwordField.setPrefWidth(150);
        login.setPrefSize(70,30);
        flow.getChildren().addAll(vbox);


        login.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            boolean valid = authentication.validate(username, password);
            if (valid) {
                validationLabel.setText("");
                roleNumber = authentication.checkRole();
                setUserRole(username);
                if (roleNumber == 1) {
                    customerDashboard1.setRestaurant(restaurant);
                    customerDashboard2.setCustomer(customer);
                    customerDashboard3.setCustomer(customer);
                    stage.setScene(customerDashboard1.getScene());
                    usernameField.setText("");
                    passwordField.setText("");
                }

              if (roleNumber == 2) {
                managerDashboard.setManager(manager);
                managerDashboard.setRestaurant(restaurant);
                managerDashboard.prepareScene();
                stage.setScene(managerDashboard.getScene());
                usernameField.setText("");
                passwordField.setText("");
            }
                if (roleNumber == 3) {
                    waiterDashboard.setWaiter(waiter);
                    waiterDashboard.setRestaurant(restaurant);
                    waiterDashboard.prepareScene();
                    stage.setScene(waiterDashboard.getScene());
                    usernameField.setText("");
                    passwordField.setText("");
                }
                if (roleNumber == 4) {
                    cookDashboard.setCooker(cooker);
                    cookDashboard.setRestaurant(restaurant);
                    cookDashboard.prepareScene();
                    stage.setScene(cookDashboard.getScene());
                    usernameField.setText("");
                    passwordField.setText("");
                }
            }
            else {

                validationLabel.setText("           Wrong username or password");
                validationLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
                validationLabel.setTextFill(Color.web("#FF0000"));
            }
            });


        scene = new Scene(flow, 650, 600);

    }

    public Scene getScene() {

        return this.scene;
    }
}
