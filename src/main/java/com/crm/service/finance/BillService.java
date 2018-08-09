package com.crm.service.finance;

import com.crm.entity.Bill;

public interface BillService {
    Bill findBill(Long id);
    int insertBill(Bill bill);
    int updateBill(Bill bill);
    int deleteBill(Long id);
}

