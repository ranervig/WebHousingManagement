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

//@Entity
//@Table(name = "propertymgt.unit")
public class Unit {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "UNIT_ID")
	private int id;	

	//@JoinColumn(name = "TENANT_ID")	
	private List<Tenant> tenants;

	public Unit() {
		super();
	}

	public Unit(int id, List<Tenant> tenants) {
		super();
		this.id = id;	
		this.tenants = tenants;
	}

	public Unit(int id) {
		super();
		this.id = id;		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Tenant> getTenants() {
		return tenants;
	}

	public void setTenants(List<Tenant> tenants) {
		this.tenants = tenants;
	}

	@Override
	public String toString() {
		return "Unit [id=" + id + ", tenants=" + tenants + "]";
	}

}
