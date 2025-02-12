package com.parking.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.backend.dto.CheckInRequest;
import com.parking.backend.dto.CheckOutRequest;
import com.parking.backend.model.VehicleTicket;
import com.parking.backend.service.VehicleTicketService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class VehicleTicketController {

  @Autowired
  private VehicleTicketService vehicleTicketService;

  @PostMapping("/check-in")
  public ResponseEntity<VehicleTicket> checkIn(@Valid @RequestBody CheckInRequest request) {
    VehicleTicket ticket = vehicleTicketService.checkIn(request.getPlateNumber());
    return ResponseEntity.ok(ticket);
  }

  @PostMapping("/check-out")
  public ResponseEntity<VehicleTicket> checkOut(@Valid @RequestBody CheckOutRequest request) {
    VehicleTicket ticket = vehicleTicketService.checkOut(request.getPlateNumber());
    return ResponseEntity.ok(ticket);
  }

  @GetMapping("/ticket/{plateNumber}")
  public ResponseEntity<VehicleTicket> getTicket(@PathVariable String plateNumber) {
    VehicleTicket ticket = vehicleTicketService.getTicket(plateNumber);
    return ResponseEntity.ok(ticket);
  }

}
