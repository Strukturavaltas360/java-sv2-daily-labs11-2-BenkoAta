package day01;

public class AdminUser extends NormalUser {
    public AdminUser(String email, String password) {
        super(email, password);
    }

    @Override
    public String getPassword() {
        return "*".repeat(super.getPassword().length());
    }
}
