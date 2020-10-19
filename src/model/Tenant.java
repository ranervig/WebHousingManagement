package model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tenant")
public class Tenant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TENANT_ID")
	private int id;
	@Column(name = "TENANT_NAME")
	private String name;
	@Column(name = "RENT")
	private BigDecimal rent;
	@Column(name = "LEASE_START")
	private LocalDate rentStart;
	@Column(name = "LEASE_END")
	private LocalDate rentEnd;
	@ManyToOne
	@JoinColumn(name = "UNIT_ID")
	private Unit unit;

	public Tenant() {
		super();
	}

	public Tenant(int id, String name, BigDecimal rent, LocalDate rentStart, LocalDate rentEnd, Unit unit) {
		super();
		this.id = id;
		this.name = name;
		this.rent = rent;
		this.rentStart = rentStart;
		this.rentEnd = rentEnd;
		this.unit = unit;
	}

	public Tenant(String name, BigDecimal rent, Unit unit) {
		super();
		this.name = name;
		this.rent = rent;
		this.unit = unit;
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

	public BigDecimal getRent() {
		return rent;
	}

	public void setRent(BigDecimal rent) {
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

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Tenant [id=" + id + ", name=" + name + ", rent=" + rent + ", rentStart=" + rentStart + ", rentEnd="
				+ rentEnd + ", unit=" + unit + "]";
	}

}
