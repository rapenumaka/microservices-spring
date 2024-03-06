package com.mdk.account.controller;

import com.mdk.account.constants.AccountConstant;
import com.mdk.account.dto.CustomerDto;
import com.mdk.account.dto.ErrorResponseDto;
import com.mdk.account.dto.ResponseDto;
import com.mdk.account.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(
        name = "CRUD REST APIs for Accounts in Bank",
        description = "CRUD REST APIs in Bank to CREATE, UPDATE, FETCH AND DELETE account details"
)
@RestController
@RequestMapping(path="/api/v1/account", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
// This class should not contain NoArgsConstructor
@Validated
public class AccountController {

    private CustomerService customerService;

    @Operation(
            summary = "Create Account REST API",
            description = "REST API to create new Customer &  Account inside Bank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCustomerAccount( @Valid @RequestBody CustomerDto customerDto){
        this.customerService.createCustomerAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstant.STATUS_201, AccountConstant.MESSAGE_201));
    }


    @Operation(
            summary = "Fetch Account Details REST API",
            description = "REST API to fetch Customer &  Account details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/mobile")
    public ResponseEntity<CustomerDto> getCustomerByPhoneNumber(@RequestParam
                                                                    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                                    String phoneNumber){
        CustomerDto customer = this.customerService.getCustomerByPhoneNumber(phoneNumber);

       return ResponseEntity.ok(customer);
    }
}
