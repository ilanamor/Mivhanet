public abstract class User
{
    public String userName;
    public String lastName;
    public String firstName;
    public String ID;
    public String address;
    public String phoneNumber;
    public String Email;
    private String password;

    public User(String userName, String lastName, String firstName, String ID, String address, String phoneNumber, String email, String password) {
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.ID = ID;
        this.address = address;
        this.phoneNumber = phoneNumber;
        Email = email;
        this.password = password;
    }
}
