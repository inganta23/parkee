package com.parking.backend.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicle_tickets")
public class VehicleTicket {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private String plateNumber;

  @CreationTimestamp
  @Column(nullable = false)
  private Timestamp checkInTime;

  @Column(nullable = true)
  private Timestamp checkOutTime;

  @Column(nullable = true)
  private BigDecimal totalPrice;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private TicketStatus status = TicketStatus.ACTIVE;

  public enum TicketStatus {
    ACTIVE, COMPLETED
  }

}
