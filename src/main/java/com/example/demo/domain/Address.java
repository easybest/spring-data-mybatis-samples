package com.example.demo.domain;

import javax.persistence.Embeddable;

import lombok.Data;

/**
 * .
 *
 * @author Jarvis Song
 */
@Embeddable
@Data
public class Address {


    private String country;

    private String city;

    private String streetName;

    private String streetNo;

}
