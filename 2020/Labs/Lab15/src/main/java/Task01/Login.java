package Task01;

public class Login {
    private String id;
    private String password;

    public Login(String id, String password) {
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Password: %s", id, password);
    }
}
