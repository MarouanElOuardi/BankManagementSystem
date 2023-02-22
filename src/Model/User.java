package Model;

public class User implements IUSER {

    private String login;
    private String password;
    private String role;

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return login;
    }

    public void setUsername(String login) {
        this.login = login;
    }

    @Override
    public String getEmail() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    @Override
    public void setEmail(String email) {
    this.login = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean equals(User user) {
        if(this.login.equals(user.login) && this.password.equals(user.password) && this.role.equals(user.role)) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        return "User [login=" + login + ", password= ******** " + ", role=" + role + "]";
    }
}
