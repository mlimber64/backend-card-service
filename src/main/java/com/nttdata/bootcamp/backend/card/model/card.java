package com.nttdata.bootcamp.backend.card.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cards")
public class card {
	
	@Id
	private String id;
	@Field
	private int idType;
	@Field
	private int idAccount;
	@Field
	private int idCustomer;
	@Field
	private Number number;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dueDate = LocalDateTime.now();
	@Field
	private double balance;
	@Field
	private Boolean active;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getIdType() {
		return idType;
	}
	public void setIdType(int idType) {
		this.idType = idType;
	}
	public int getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public Number getNumber() {
		return number;
	}
	public void setNumber(Number number) {
		this.number = number;
	}
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	

	

}
