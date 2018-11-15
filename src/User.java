public class User {
    private String lastName;
    private String firstName;
    final private String test;

    public User(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.test = null;
    }

    public User(String lastName, String firstName, String test) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.test = test;
    }

    public User duplicate() {
        return new User(this.getLastName(), this.getFirstName());
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
