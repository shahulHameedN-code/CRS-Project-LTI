package com.lt.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;

import com.lt.bean.Payment;
/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital
 * 
 * it is the implementation class of payment interface
 * 
 * Here we are implement the make payment method
 */
@Configuration
public class MakePaymentImpl implements PaymentIntrfc {

/*  Here we are using the @Configration annotation
 *  
 *  And we are implement the make payment method
*/
	
	/**
     * This is makePayment method
     * @param studentId
     * @param courseId
     * @param paymentFee
     * @param cardNumber
     * @param pin
     * @param cvvNumber
     * @exception SQLException
     * @return getPaymentFee
     */
	@Override
	public String makePayment(String makePaymentJson) {

		List<Payment> payments = new ArrayList<Payment>();

		JSONObject jso = new JSONObject(makePaymentJson);
		Payment payment = new Payment();

		payment.setStudentId(jso.getString("studentId"));
		payment.setCourseId(jso.getString("courseId"));
		payment.setPaymentFee(jso.getInt("paymentFee"));
		payment.setCardNumber(jso.getInt("cardNumber"));
		payment.setCvvNumber(jso.getInt("cvvNumber"));
		payment.setPin(jso.getInt("pin"));

		payments.add(payment);
		return "Payemnt of Rs" + payment.getPaymentFee() + " was made succefully for course" + payment.getCourseId();

	}

}
