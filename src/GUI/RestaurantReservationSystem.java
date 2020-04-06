package GUI;
import Restaurant.*;
import Files.*;
import javafx.application.Application;
import javafx.stage.Stage;


public class RestaurantReservationSystem extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Restaurant restaurant = Input.Input();
        SReservations reservations = Output.Output();
        primaryStage.setTitle("Restaurant Reservation System Application");
        LoginScene loginScene = new LoginScene(primaryStage);
        CustomerDashboard1 customerDashboard1 = new CustomerDashboard1(primaryStage);
        CustomerDashboard2 customerDashboard2 = new CustomerDashboard2(primaryStage);
        CustomerDashboard3 customerDashboard3 = new CustomerDashboard3(primaryStage);
        CookDashboard cookDashboard = new CookDashboard(primaryStage);
        WaiterDashboard waiterDashboard = new WaiterDashboard(primaryStage);
        ManagerDashboard managerDashboard = new ManagerDashboard(primaryStage);
        loginScene.setUsers(restaurant.getUsers());
        customerDashboard2.setMainCourses(restaurant.getMainCourses());
        customerDashboard2.setAppetizers(restaurant.getAppetizers());
        customerDashboard2.setDeserts(restaurant.getDeserts());
        restaurant.setReservations(reservations);
        loginScene.setRestaurant(restaurant);
        loginScene.prepareScene();
        customerDashboard1.prepareScene();
        loginScene.setCustomerDashboard1(customerDashboard1);
        loginScene.setCustomerDashboard2(customerDashboard2);
        loginScene.setCustomerDashboard3(customerDashboard3);
        customerDashboard1.setCustomerDashboard2(customerDashboard2);
        customerDashboard1.setCustomerDashboard3(customerDashboard3);
        customerDashboard2.setCustomerDashboard3(customerDashboard3);
        customerDashboard3.setCookDashboard(cookDashboard);
        customerDashboard3.setManagerDashboard(managerDashboard);
        customerDashboard3.setWaiterDashboard(waiterDashboard);
        loginScene.setCookDashboard(cookDashboard);
        loginScene.setWaiterDashboard(waiterDashboard);
        loginScene.setManagerDashboard(managerDashboard);
        customerDashboard1.setLoginScene(loginScene);
        customerDashboard2.setLoginScene(loginScene);
        customerDashboard3.setLoginScene(loginScene);
        cookDashboard.setLoginScene(loginScene);
        managerDashboard.setLoginScene(loginScene);
        waiterDashboard.setLoginScene(loginScene);
        customerDashboard3.setCustomerDashboard2(customerDashboard2);
        primaryStage.setScene(loginScene.getScene());
        primaryStage.show();

    }
}



