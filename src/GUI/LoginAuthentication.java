package GUI;

import Restaurant.User;
import Restaurant.Users;

public class LoginAuthentication {
    private boolean validation;
    private Users users;
    private String userRole;

    public LoginAuthentication(Users users) {

        this.users = users;
    }

    public boolean validate(String Username, String Password) {
        validation = false;
        for (User user : users.getUsers()) {
            if (user.getUsername().equals(Username) && user.getPassword().equals(Password)) {
                validation = true;
                this.userRole = user.getRole();
                break;
            }
        }
        return validation;
    }

    public int checkRole() {
        int roleNumber = 0;
        if (validation) {
            if (this.userRole.equals("Client")) roleNumber = 1;
            else if (this.userRole.equals("Manager")) roleNumber = 2;
            else if (this.userRole.equals("Waiter")) roleNumber = 3;
            else if (this.userRole.equals("Cooker")) roleNumber = 4;
        }
        return roleNumber;
    }
}
