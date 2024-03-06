package com.mdk.card.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class CardDto {

    private String cardNo;



    @Schema(
            description = "Mobile Number of the customer", example = "9345432123"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String phoneNumber;
    private BigDecimal cardBalance;
    private BigDecimal cardLimit;
}
