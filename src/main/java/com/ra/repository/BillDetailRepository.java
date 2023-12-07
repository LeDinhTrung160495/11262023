package com.ra.repository;

import com.ra.model.BillDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Integer> {
    @Query("select bd from BillDetail bd inner join Bill b on bd.bill.billId = b.billId where b.billId like %?1%")
    Page<BillDetail> findBillDetailByBillId(String billId, Pageable pageable);

    @Query("select count (*) from BillDetail b where b.bill.billId like %?1%")
    int countBillDetailByBillId(String billId);

    @Query("select bd from BillDetail bd inner join Bill b on bd.bill.billId = b.billId where b.billId like %?1%")
    List<BillDetail> findBillDetailByBillId(String billId);

    @Query("select sum(b.purchasedPrice*b.quantity) from BillDetail b where b.bill.billId like ?1")
    Float sumBill(String billId);

    @Query( value = "select sum(bd.purchasedPrice*bd.quantity) from (billdetail bd inner join bill b on bd.bill_id = b.bill_id) where b.bill_status = 3 and date (b.created)=current_date",nativeQuery = true)
    float revenueInDay();
    @Query( value = "select sum(bd.purchasedPrice*bd.quantity) from (billdetail bd inner join bill b on bd.bill_id = b.bill_id) where b.bill_status = 3 and month (b.created)=month(current_date)",nativeQuery = true)
    float revenueInMonth();
    @Query( value = "select sum(bd.purchasedPrice*bd.quantity) from (billdetail bd inner join bill b on bd.bill_id = b.bill_id) where b.bill_status = 3 and year (b.created)=year(current_date)",nativeQuery = true)

    float revenueInYear();
}
