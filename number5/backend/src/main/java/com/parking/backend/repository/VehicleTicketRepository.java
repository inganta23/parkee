package com.parking.backend.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.backend.model.VehicleTicket;

@Repository
public interface VehicleTicketRepository extends JpaRepository<VehicleTicket, UUID> {
  Optional<VehicleTicket> findByPlateNumberAndStatus(String plateNumber, VehicleTicket.TicketStatus status);

  Optional<VehicleTicket> findByPlateNumber(String plateNumber);
}
