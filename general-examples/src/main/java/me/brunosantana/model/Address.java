package me.brunosantana.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    public String street;
    public int number;
    public String city;
    public String state;
    public String zipCode;
    public String country;

}
