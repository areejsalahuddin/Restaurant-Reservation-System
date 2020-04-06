package GUI;

import Restaurant.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CustomerDashboard2 {

    private Stage stage;
    private Scene scene;
    private LoginScene loginScene;
    private Customer customer;
    private Table table;
    private Restaurant restaurant;
    private MainCourses mainCourses;
    private Appetizers appetizers;
    private Deserts deserts;
    private CustomerDashboard3 customerDashboard3;
    private CustomerOrder customerOrder = new CustomerOrder();

    public CustomerDashboard2(Stage stage) {
        this.stage = stage;
    }

    public void setTable(Table table) {
        this.table = table;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setMainCourses(MainCourses mainCourses) {
        this.mainCourses = mainCourses;
    }

    public void setAppetizers(Appetizers appetizers) {
        this.appetizers = appetizers;
    }

    public void setDeserts(Deserts deserts) {
        this.deserts = deserts;
    }

    public void setCustomerDashboard3(CustomerDashboard3 customerBoard3) {
        this.customerDashboard3 = customerBoard3;
    }

    public void setLoginScene(LoginScene loginScene) {
        this.loginScene = loginScene;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public void prepareScene() {  // create another function dishesBuilder
        customerOrder = new CustomerOrder();
        Label orderLabel = new Label("Place your order");
        orderLabel.setPrefWidth(450);
        orderLabel.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 30));
        Label printing = new Label();
        printing.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        Label chosenItems =  new Label("Your chosen items:");
        chosenItems.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.ITALIC, 22));
        chosenItems.setUnderline(true);
        Button checkout = new Button("Checkout");
        Label main_courses =  new Label("Main Courses:");
        main_courses.setFont(Font.font("Courier New Web Safe Font", FontWeight.MEDIUM, FontPosture.ITALIC, 17));
        Label appetizers_ =  new Label("     Appetizers:");
        appetizers_.setFont(Font.font("Courier New Web Safe Font", FontWeight.MEDIUM, FontPosture.ITALIC, 17));
        Label deserts_ = new Label("         Desserts");
        deserts_.setFont(Font.font("Courier New Web Safe Font", FontWeight.MEDIUM, FontPosture.ITALIC, 17));
        ComboBox<String> comboBox = new ComboBox<>();
        ComboBox<String> comboBox1 = new ComboBox<>();
        ComboBox<String> comboBox2  = new ComboBox<>();
        comboBox.setPromptText("Choose");
        comboBox1.setPromptText("Choose");
        comboBox2.setPromptText("Choose");
        StringBuilder stringBuilder = new StringBuilder();
        Button logout = new Button("Log out");
        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(30,20,20,20));
        flowPane.setVgap(10);
        flowPane.setHgap(10);
        flowPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, new CornerRadii(10), new BorderWidths(10))));
        HBox hBox = new HBox(15,main_courses,comboBox);
        HBox hBox1 = new HBox(20,appetizers_,comboBox1);
        HBox hBox2 = new HBox(15,deserts_,comboBox2);
        HBox hBox4 = new HBox(15,checkout);
        HBox hBox5 = new HBox(15,logout);
        VBox vBox5 = new VBox(15,hBox4,hBox5);
        HBox hBox3 =  new HBox(200,printing,vBox5);
        VBox vBox1 = new VBox(15,hBox);
        VBox vBox2= new VBox(15,hBox1);
        VBox vBox3 = new VBox(15,hBox2);
        VBox vBox4 = new VBox(15,chosenItems,hBox3);
        VBox vBox6 = new VBox(20,vBox1,vBox2,vBox3);
        VBox vbox = new VBox(50,orderLabel,vBox6,vBox4);
        flowPane.getChildren().addAll(vbox);
        checkout.setDisable(true);
        for (MainCourse mainCourse : mainCourses.getMainCourses())
        {
            comboBox.getItems().add(mainCourse.getDishName() + " " + "(" + mainCourse.getDishPrice() + " EGP)");
        }
        comboBox.setOnAction(e -> {
            for (MainCourse mainCourse : mainCourses.getMainCourses()) {
                if (comboBox.getValue().equals(mainCourse.getDishName() + " " + "(" + mainCourse.getDishPrice() + " EGP)")) {
                    customerOrder.addDish(mainCourse);
                    stringBuilder.append("■ "+mainCourse.getDishName()).append(" ").append("(").append(mainCourse.getDishPrice()).append(" EGP)\n");
                    printing.setText(stringBuilder.toString());
                }
            }
            checkout.setDisable(false);
        });
        for (Appetizer appetizer : appetizers.getAppetizers())
        {

            comboBox1.getItems().add(appetizer.getDishName() + " " + "(" + appetizer.getDishPrice() + " EGP)");
        }
        comboBox1.setOnAction(e -> {
            for (Appetizer appetizer : appetizers.getAppetizers()) {
                if (comboBox1.getValue().equals(appetizer.getDishName() + " " + "(" + appetizer.getDishPrice() + " EGP)")) {
                    customerOrder.addDish(appetizer);
                    stringBuilder.append("■ "+appetizer.getDishName()).append(" ").append("(").append(appetizer.getDishPrice()).append(" EGP)\n");
                    printing.setText(stringBuilder.toString());
                }
            }
            checkout.setDisable(false);
        });

        for (Desert desert : deserts.getDeserts())
        {
            comboBox2.getItems().add(desert.getDishName() + " " + "(" + desert.getDishPrice() + " EGP)");
        }
        comboBox2.setOnAction(e -> {
            for (Desert desert : deserts.getDeserts()) {
                if (comboBox2.getValue().equals(desert.getDishName() + " " + "(" + desert.getDishPrice() + " EGP)")) {
                    customerOrder.addDish(desert);
                    stringBuilder.append("■ "+desert.getDishName()).append(" ").append("(").append(desert.getDishPrice()).append(" EGP)\n");
                    printing.setText(stringBuilder.toString());
                }
            }
            checkout.setDisable(false);
        });


        logout.setOnAction(e -> {
            printing.setText("");
            comboBox.setPromptText("Choose");
            comboBox1.setPromptText("Choose");
            comboBox2.setPromptText("Choose");
            loginScene.prepareScene();
            stage.setScene(loginScene.getScene());
        });
        checkout.setOnAction(e -> {
            printing.setText("");
            comboBox.setPromptText("Choose");
            comboBox1.setPromptText("Choose");
            comboBox2.setPromptText("Choose");
            restaurant.getReservations().addReservation(new SReservation(customerOrder));
            customerDashboard3.setOrder(customerOrder);
            customerDashboard3.setRestaurant(restaurant);
            customerDashboard3.prepareScene();
            stage.setScene(customerDashboard3.getScene());
        });

        scene = new Scene(flowPane, 650, 600);
    }

    public Scene getScene() {

        return this.scene;
    }


}
