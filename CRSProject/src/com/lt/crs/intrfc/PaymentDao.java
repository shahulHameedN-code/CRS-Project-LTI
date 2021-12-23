package com.lt.crs.intrfc;

import java.sql.SQLException;
import java.util.List;

import com.lt.crs.bean.Payment;

public interface PaymentDao {
	
	public void closeConnection();
	
	public void  makePayment(Payment payment);
	
	public List<Payment> fetchPayment();
	
	public Payment fetchPayment(Payment payment) throws ClassNotFoundException, SQLException;

}
