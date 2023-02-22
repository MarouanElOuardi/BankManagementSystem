package Controller;

import Model.User;

public interface IAuth {
    public User authenticate(String login, String password);
    public boolean logout();
}
