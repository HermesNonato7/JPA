package com.minhaempresa.application.services;

import com.minhaempresa.infrastructure.models.Customer;
import com.minhaempresa.infrastructure.utils.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

/*
    Esta classe representa os serviços disponíveis para o cadastro do cliente.
 */
public class CustomerService {
    EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Customer customerRegistration(Customer customer) {
        entityManager.getTransaction().begin(); // Abre a transação JPA
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        return customer;
    }

    public Customer findById(String id) {
        return entityManager.find(Customer.class, id);
    }

    public List<Customer> findAll() {
        Query query = entityManager.createQuery("from Customer"); // Classe Customer
        return query.getResultList(); // Retorna ums lista de 'Customer'
    }

    
    //Não precisa existir esse método, já que o método customerregistration é igual ao método update
    public Customer update(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        return customer;
    }

    public void deleteById(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.remove(customer);
        entityManager.getTransaction().commit();
    }

    public void closeEntityManager() {
        entityManager.close();
    }
}

