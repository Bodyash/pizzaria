package com.bodyash.pizzaria.dao;

import java.io.Serializable;
 
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
public abstract class AbstractDao<PK extends Serializable, T> {
     
    private final Class<T> persistentClass;
    
    @PersistenceContext
    EntityManager entityManager;
     
    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
     
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }
 
    public void persist(T entity) {
        getSession().persist(entity);
    }
 
    public void delete(T entity) {
        getSession().delete(entity);
    }
    
    protected void update(T entity) {
    	if (entity == null){
    		System.out.println("Entity is null");
    	}
    	getSession().merge(entity);
    }

    @SuppressWarnings("deprecation")
	protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
    
    protected EntityManager getEntityManager(){
        return this.entityManager;
    }
 
}
