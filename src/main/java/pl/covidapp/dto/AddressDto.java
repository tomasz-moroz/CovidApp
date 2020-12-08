package pl.covidapp.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import pl.covidapp.model.Address;

import java.util.function.Function;

public class AddressDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Integer id;

    String state;

    String city;

    String zip;

    String street;

    Integer houseNumber;

    Integer apartmentNumber;

    public AddressDto() {
    }

    public AddressDto(Integer id, String state, String city, String zip, String street, Integer houseNumber, Integer apartmentNumber) {
        this.id = id;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public static Function<AddressDto, Address> dtoToAddress = new Function<AddressDto, Address>() {
        @Override
        public Address apply(AddressDto addressDto) {
            return new Address(addressDto.state, addressDto.city, addressDto.zip, addressDto.street, addressDto.houseNumber, addressDto.apartmentNumber);
        }
    };

    public static Function<Address, AddressDto> addressToDto = new Function<Address, AddressDto>() {
        @Override
        public AddressDto apply(Address address) {
            return new AddressDto(address.getId(), address.getState(),address.getCity(),
                    address.getZip(),address.getStreet(),address.getHouseNumber(),address.getApartmentNumber());
        }
    };


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
}
