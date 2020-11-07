package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Property;
import model.Tenant;

public class PropertyHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebHousingManagement");

	// Method to add new Property
	public void insertProperty(Property li) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	// display all Property
	public List<Property>displayAllProperty(){
		EntityManager em = emfactory.createEntityManager();
		List<Property> allPropertys = em.createQuery("SELECT i FROM Property i").getResultList();
		return	allPropertys;
	}
	
	public Tenant findTenant(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Tenant> typedQuery = em.createQuery("select sh from Tenant sh where sh.name = :selectedName", Tenant.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		Tenant foundTenant;
		try {
			foundTenant = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundTenant = new Tenant(nameToLookUp);
		}
		em.close();

		return foundTenant;
	}
	
	// method to delete Property
	public void	deleteProperty(Property toDelete){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Property> typedQuery = em.createQuery("select li from Property li where li.name = :selectedName and li.address = :selectedAddress", Property.class);
				
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedAddress", toDelete.getAddress());
				
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a	new	list item
		Property result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	
	// Method to search by Property id
	public Property searchForPropertyById(int idToEdit) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Property found = em.find(Property.class, idToEdit);
		em.close();
		return found;
	}

	// method to update exiting Property details
	public void updatePropertys(Property toEdit) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	// method to search Property by author
	public List<Property> searchForPropertysByName(String pName) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Property> typedQuery = em.createQuery("select li from Property li where li.name = :selectedName", Property.class);
		typedQuery.setParameter("selectedName", pName);

		List<Property> foundPropertys = typedQuery.getResultList();
		em.close();
		return foundPropertys;
	}

	// method to search Property by title
	public List<Property> searchForPropertyByAddress(String pAddress) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Property> typedQuery = em.createQuery("select li from Property li where li.address = :selectedAddress", Property.class);
		typedQuery.setParameter("selectedAddress", pAddress);
		List<Property> foundPropertys = typedQuery.getResultList();
		em.close();
		return foundPropertys;
	}
	
	public void cleanUp(){
		emfactory.close();
	}


}
