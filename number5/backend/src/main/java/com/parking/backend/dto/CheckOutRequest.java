package com.parking.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckOutRequest {

  @NotBlank
  private String plateNumber;
}
