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

public class WaiterDashboard {
    Stage stage;
    Scene scene;
    Restaurant restaurant;
    Waiter waiter;
    LoginScene loginScene;
    public void setLoginScene(LoginScene loginScene){
        this.loginScene = loginScene;
    }


   public void setRestaurant(Restaurant restaurant) {    //msh mehtageeno
        this.restaurant = restaurant;
   }
    public WaiterDashboard(Stage stage) {
        this.stage = stage;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public void prepareScene() {
        Label welcome = new Label("  Welcome Waiter  ");
        Label dashboard = new Label("Waiter Dashboard");
        dashboard.setFont(Font.font("Century Gothic Font – Safe for Web", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 30));
        dashboard.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
        Label viewReservationsLabel = new Label("Today's Reservations");
        viewReservationsLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.ITALIC, 22));
        viewReservationsLabel.setUnderline(true);
        Button logout = new Button("Logout");
        Label view = new Label(waiter.viewEmployeeDashboard(restaurant));
        view.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 13));
        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(30,20,20,20));
        flowPane.setVgap(10);
        flowPane.setHgap(10);
        flowPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, new CornerRadii(10), new BorderWidths(10))));
        HBox hBox = new HBox(15,viewReservationsLabel);
        HBox hBox1 = new HBox(20,view);
        HBox hBox2 = new HBox(15,logout);
        VBox vBox1 = new VBox(15,hBox);
        VBox vBox2= new VBox(15,hBox1);
        VBox vBox3 = new VBox(15,hBox2);
        VBox vBox4 = new VBox(17,vBox1,vBox2,vBox3);
        VBox vbox = new VBox(50,dashboard,vBox4);
        flowPane.getChildren().addAll(vbox);

        logout.setOnAction(e -> {
            loginScene.prepareScene();
            stage.setScene(loginScene.getScene());
        });

        scene = new Scene(flowPane, 600, 600);
    }

    public Scene getScene() {

        return this.scene;
    }


}
