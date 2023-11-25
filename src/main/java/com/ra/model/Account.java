package com.ra.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;
    @Column(name = "userName",length = 100)
    private String userName;
    @Column(name = "password",length = 30)
    private String password;
    @Column(name = "created")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;
    @Column(name = "permission")
    private boolean permission;
    @Column(name = "account_status")
    private boolean accountStatus;
//    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
//    private List<Bill> listBill;

    public Account() {
    }

    public Account(int accountId, String userName, String password, Date created, boolean permission, boolean accountStatus) {
        this.accountId = accountId;
        this.userName = userName;
        this.password = password;
        this.created = created;
        this.permission = permission;
        this.accountStatus = accountStatus;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }
}
