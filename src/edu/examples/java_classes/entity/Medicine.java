package edu.examples.java_classes.entity;

import java.util.Objects;
import java.util.UUID;

public class Medicine {
	
	private String id;
	private String nameMedicine;
	private String pharmacy;
	private String instructions;
	private Integer amount;
	private Double price;
	private String city;
	
	public Medicine() {}

	public Medicine(String nameMedicine, String pharmacy, String instructions, Integer amount, Double price, String city) {
		this.id = UUID.randomUUID().toString();
		this.nameMedicine = nameMedicine;
		this.pharmacy = pharmacy;
		this.instructions = instructions;
		this.amount = amount;
		this.price = price;
		this.city = city;
	}
	
	public Medicine(String id, String nameMedicine, String pharmacy, String instructions, Integer amount, Double price, String city) {
		this.id = id;
		this.nameMedicine = nameMedicine;
		this.pharmacy = pharmacy;
		this.instructions = instructions;
		this.amount = amount;
		this.price = price;
		this.city = city;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameMedicine() {
		return nameMedicine;
	}

	public void setNameMedicine(String nameMedicine) {
		this.nameMedicine = nameMedicine;
	}

	public String getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, city, id, instructions, nameMedicine, pharmacy, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicine other = (Medicine) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(city, other.city) && Objects.equals(id, other.id)
				&& Objects.equals(instructions, other.instructions) && Objects.equals(nameMedicine, other.nameMedicine)
				&& Objects.equals(pharmacy, other.pharmacy) && Objects.equals(price, other.price);
	}

	@Override
	public String toString() {
		return "\nMedicines [id=" + id + ", nameMedicine=" + nameMedicine + ", pharmacy=" + pharmacy + ", instructions="
				+ instructions + ", amount=" + amount + ", price=" + price + ", city=" + city + "]";
	}

}
