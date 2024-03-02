package com.mdk.account.dto;

import com.mdk.account.entity.AccountType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountDto {

    @NotEmpty(message = "city can not be a null or empty")
    @Schema(
            description = "Enter the City name", example = "Atlanta"
    )
    private String city;

    @NotEmpty(message = "AccountNumber can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "AccountNumber must be 10 digits")
    @Schema(
            description = "Account Number of Eazy Bank account", example = "3454433243"
    )
    private Long accountNumber;

    @NotEmpty(message = "AccountType can not be a null or empty")
    @Schema(
            description = "Can be anyone of these SAVINGS, CHECKING, LOAN", example = "SAVING"
    )
    private AccountType accountType;

    @NotEmpty(message = "customer number can not be a null or empty")
    @Schema(
            description = "Enter the Customer Number"
    )
    private Long customerId;



}
