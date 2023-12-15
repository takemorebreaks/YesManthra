package com.example.YesManthra.ModelClass;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentInformation {	

	
	@Column(name="CardHolder_Name")
	private String cardHolderName;
	
	@Column(name="Card_Number")
	private String cardNumber;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="cvv")
	private String Cvv;
}
