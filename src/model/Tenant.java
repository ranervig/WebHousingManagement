package model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "propertymgt.tenant")
public class Tenant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TENANT_ID")
	private int id;
	
	@Column(name = "TENANT_NAME")
	private String name;
	
	@Column(name = "RENT")
	private double rent;
	
	@Column(name = "LEASE_START")
	private LocalDate rentStart;
	
	@Column(name = "LEASE_END")
	private LocalDate rentEnd;
	
	@Column(name = "UNIT_NUMBER")
	private String unit_number;

	public Tenant() {
		super();
	}

	public Tenant(int id, String name, double rent, LocalDate rentStart, LocalDate rentEnd, String unit_number) {
		super();
		this.id = id;
		this.name = name;
		this.rent = rent;
		this.rentStart = rentStart;
		this.rentEnd = rentEnd;
		this.unit_number = unit_number;
	}
	
	public Tenant(String name, double rent, LocalDate rentStart, LocalDate rentEnd, String unit_number) {
		super();
		this.name = name;
		this.rent = rent;
		this.rentStart = rentStart;
		this.rentEnd = rentEnd;
		this.unit_number = unit_number;
	}
	
	public Tenant(String name, double rent, LocalDate rentStart, LocalDate rentEnd) {
		super();
		this.name = name;
		this.rent = rent;
		this.rentStart = rentStart;
		this.rentEnd = rentEnd;		
	}

	public Tenant(String name, double rent) {
		super();
		this.name = name;
		this.rent = rent;
	}
	
	public Tenant(String name) {
		super();
		this.name = name;	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public LocalDate getRentStart() {
		return rentStart;
	}

	public void setRentStart(LocalDate rentStart) {
		this.rentStart = rentStart;
	}

	public LocalDate getRentEnd() {
		return rentEnd;
	}

	public void setRentEnd(LocalDate rentEnd) {
		this.rentEnd = rentEnd;
	}
	
	
	public String getUnit_number() {
		return unit_number;
	}

	public void setUnit_number(String unit_number) {
		this.unit_number = unit_number;
	}

	@Override
	public String toString() {
		return "Tenant [id=" + id + ", name=" + name + ", rent=" + rent + ", rentStart=" + rentStart + ", rentEnd="
				+ rentEnd + ", unit_number=" + unit_number + "]";
	}

	

}
