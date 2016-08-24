package com.chicken.persistencia.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DAO {
	@Autowired
	protected SessionFactory sessionFactory;
}
