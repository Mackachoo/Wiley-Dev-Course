package com.sg.addressbook.dto;

import java.util.Objects;

public class Address {
    private String street;
    private String city;
    private String postcode;

    public Address(String street, String city, String postcode) {
        this.street = street;
        this.city = city;
        this.postcode = postcode;
    }

    public Address(String parse) {
        String[] parseSpl = parse.split("::");
        street = parseSpl[0];
        city = parseSpl[1];
        postcode = parseSpl[2];
    }

    @Override
    public String toString() {
        return street + "::" + city + "::" + postcode;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Address address = (Address) obj;
            return Objects.equals(this.street, address.street) && Objects.equals(this.city, address.city) && Objects.equals(this.postcode, address.postcode);
        } catch (Exception e) {
            return false;
        }
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }
}
