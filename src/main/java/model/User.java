package model;


public class User {


    private String name;
    private String lastname;
    private int id;


    public User(String name, String lastname,int id) {
        this.name = name;
        this.lastname = lastname;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setId(int id) { this.id = id;}

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFullName() {
        return name + lastname;
    }

    public int getId() {return id;}

    public String toString() {
        return this.name + " " + this.lastname;//n
    }

    public boolean equals(Object obj) {
        if (obj instanceof User){
            User user = (User) obj;
            return user.getId()==(this.id);
        }
        return false;
    }

    public boolean equals(String name, String lastname) {
        return name.equals(this.name) && lastname.equals(this.lastname);
    }
}
