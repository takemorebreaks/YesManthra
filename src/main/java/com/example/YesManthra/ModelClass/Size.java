package com.example.YesManthra.ModelClass;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Size {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
private String name;
private int quantity;

}
