package br.dev.thinkers.employee.domain;

import br.dev.thinkers.employee.enuns.State;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address extends AbstractEntity<String> {

    @Column(name = "zip_code")
    private String zipCode;
    private String street;
    private String district;
    private String city;

    @Enumerated(EnumType.STRING)
    private State state;

    private String complement;

}
