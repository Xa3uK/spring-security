package org.fishbone.springsecurity.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    @NotEmpty
    @Size(min = 2, max = 100, message = "Name length must be between 2 and 100, ok?")
    private String userName;

    @Column(name = "year_of_birth")
    @Min(value = 1900, message = "Minimum 1900 year ded must be :)")
    private int yearOfBirh;

    @Column(name = "password")
    private String password;
}
