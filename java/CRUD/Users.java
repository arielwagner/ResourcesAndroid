public class Users {

    private int Id;
    private String username;
    private String telephone;
    private String email;

    public Users() { super(); }

    public Users(int _id, String _username, String _telephone, String _email) {
        super();
        this.Id = _id;
        this.username = _username;
        this.telephone = _telephone;
        this.email = _email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
