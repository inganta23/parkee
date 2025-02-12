package com.parking.backend.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parking.backend.model.VehicleTicket;
import com.parking.backend.repository.VehicleTicketRepository;

@Service
public class VehicleTicketService {
  @Autowired
  private VehicleTicketRepository vehicleTicketRepository;

  private static final BigDecimal HOURLY_RATE = new BigDecimal("3000");

  @Transactional
  public VehicleTicket checkIn(String plateNumber) {
    if (vehicleTicketRepository.findByPlateNumberAndStatus(plateNumber, VehicleTicket.TicketStatus.ACTIVE)
        .isPresent()) {
      throw new RuntimeException("Vehicle already has an active ticket.");
    }

    VehicleTicket ticket = new VehicleTicket();
    ticket.setPlateNumber(plateNumber);
    return vehicleTicketRepository.save(ticket);
  }

  @Transactional
  public VehicleTicket checkOut(String plateNumber) {
    VehicleTicket ticket = vehicleTicketRepository
        .findByPlateNumberAndStatus(plateNumber, VehicleTicket.TicketStatus.ACTIVE)
        .orElseThrow(() -> new RuntimeException("No active ticket found for the given plate number."));

    ticket.setCheckOutTime(Timestamp.from(Instant.now()));

    long hours = Duration.between(ticket.getCheckInTime().toInstant(), ticket.getCheckOutTime().toInstant()).toHours();
    BigDecimal totalPrice = (hours == 0) ? HOURLY_RATE : HOURLY_RATE.multiply(new BigDecimal(hours));

    ticket.setTotalPrice(totalPrice);
    ticket.setStatus(VehicleTicket.TicketStatus.COMPLETED);

    return vehicleTicketRepository.save(ticket);
  }

  public VehicleTicket getTicket(String plateNumber) {
    VehicleTicket ticket = vehicleTicketRepository
        .findByPlateNumberAndStatus(plateNumber, VehicleTicket.TicketStatus.ACTIVE)
        .orElseThrow(() -> new RuntimeException("No ticket found for the given plate number."));

    long hours = Duration.between(ticket.getCheckInTime().toInstant(), Instant.now()).toHours();
    BigDecimal totalPrice = (hours == 0) ? HOURLY_RATE : HOURLY_RATE.multiply(new BigDecimal(hours));
    ticket.setTotalPrice(totalPrice);

    ticket.setTotalPrice(totalPrice);

    return ticket;
  }
}
