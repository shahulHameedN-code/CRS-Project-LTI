/**
 * 
 */
package com.lt.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lt.bean.Payment;

/**
 * @author user
 *
 */
public class PaymentRowMapper implements RowMapper<Payment> {

@Override
public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
	Payment payment = new Payment();
	payment.setPaymentId(rs.getString("paymentId"));
	payment.setStudentId(rs.getString("studentId"));
	payment.setPaymentFee(rs.getInt("totalAmount"));
	
	return payment;
	}
}

