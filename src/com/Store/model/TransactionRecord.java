package com.Store.model;

import com.Store.enumeration.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class TransactionRecord {
    private int transactionId;
    private Customer customer;
    private LocalDateTime dateOfSale;
    private TransactionStatus transactionStatus;
}
