package com.ra.serviceImp;

import com.ra.model.Bill;
import com.ra.model.Categories;
import com.ra.repository.BillRepository;
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
public class BillServiceImp implements BillService {
    @Autowired
    private BillRepository billRepository;

    @Override
    public List<Bill> displayData(String billId, int page, int size, String direction, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, direction.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        List<Bill> listBill = billRepository.findBillByBillId(billId, pageable).getContent();
        return listBill;
    }

    @Override
    public List<Integer> getListPage(String billId, int size) {
        int countBill = billRepository.countByBillIdContains(billId);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < (int) Math.ceil((double) countBill / (double) size); i++) {
            listPage.add(i + 1);
        }
        return listPage;
    }

    @Override
    public Bill findById(String billId) {
        return null;
    }


    @Override
    public List<Bill> getAllBill() {
        return billRepository.findAll();
    }

    @Override
    public boolean cancelBill(String billId) {
        //1. Lấy ra bill cần hủy từ billId Truyền vào
        List<Bill> cancelBill = billRepository.waitingBill();
        for (int i = 0; i < cancelBill.size(); i++) {
            if(cancelBill.get(i).getBillId().equals(billId)){
                cancelBill.get(i).setStatus(5);
                billRepository.save(cancelBill.get(i));
                return true;
            }
        }
        return false;
    }

    @Override
    public int statisticalCanceledBill() {
        return billRepository.canceledBill().size();
    }

    @Override
    public int statisticalWaitingBill() {
        return billRepository.waitingBill().size();
    }

    @Override
    public int statisticalApprovedBill() {
        return billRepository.approvedBill().size();
    }

    @Override
    public int statisticalDeliveringBill() {
        return billRepository.deliveringBill().size();
    }

    @Override
    public int statisticalReceivedBill() {
        return billRepository.receivedBill().size();
    }
}
