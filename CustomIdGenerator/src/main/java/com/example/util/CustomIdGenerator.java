package com.example.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		String prefix = "CT";
		String suffix = "";
		Connection conn = session.connection();
		try {

			String sql = "select emp_id from employees ORDER BY emp_id DESC LIMIT 1";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				String id = rs.getString(1).split("")[2];
				System.out.println("id.."+id);
				long empId = Integer.parseInt(id)+1;
				suffix = empId + "";
			}else {
				suffix = 1+"";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// suffix = employeeService.countByEmployeeId() + "";

		return prefix + suffix;
	}

}
