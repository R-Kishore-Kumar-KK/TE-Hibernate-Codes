package com.te.hibernatepractice.beans;

import java.util.logging.Level;
import java.util.logging.LogManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteEntityInfo {

	public void del() {

		LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			factory = Persistence.createEntityManagerFactory("interns");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			EntityInfo info = manager.find(EntityInfo.class, 110);
			manager.remove(info);
			System.out.println("Deleted Successfull");
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
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
