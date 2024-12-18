package com.dailycodework.universalpetcare.model.payment;


import com.dailycodework.universalpetcare.model.order.tblOrder;
import com.dailycodework.universalpetcare.enums.Status;
import com.dailycodework.universalpetcare.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Transaction implements Serializable {
    @Id
    private String id;

    @Column
    private String billNo;

    @Column
    private String transNo;

    @Column
    private String bankCode;

    @Column
    private String cardType;

    @Column
    private Integer amount;

    @Column
    private String currency;

    @Column
    private String bankAccountNo;

    @Column
    private String bankAccount;

    @Column
    private String refundBankCode;

    @Lob
    @Column
    private String reason;

    @Column
    private LocalDateTime createDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private tblOrder tblOrder;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
