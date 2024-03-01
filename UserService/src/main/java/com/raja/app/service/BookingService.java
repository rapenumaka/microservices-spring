package com.raja.app.service;

import com.raja.app.dto.BookingRequest;
import com.raja.app.dto.BookingStatus;
import com.raja.app.entity.Passenger;
import com.raja.app.entity.PaymentInfo;
import com.raja.app.repository.PassengerRepository;
import com.raja.app.repository.PaymentInfoRepository;
import com.raja.app.utils.PaymentUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import java.util.UUID;

@Service
public class BookingService {
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;


    @Transactional //(readOnly= false, isolation= Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public BookingStatus bookTicket(BookingRequest bookingRequest){

        Passenger passenger = bookingRequest.getPassenger();
        PaymentInfo paymentInfo = bookingRequest.getPaymentInfo();
        passengerRepository.save(passenger);
        PaymentUtils.validateLimits(paymentInfo.getAccountNo(),passenger.getFare());

        paymentInfo.setPassengerId(passenger.getPassengerId());
        paymentInfo.setAmount(passenger.getFare());
        paymentInfoRepository.save(paymentInfo);

        return new BookingStatus("RESERVED", passenger.getFare(), UUID.randomUUID().toString().split("-")[0],passenger);
    }
}
