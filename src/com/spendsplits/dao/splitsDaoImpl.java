package com.spendsplits.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spendsplits.model.splits;

/**
 * @author saba
 *
 */
@Repository
public class splitsDaoImpl implements splitsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<splits> listnames() {
		return (List<splits>) sessionFactory.getCurrentSession().createCriteria(splits.class).list();
	}

	public void splited(String submittedVal, String amt) {
		String[] s = submittedVal.split(",");
		Session session = sessionFactory.getCurrentSession();
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);

			Query selectQuery = session.createQuery("from splits where name = :name");
			selectQuery.setParameter("name", s[i]);
			List<splits> sp = selectQuery.list();
			Float previousAmount = 0f;
			Float newAmount = 0f;
			try {
				if (sp.size() > 0) {
					previousAmount = Float.parseFloat(sp.get(0).getAmount());
					System.out.println("previous amount value is " + previousAmount);
				}
				newAmount = Float.parseFloat(amt);
				System.out.println("new amount value is " + newAmount);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			newAmount = newAmount + previousAmount;
			Query query = session.createQuery("update splits set amount = :amount" + " where name = :name");
			query.setParameter("amount", newAmount.toString());
			query.setParameter("name", s[i]);
			int result = query.executeUpdate();

		}
		session.close();
	}

}
