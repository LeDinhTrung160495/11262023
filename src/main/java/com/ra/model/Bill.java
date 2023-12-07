package com.ra.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Bill")
public class Bill {
    @Id
    @Column(name = "bill_id",length = 5)
    private String billId;
    @Column(name = "created")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;
    @Column(name = "bill_status")
    private int status;
    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "account_id")
    private Account account;
    @OneToMany(mappedBy = "bill")
    private List<BillDetail> listBillDetail;

    public Bill() {
    }

    public Bill(String billId, Date created, int status, Account account, List<BillDetail> listBillDetail) {
        this.billId = billId;
        this.created = created;
        this.status = status;
        this.account = account;
        this.listBillDetail = listBillDetail;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<BillDetail> getListBillDetail() {
        return listBillDetail;
    }

    public void setListBillDetail(List<BillDetail> listBillDetail) {
        this.listBillDetail = listBillDetail;
    }
}
