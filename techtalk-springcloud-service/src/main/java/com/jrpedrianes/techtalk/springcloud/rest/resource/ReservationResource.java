package com.jrpedrianes.techtalk.springcloud.rest.resource;

import org.springframework.hateoas.ResourceSupport;

public class ReservationResource extends ResourceSupport {

    private Long identifier;
    private String reservationName;

    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

}
