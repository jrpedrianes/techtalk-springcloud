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
        final StringBuilder sb = new StringBuilder("ReservationDomain{");
        sb.append("id=").append(id);
        sb.append(", reservationName='").append(reservationName).append('\'');
        sb.append('}');
        return sb.toString();
    }

}