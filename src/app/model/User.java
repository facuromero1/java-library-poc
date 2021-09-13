package app.model;


public class User {

    private int id;
    private String name;
    private String lastname;


    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return name + lastname;
    }

    public String toString() {
        return this.name + " " + this.lastname;//n
    }

    public boolean equals(Object obj) {
        if (obj instanceof User){
            User user = (User) obj;
            return user.getName().equals(this.name) && user.getLastname().equals(this.lastname);
        }
        return false;
    }

    public boolean equals(String name, String lastname) {
        return name.equals(this.name) && lastname.equals(this.lastname);
    }
}
