package com.dailycodework.universalpetcare.model.order;

import com.dailycodework.universalpetcare.enums.Status;
import com.dailycodework.universalpetcare.model.payment.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table
@AllArgsConstructor
@NamedEntityGraph
public class tblOrder implements Serializable {
    @Id
    private String id;

    @Column(nullable = false, length = 50)
    private String fullName;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false)
    private String address;

    @Lob
    @Column
    private String reason;

    @Column(nullable = false, length = 50)
    private String paymentMethod;

    @Column
    private Boolean isPaid = false;

    @Column
    private String receiptIMG;

    @Column
    private Boolean isRefund;

    @Enumerated(EnumType.STRING)
    private Status progressStatus;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime approveDate;

    @Column
    private LocalDateTime packageDate;

    @Column
    private LocalDateTime deliveryDate;

    @Column
    private LocalDateTime receivedDate;

    @Column
    private LocalDateTime rejectDate;

    @Column
    private String latLong;

    @Column
    private Double distance = 0.0;

    @Column
    private Double totalShipCost = 0.0;

    @Column
    private Double total = 0.0;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tblOrder")
    private List<Transaction> transactionList;
}
