package com.te.hibernatepractice.beans;

import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.LogManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertEntityInfo {

	public void ints() {

		LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			factory = Persistence.createEntityManagerFactory("interns");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			EntityInfo info = new EntityInfo();
			info.setName("Vivek");
			info.setId(111);
			info.setDob(Date.valueOf("1998-04-16"));
			info.setGender("M");
			info.setRole("Tester");
			info.setMobile(7894561258l);
			info.setSalary(45000.00);
			info.setDeptId(100);
			info.setBlood_group("AB+");
			info.setEmail("vivek@gmail.com");
			info.setCommission(400);
			info.setReporting_Manager(70);
			info.setDate_of_Join(Date.valueOf("2021-06-20"));
			manager.persist(info);
			System.out.println("Inserted Successfully");
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
