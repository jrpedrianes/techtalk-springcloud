package com.jrpedrianes.techtalk.springcloud.core.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ReservationDomain {

    @Id
    @GeneratedValue
    private Long id;

    private String reservationName;

    ReservationDomain() {
    }

    public ReservationDomain(String reservationName) {
        this.reservationName = reservationName;
    }

    public Long getId() {
        return id;
    }

    public String getReservationName() {
        return reservationName;
    }

    @Override
    public String toString() {
        return String.format("ReservationDomain{ id=%s, reservationName='%s'}", id, reservationName);
    }

}