package com.raja.app.dto;

import com.raja.app.entity.Passenger;
import com.raja.app.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {

    private Passenger passenger;

    private PaymentInfo paymentInfo;
}
