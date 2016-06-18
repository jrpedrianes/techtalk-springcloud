package com.jrpedrianes.techtalk.springcloud.rest.assembler;

import com.jrpedrianes.techtalk.springcloud.core.domain.ReservationDomain;
import com.jrpedrianes.techtalk.springcloud.rest.controller.ReservationController;
import com.jrpedrianes.techtalk.springcloud.rest.resource.ReservationResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ReservationAssembler extends ResourceAssemblerSupport<ReservationDomain, ReservationResource> {


    public ReservationAssembler() {
        super(ReservationController.class, ReservationResource.class);
    }

    @Override
    public ReservationResource toResource(ReservationDomain domain) {
        ReservationResource resource = createResourceWithId(domain.getId(), domain);
        resource.setIdentifier(domain.getId());
        resource.setReservationName(domain.getReservationName());
        return resource;
    }

}
