package Model;

public class Admin extends User {
    private static Admin admin = null;

    private Admin(String email, String password, String role) {
        super(email, password, role);
    }

    public static Admin getAdmin() {
        if (admin == null) {
            admin = new Admin("cj@admin.com", "Admin123", "Admin");
        }
        return admin;
    }
}