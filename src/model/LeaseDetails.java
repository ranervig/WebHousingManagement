package model;

import java.time.LocalDate;
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
@Table(name = "propertymgt.lease")
public class LeaseDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LEASE_ID")
	private int id = 0;
	
	@Column(name="UNIT_NUMBER")
	private String unitNumber;
	
	@Column(name="LEASE_DATE")
	private LocalDate leaseDate;
	
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="UNIT_ID")
	
	private Tenant tenant;	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	
	@JoinTable
	  (
	      name="propertymgt.lease",
	      joinColumns={ @JoinColumn(name="UNIT_ID", referencedColumnName="UNIT_ID") },
	      inverseJoinColumns={ @JoinColumn(name="LEASE_ID", referencedColumnName="ID", unique=true) }
	  )
	
	private List<Property> listOfUnits;
	
	public LeaseDetails() {
		super();		
	}	
	
	public LeaseDetails(int id, String unitNumber, LocalDate leaseDate,	Tenant tenant, List<Property> listOfUnits){
		super();
		this.id = id;
		this.unitNumber = unitNumber;
		this.leaseDate = leaseDate;
		this.tenant = tenant;
		this.listOfUnits = listOfUnits;
	}
	
	public LeaseDetails(String unitNumber, LocalDate leaseDate,	Tenant tenant, List<Property> listOfUnits){
		super();
		
		this.unitNumber = unitNumber;
		this.leaseDate = leaseDate;
		this.tenant = tenant;
		this.listOfUnits = listOfUnits;
	}
	
	public LeaseDetails(String unitNumber, LocalDate leaseDate,	Tenant tenant){
		super();
		
		this.unitNumber = unitNumber;
		this.leaseDate = leaseDate;
		this.tenant = tenant;		
	}	
	
	public LeaseDetails(String unitNumber, LocalDate leaseDate){
		super();		
		this.unitNumber = unitNumber;
		this.leaseDate = leaseDate;
			
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

	public LocalDate getLeaseDate() {
		return leaseDate;
	}

	public void setLeaseDate(LocalDate leaseDate) {
		this.leaseDate = leaseDate;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public List<Property> getListOfUnits() {
		return listOfUnits;
	}

	public void setListOfUnits(List<Property> listOfUnits) {
		this.listOfUnits = listOfUnits;
	}

	@Override
	public String toString() {
		return "LeaseDetails [id=" + id + ", unitNumber=" + unitNumber + ", leaseDate=" + leaseDate + ", tenant="
				+ tenant + ", listOfUnits=" + listOfUnits + "]";
	}
	
	
	
	

}
