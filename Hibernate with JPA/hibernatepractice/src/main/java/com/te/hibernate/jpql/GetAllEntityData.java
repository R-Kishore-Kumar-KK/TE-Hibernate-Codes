package com.te.hibernate.jpql;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.hibernatepractice.beans.EntityInfo;

public class GetAllEntityData {

	public void getAllD() {

		LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
		EntityManagerFactory factory = null;
		EntityManager manager = null;

		try {
			factory = Persistence.createEntityManagerFactory("interns");
			manager = factory.createEntityManager();

			String read = "from EntityInfo";
			Query query = manager.createQuery(read);

			List<EntityInfo> list = query.getResultList();
			for (EntityInfo info : list) {
				System.out.println("----------------");
				System.out.println(info.getName());
				System.out.println(info.getId());
				System.out.println(info.getGender());
				System.out.println("-----------------");
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
