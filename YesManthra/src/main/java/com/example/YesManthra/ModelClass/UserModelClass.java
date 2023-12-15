package com.example.YesManthra.ModelClass;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class UserModelClass {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String firstName;
private String lastName;
private String password;
private String email;
private String phoneNumber;
private String role;
//CascadeType.ALL parameter indicates that any operation performed on the User entity (such as persisting, merging, removing) 
//will be cascaded to its associated Address entities.
@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
private List<Address>address=new ArrayList<>();
@Embedded
@ElementCollection
@CollectionTable(name="payment_information",joinColumns=@JoinColumn(name="user_id"))
private List<PaymentInformation>Payment=new ArrayList<>();
@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
@JsonIgnore
private List<Rating>ratings=new ArrayList<>();
@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
@JsonIgnore
private List<Review>rivews=new ArrayList<>();
private LocalDateTime createAt;

}
