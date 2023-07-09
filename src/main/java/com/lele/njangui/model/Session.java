package com.lele.njangui.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private BigDecimal presenceMoney;

    public Session() {
    }

    public Session(Long id, LocalDate date, BigDecimal presenceMoney) {
        this.id = id;
        this.date = date;
        this.presenceMoney = presenceMoney;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getPresenceMoney() {
        return presenceMoney;
    }

    public void setPresenceMoney(BigDecimal presenceMoney) {
        this.presenceMoney = presenceMoney;
    }
}

