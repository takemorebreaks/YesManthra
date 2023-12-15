package com.example.YesManthra.ModelClass;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Column(name="first_name")
private String firstName;

@Column(name="last_name")
private String lastName;

@Column(name="street_name")
private String StreetName;

@Column(name="city")
private String city;

@Column(name="state")
private String State;

@ManyToOne
@JoinColumn(name="user_id")
@JsonIgnore
private UserModelClass user;


private String Mobile;



}
