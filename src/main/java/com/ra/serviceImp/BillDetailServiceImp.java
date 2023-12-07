package com.ra.serviceImp;

import com.ra.model.Bill;
import com.ra.model.BillDetail;
import com.ra.repository.BillDetailRepository;
import com.ra.repository.BillRepository;
import com.ra.repository.ProductRepository;
import com.ra.service.BillDetailService;
import com.ra.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillDetailServiceImp implements BillDetailService {
    @Autowired
    private BillDetailRepository billDetailRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<BillDetail> displayData(String billId, int page, int size, String direction, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, direction.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        List<BillDetail> billDetailList = billDetailRepository.findBillDetailByBillId(billId, pageable).getContent();
        return billDetailList;
    }

    @Override
    public List<Integer> getListPage(String billId, int size) {
        int countBillDetail = billDetailRepository.countBillDetailByBillId(billId);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < (int) Math.ceil((double) countBillDetail / (double) size); i++) {
            listPage.add(i + 1);
        }
        return listPage;
    }

    @Override
    public List<BillDetail> findAll() {
        return billDetailRepository.findAll();
    }

    @Override
    public List<BillDetail> findBillDetailByBillId(String billId) {
        return billDetailRepository.findBillDetailByBillId(billId);
    }

    @Override
    public BillDetail findBillDetailByBillDetailId(int billDetailId) {
        return billDetailRepository.findById(billDetailId).get();
    }

    @Override
    public boolean save0rUpdate(BillDetail billDetail) {
        try {
            billDetailRepository.save(billDetail);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int billDetailId) {
        try {
            billDetailRepository.delete(findBillDetailByBillDetailId(billDetailId));
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean billDetailHaveProductId(String productId) {
        List<BillDetail> billDetailList=billDetailRepository.findAll().stream().filter(billDetail -> billDetail.getProduct().getProductId().equals(productId)).collect(Collectors.toList());
        return billDetailList.size()>0;
    }

    @Override
    public float revenueInDay() {
        return billDetailRepository.revenueInDay()*1000;
    }

    @Override
    public Float sumBill(String billId) {
        return billDetailRepository.sumBill(billId);
    }

    @Override
    public float revenueInMonth() {
        return billDetailRepository.revenueInMonth()*1000;
    }

    @Override
    public float revenueInYear() {
        return billDetailRepository.revenueInYear()*1000;
    }
}
