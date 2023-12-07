package com.ra.service;

import com.ra.model.Bill;
import com.ra.model.Categories;

import java.util.List;

public interface BillService {
    List<Bill> displayData(String billId, int page, int size, String direction, String sortBy);

    List<Integer> getListPage(String billId, int size);

    Bill findById(String billId);

    List<Bill> getAllBill();
    boolean cancelBill(String billId);
    int statisticalCanceledBill();
    int statisticalWaitingBill();
    int statisticalApprovedBill();
    int statisticalDeliveringBill();
    int statisticalReceivedBill();
}
