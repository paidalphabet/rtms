package com.rtms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.rtms.entity.Label;
import com.rtms.model.system.BaseBusinessObject;

@Transactional
public class BaseDAO<T extends BaseBusinessObject> extends HibernateDaoSupport {

	private final static Logger LOGGER = LoggerFactory.getLogger(BaseDAO.class);
	
	/**
	 * Returns the object of the current hibernate session.
	 * 
	 * @return Hibernate Session
	 */
	protected Session getHibernateSession() {
		final Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		return session;
	}

	/**
	 * Retrieves the database object from the objectID
	 * 
	 * @param <T>
	 * @param clazz class of the type of object to retrieve from the database.
	 * @param objectID objectID
	 * @return
	 */
	public <T> T getObjectByID(final Class<T> clazz, final String objectID) {
		final Session session = getHibernateSession();
		return (T) session.load(clazz, objectID);
	}

	/**
	 * Returns the hql query
	 * 
	 * @param Session
	 * @param String hql
	 * @param boolean queryType
	 * @return
	 */
	protected Query getHQLQuery(final Session session, final String hql, final boolean isReadOnly) {
		final Query query = session.createQuery(hql);
		query.setReadOnly(isReadOnly);
		return query;
	}

	/**
	 * Save and Returns the object
	 * 
	 * @param object
	 * @return Object
	 */
	public T save(final T t) {
		final Session session = getHibernateSession();
		session.save(t);
		return t;
	}

	/**
	 * Update and Returns the object
	 * 
	 * @param object
	 * @return Object
	 */
	public T update(final T t) {
		Session session = getHibernateSession();
		session.saveOrUpdate(t);
		return t;
	}

	/**
	 * This method returns all labels from database on the basis of locale
	 * 
	 * @param locale
	 * @return List<LabelTxt>
	 */
	public List<Label> initializeApplicationLocale(final String locale) {
		final String hql = "select l from Label l where l.locale =:locale";
		final Session session = getHibernateSession();
		final Query query = getHQLQuery(session, hql, false);
		query.setCacheable(true);
		query.setString("locale", locale);
		final List<Label> l = query.list();
		return l;
	}

	/**
	 * This method returns object by ID and Class
	 * 
	 * @param class Class
	 * @param objectId Integer
	 * @return Object
	 */
	public T getObjectByID(final Class clazz,final int objectID){
		final Session session = getHibernateSession();
		try{
			return (T) session.load(clazz, objectID);
		}catch(Exception e){
			e.printStackTrace();
			LOGGER.debug("Error while getting Object from database with ID : "+objectID+" from class "+clazz.getName());
			return null;
		}
	}
	
	public void save(final T object, final boolean isSessionNew) {
		final Session session = getHibernateTemplate().getSessionFactory().openSession();
		session.beginTransaction();
		session.save(object);	
		session.getTransaction().commit();
	}

}