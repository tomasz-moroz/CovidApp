package pl.covidapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.covidapp.model.Person;

import java.util.List;
import java.util.function.Function;

public class PersonDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    private String name;

    private String lastName;

    private String pesel;

    private AddressDto address;

    private PersonDto doctor;

    private List<PersonDto> patients;

    public PersonDto(Integer id, String name, String lastName, String pesel) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public PersonDto(String name, String lastName, String pesel) {
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public PersonDto() {
    }

    public static Function<PersonDto, Person> dtoToPerson = new Function<PersonDto, Person>() {
        @Override
        public Person apply(PersonDto personDto) {
            return new Person(personDto.getName(), personDto.getLastName(), personDto.getPesel());
        }
    };

    public static Function<Person, PersonDto> personToDto = new Function<Person, PersonDto>() {
        @Override
        public PersonDto apply(Person person) {
            return new PersonDto(person.getId(), person.getName(), person.getLastName(), person.getPesel());
        }
    };

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

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public PersonDto getDoctor() {
        return doctor;
    }

    public void setDoctor(PersonDto doctor) {
        this.doctor = doctor;
    }

    public List<PersonDto> getPatients() {
        return patients;
    }

    public void setPatients(List<PersonDto> patients) {
        this.patients = patients;
    }
}
