package org.example.Shop;

import org.example.Goods.Good;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Receipt {
    private long id;
    private Cashier cashier;
    private Date receiptDateCreation;
    private List<Good> goods;
    private BigDecimal totalPrice;
    private int countReceipts;
}
