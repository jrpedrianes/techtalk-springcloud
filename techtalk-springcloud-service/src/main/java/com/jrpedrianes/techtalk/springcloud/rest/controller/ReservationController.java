package com.jrpedrianes.techtalk.springcloud.rest.controller;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.jrpedrianes.techtalk.springcloud.core.domain.ReservationDomain;
import com.jrpedrianes.techtalk.springcloud.core.service.ReservationService;
import com.jrpedrianes.techtalk.springcloud.rest.assembler.ReservationAssembler;
import com.jrpedrianes.techtalk.springcloud.rest.resource.ReservationResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Transactional
@RequestMapping(value = "/reservations", produces = "application/json")
@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationAssembler reservationAssembler;

    @RequestMapping(method = GET)
    public HttpEntity<PagedResources<ReservationResource>> findAllReservations(Pageable pageable, PagedResourcesAssembler<ReservationDomain> pagedAssembler) {
        Page<ReservationDomain> page = reservationService.findAllReservations(pageable);
        PagedResources<ReservationResource> result = pagedAssembler.toResource(page, reservationAssembler);
        return ok(result);
    }

}