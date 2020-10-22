package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Property;

public class ListPropertyHelper {
	
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebHousingManagement");

	
	public void insertItem(Property li) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Property>showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<Property> allItems = em.createQuery("SELECT i FROM Property i").getResultList();
		return	allItems;
	}
	
	public void	deleteItem(Property	toDelete){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Property> typedQuery = em.createQuery("select li from Property li where li.id = :selectedId and li.address = :selectedAddress", Property.class);
		
		//Substitute parameter with actual data from the	toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setParameter("selectedAddress",	toDelete.getAddress());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a	new	list item
		Property result	= typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	
	public Property searchForItemById(int idToEdit) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Property found = em.find(Property.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(Property toEdit) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Property> searchForItemByStore(String pid) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Property> typedQuery = em.createQuery("select li from Property li where li.id = :selectedId", Property.class);
		typedQuery.setParameter("selectedId", pid);

		List<Property> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Property> searchForItemByItem(String address) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Property> typedQuery = em.createQuery("select li from Property li where li.address = :selectedAddress", Property.class);
		typedQuery.setParameter("selectedAddress", address);
		List<Property> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp(){
		emfactory.close();
	}


}
