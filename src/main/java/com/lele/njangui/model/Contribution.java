package com.lele.njangui.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "contributions")
public class Contribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contributor_user_id")
    private User contributor;

    @ManyToOne
    @JoinColumn(name = "recipient_user_id")
    private User recipient;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    private BigDecimal amount;

    private LocalDate contributionDate;

    // Getters and Setters
}

