package com.ra.service;

import com.ra.model.BillDetail;

import java.util.List;

public interface BillDetailService {
    List<BillDetail> displayData(String billId, int page, int size, String direction, String sortBy);
    List<Integer>getListPage(String billId, int size);
    List<BillDetail> findAll();
    List<BillDetail>findBillDetailByBillId(String billId);
    BillDetail findBillDetailByBillDetailId(int billDetailId);
    boolean save0rUpdate(BillDetail billDetail);
    boolean delete(int billDetailId);
    boolean billDetailHaveProductId(String productId);
    float revenueInDay();
    Float sumBill(String billId);
    float revenueInMonth();
    float revenueInYear();
}
