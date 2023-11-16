package com.te.hibernate.jpql;

import java.util.logging.Level;
import java.util.logging.LogManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateEntityJpql {

	public static void main(String[] args) {
		
		LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			factory = Persistence.createEntityManagerFactory("interns");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			String update = "update EntityInfo set name = 'Paul' where id =111";

			Query query = manager.createQuery(update);

			int result = query.executeUpdate();
			System.out.println(result + "No of rows affected");

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (manager != null) {
					manager.close();
				}

				if (factory != null) {
					factory.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
