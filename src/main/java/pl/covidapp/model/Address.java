package pl.covidapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Address {

    @Id
    @GeneratedValue
    Integer id;

    @Column
    String state;

    @Column
    String city;

    @Column
    String zip;

    @Column
    String street;

    @Column
    Integer houseNumber;

    @Column
    Integer apartmentNumber;

    @OneToMany(mappedBy = "address")
    private List<Person> person;

    public Address() {
    }

    public Address(String state, String city, String zip, String street, Integer houseNumber, Integer apartmentNumber) {
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public Address(Integer id, String state, String city, String zip, String street, Integer houseNumber, Integer apartmentNumber, List<Person> person) {
        this.id = id;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(Integer apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }
}
