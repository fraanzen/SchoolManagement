package se.ecutb.mattias.model;

/**
 * Hashcode, equals och to string behövs.
 */


public class Student{

    private static int idCounter;
    private int id;
    private String name;
    private String email;
    private String address;

    public Student(int id, String name, String email, String adress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = adress;
    }

    public Student(String name, String email, String address){
        this(++idCounter, name, email, address);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
