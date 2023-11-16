package com.te.hibernatepractice.beans;

import java.util.logging.Level;
import java.util.logging.LogManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetIntityInfo {

	public void getEnt() {
		LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
		EntityManagerFactory factory = null;
		EntityManager manager = null;

		try {
			factory = Persistence.createEntityManagerFactory("interns");
			manager = factory.createEntityManager();

			//EntityInfo info = manager.find(EntityInfo.class, 110);
			EntityInfo info = manager.getReference(EntityInfo.class, 110);
			if (info != null) {
				System.out.println("Name: " + info.getName());
				System.out.println("Id: " + info.getId());
				System.out.println("Date of Birth: " + info.getDob());
				System.out.println("Gender: " + info.getGender());
				System.out.println("Role: " + info.getRole());
			}
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
