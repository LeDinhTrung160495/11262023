package com.ra.repository;

import com.ra.model.Bill;
import com.ra.model.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, String> {
    @Query("select b from Bill b where b.billId like %?1%")
    Page<Bill> findBillByBillId(String billId, Pageable pageable);

    int countByBillIdContains(String billId);

    @Query("select b from Bill b where b.status =1")
    List<Bill> waitingBill();

    @Query("select b from Bill b where b.status =2")
    List<Bill> approvedBill();

    @Query("select b from Bill b where b.status =3")
    List<Bill> deliveringBill();

    @Query("select b from Bill b where b.status =4")
    List<Bill> receivedBill();
    @Query("select b from Bill b where b.status =5")
    List<Bill> canceledBill();
}
