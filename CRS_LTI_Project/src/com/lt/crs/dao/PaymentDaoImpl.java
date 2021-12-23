package com.lt.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lt.crs.bean.Payment;
import com.lt.crs.intrfc.PaymentDao;
import com.lt.crs.util.DBConnection;

/**
 * 
 * @author Shraddha
 * 
 * 
 */
public class PaymentDaoImpl implements PaymentDao {

	Connection con = null;

	public PaymentDaoImpl() {
		this.con = DBConnection.getDBConnection();
	}

	@Override
	public void makePayment(Payment payment) {
		// TODO Auto-generated method stub

		PreparedStatement stmt = null;

		try {
			String sql = "insert into payment(paymentId,studentId,totalAmount) values(?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, payment.getPaymentId());
			stmt.setString(2, payment.getStudentId());
			stmt.setInt(3, payment.getTotalAmount());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Payment> fetchPayment() {
		// TODO Auto-generated method stub

		ArrayList<Payment> payments = new ArrayList<Payment>();
		Statement statement = null;
		ResultSet rs = null;
		try {

			statement = con.createStatement();
			String s = "SELECT * FROM payment";

			rs = statement.executeQuery(s);

			while (rs.next()) {
				Payment payment = new Payment();
				payment.setPaymentId(rs.getString("paymentId"));
				payment.setStudentId(rs.getString("studentId"));
				payment.setTotalAmount(rs.getInt("totalAmount"));

				payments.add(payment);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				statement.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return payments;
	}

	@Override
	public Payment fetchPayment(Payment payment) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Payment addPayment = null;
		PreparedStatement statement = null;

		ResultSet rs = null;
		try {
			String sql = "select * from payment where paymentId =?";
			statement = con.prepareStatement(sql);
			statement.setString(1, payment.getPaymentId());
			rs = statement.executeQuery();
			if (rs.next()) {
				addPayment = new Payment();
				addPayment.setPaymentId(rs.getString(1));
				addPayment.setStudentId(rs.getString(2));
				addPayment.setTotalAmount(rs.getInt(3));
			} else
				System.out.println("Payment ID doesnt exist");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return addPayment;

	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
