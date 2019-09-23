package se.ecutb.mattias.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
