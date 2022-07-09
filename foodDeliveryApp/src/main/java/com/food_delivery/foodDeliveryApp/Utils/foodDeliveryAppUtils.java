package com.food_delivery.foodDeliveryApp.Utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class foodDeliveryAppUtils {
	private static SqlSessionFactory sqlSessionFactory;

	static {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("resources/config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
