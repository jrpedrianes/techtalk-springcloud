package com.jrpedrianes.techtalk.springcloud.core.repository;

import com.jrpedrianes.techtalk.springcloud.core.domain.ReservationDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationDomain, Long> {
}
