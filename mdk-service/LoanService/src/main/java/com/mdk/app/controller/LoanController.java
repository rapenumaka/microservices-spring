package com.mdk.app.controller;

import com.mdk.app.dto.BuildDto;
import com.mdk.app.dto.ErrorResponseDto;
import com.mdk.app.dto.LoanDto;
import com.mdk.app.service.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.apache.hc.core5.concurrent.CompletedFuture;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/loan", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class LoanController {


    private LoanService loanService;

    // get build info
    @Operation(
            summary = "Get Java version",
            description = "Get Java versions details that is installed into cards microservice"
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
    @GetMapping("/build")
    public ResponseEntity<BuildDto> getBuildInfo(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(new BuildDto("test", "v1"));
    }
    @Operation(
            summary = "Create the Loan",
            description = "Create the loan by phoneNumber"
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
    // create loan
    //http://localhost:8083/api/card/create?phoneNumber=9312847450&amount=12000.26'
    @PostMapping("/create")
    public ResponseEntity<LoanDto> createPhone(String phoneNumber, BigDecimal amount){
      return ResponseEntity.ok(this.loanService.createLoan(phoneNumber, amount));
    }

    // get loan by phone Number
    @Operation(
            summary = "Get Loan by phoneNumber",
            description = "Get Loan by phoneNumber"
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
    @GetMapping("/find")
    public ResponseEntity<LoanDto> findByPhoneNumber(String phoneNumber){
        return ResponseEntity.ok(this.loanService.findbyPhoneNumber(phoneNumber));
    }


    // get all Loan
    @Operation(
            summary = "Get All Loans",
            description = "Get All Loans microservice from db"
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
    @GetMapping("/loans")
    public CompletableFuture<ResponseEntity<List<LoanDto>>> getAllLoans(){


        CompletableFuture<ResponseEntity<List<LoanDto>>> completedFuture = CompletableFuture.
                completedFuture(
                        ResponseEntity.accepted().
                                body(this.loanService.getAllLoans())
                ).toCompletableFuture();
        return completedFuture;
    }

    @Operation(
            summary = "Update the Loan",
            description = "Update the loan based on PhoneNumber and Amount"
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
    // update the loan
    @PutMapping("/pay")
    public ResponseEntity<LoanDto> payloan(String phoneNumber, BigDecimal amount){
        LoanDto loanDto = this.loanService.updateLoan(phoneNumber, amount);
        return ResponseEntity.ok(loanDto);
    }

    // delete the loan
    @Operation(
            summary = "Delete the Loan",
            description = "Delete the Loan"
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
    @DeleteMapping("/clearLoan")
    public ResponseEntity<Void> deleteLoan(String phoneNumber){
        this.loanService.deleteLoan(phoneNumber);
        return (ResponseEntity<Void>) ResponseEntity.status(HttpStatus.OK);
    }
}
