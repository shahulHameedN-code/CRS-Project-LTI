package com.lt.crs.business;

import java.util.List;

import com.lt.crs.bean.Payment;
import com.lt.crs.dao.PaymentDaoImpl;
import com.lt.crs.exception.PaymentException;


/**
 * 
 * @author Shraddha 
 * AdminBusinessOperations
 * 
 */
public class PaymentServiceImpl {
	

	public void makePayment(Payment payment) throws PaymentException {

		PaymentDaoImpl pdi = new PaymentDaoImpl();
		pdi.makePayment(payment);
		pdi.closeConnection();

	}
	
	public List<Payment> fetchPayment() {

		PaymentDaoImpl pdi = new PaymentDaoImpl();
		List<Payment> paymentList = pdi.fetchPayment();
		pdi.closeConnection();
		return paymentList;

	}
}
