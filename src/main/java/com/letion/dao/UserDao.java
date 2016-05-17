package com.letion.dao;

import java.util.List;

import com.letion.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import com.letion.models.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements BaseDao<User> {

	Session session = HibernateUtil.getSessionFactory().openSession();


	@Override
	public List<User> loadAll() {
		return session.createQuery("FROM User").list();
	}

	@Override
	public User findById(int id) {
		Query q = session.createQuery("FROM User where id=:id");
		q.setParameter("id",id);
		List<User> city =  q.list();
		return city.get(0);
	}

	@Override
	public User findByLogin(String login) {
		System.out.println("login(Dao) = " + login);

		Query q = session.createQuery("FROM User u where u.userName=:login");
		q.setParameter("login",login);
		List<User> user =  q.list();
		return user.get(0);
	}

	@Override
	public User create(User item) {
		this.session.persist(item);
		return item;
	}

	@Override
	public User update(User id) {
//		Hotel merged = this.session.merge(item);
		this.session.flush();

		return null;
//		return merged;
	}

	@Override
	public boolean delete(User item) {
//		if (this.session.contains(item)) {
//			this.session.delete(item);
//			return true;
//		} else {
//			User attached = findById();
//			if (attached == null) {
//				return false;
//			}
//			this.session.delete(attached);
//			return true;
//		}
		return false;
	}

	public void flush() {
		this.session.flush();
	}
}
