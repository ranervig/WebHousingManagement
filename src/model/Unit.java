package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "propertymgt.unit")
public class Unit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UNIT_ID")
	private int id;
	
	@Column(name = "UNIT_NUMBER")
	private String unitNumber;
	
	@JoinColumn(name = "PROPERTY_ID")
	private Property property;
	
	@JoinColumn(name = "TENANT_ID")
	
	private List<Tenant> tenants;

	public Unit() {
		super();
	}

	public Unit(int id, String unitNumber, Property property, List<Tenant> tenants) {
		super();
		this.id = id;
		this.unitNumber = unitNumber;
		this.property = property;
		this.tenants = tenants;
	}

	public Unit(int id, String unitNumber, Property property) {
		super();
		this.id = id;
		this.unitNumber = unitNumber;
		this.property = property;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public List<Tenant> getTenants() {
		return tenants;
	}

	public void setTenants(List<Tenant> tenants) {
		this.tenants = tenants;
	}

	@Override
	public String toString() {
		return "Unit [id=" + id + ", unitNumber=" + unitNumber + ", property=" + property + ", tenants=" + tenants
				+ "]";
	}

}
