package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "property")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROPERTY_ID")
	private int id;
	@Column(name = "ADDRESS")
	private String address;
	@OneToMany(mappedBy = "property")
	private List<Unit> units;
	
	public Property() {
		super();
	}

	public Property(int id, String address) {
		super();
		this.id = id;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", address=" + address + "]";
	}

}