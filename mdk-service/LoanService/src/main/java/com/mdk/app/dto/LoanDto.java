package com.mdk.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(
        name = "Loan",
        description = "Schema to hold Account information"
)
public class LoanDto {



    private String loanNumber;



    @Schema(
            description = "Mobile Number of the customer", example = "9345432123"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String phoneNumber;
    private BigDecimal loanBalance;
    private BigDecimal loanAmount;

}
