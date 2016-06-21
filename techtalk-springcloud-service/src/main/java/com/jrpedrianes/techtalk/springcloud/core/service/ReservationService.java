package com.jrpedrianes.techtalk.springcloud.core.service;

import javax.persistence.EntityNotFoundException;

import com.jrpedrianes.techtalk.springcloud.core.domain.ReservationDomain;
import com.jrpedrianes.techtalk.springcloud.core.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private CounterService counterService;

    @Autowired
    private ReservationRepository reservationRepository;

    public Page<ReservationDomain> findAllReservations(Pageable pageable) {

        counterService.increment("reservations.findAll");

        return reservationRepository.findAll(pageable);
    }

    public ReservationDomain loadReservation(Long id) {
        ReservationDomain domain = reservationRepository.findOne(id);
        if (domain == null) {
            throw new EntityNotFoundException();
        }

        return domain;
    }

}
