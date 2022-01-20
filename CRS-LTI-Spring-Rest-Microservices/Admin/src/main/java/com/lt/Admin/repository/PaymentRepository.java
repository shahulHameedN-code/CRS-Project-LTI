package com.lt.Admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lt.Admin.beans.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

	@Query(value = "select * from payment where student_id=:studentId", nativeQuery = true)
	List<PaymentResponse> findByStudent_Id(@Param("studentId") String studentId);

	public interface PaymentResponse {
		String getPayment_Id();

		String getPayment_Fee();
	}

}
