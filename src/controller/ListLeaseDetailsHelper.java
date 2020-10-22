package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.LeaseDetails;

public class ListLeaseDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebHousingManagement");
	
	public void insertItem(LeaseDetails li) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<LeaseDetails>getLists(){
		EntityManager em = emfactory.createEntityManager();
		List<LeaseDetails>	allItems = em.createQuery("SELECT i	FROM LeaseDetails i").getResultList();
		return	allItems;
	}
	
	public void	deleteItem(LeaseDetails	toDelete){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<LeaseDetails> typedQuery = em.createQuery("select li from LeaseDetails li where li.id = :selectedId and li.tenant = :selectedTenant", LeaseDetails.class);
		
		//Substitute parameter with actual data from the	toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setParameter("selectedTenant",	toDelete.getTenant());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a	new	list item
		LeaseDetails result	= typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	
	public LeaseDetails searchForItemById(int idToEdit) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		LeaseDetails found = em.find(LeaseDetails.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(LeaseDetails toEdit) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<LeaseDetails> searchForItemByStore(String pid) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<LeaseDetails> typedQuery = em.createQuery("select li from LeaseDetails li where li.id = :selectedId", LeaseDetails.class);
		typedQuery.setParameter("selectedId", pid);

		List<LeaseDetails> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<LeaseDetails> searchForItemByItem(String address) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<LeaseDetails> typedQuery = em.createQuery("select li from LeaseDetails li where li.address = :selectedAddress", LeaseDetails.class);
		typedQuery.setParameter("selectedAddress", address);
		List<LeaseDetails> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp(){
		emfactory.close();
	}


}
