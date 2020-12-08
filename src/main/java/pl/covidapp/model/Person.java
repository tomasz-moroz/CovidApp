package pl.covidapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String pesel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    private Person doctor;

    @OneToMany(mappedBy = "doctor")
    private List<Person> patient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;


    public Person() {
    }

    public Person(String name, String lastName, String pesel) {
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Person getDoctor() {
        return doctor;
    }

    public void setDoctor(Person doctor) {
        this.doctor = doctor;
    }

    public List<Person> getPatient() {
        return patient;
    }

    public void setPatient(List<Person> patient) {
        this.patient = patient;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

