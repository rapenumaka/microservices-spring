package com.raja.app.dto;

import com.raja.app.entity.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingStatus {

    private String status;

    private  double totalFare;

    private String pnrNo;

    private Passenger passenger;
}
