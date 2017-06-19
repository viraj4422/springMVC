package springMVC.api.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springMVC.api.entity.User;
import springMVC.api.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		System.out.println("UserRepositoryImpl + findAll");
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly=true)
	public User findOne(String userId) {
		System.out.println("in findOne UserRepositoryImpl");
		return em.find(User.class, userId);
	}

	@Override
	@Transactional
	public User create(User user) {
		em.persist(user);
		return user;
	}

	@Override
	@Transactional
	public void delete(User user) {
		em.remove(user);
	}

	@Override
	@Transactional
	public User update(User user) {

		return em.merge(user);
	}

	@Override
	public User findByEmail(String emailId) {
		System.out.println("in fin by email use repo");
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", emailId);
		List<User> users = query.getResultList();
		if (users.isEmpty()) {
			return null;
		} else {
			return users.get(0);
		}
	}

}
