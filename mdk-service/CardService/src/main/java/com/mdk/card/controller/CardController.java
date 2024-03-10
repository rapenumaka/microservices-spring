package com.mdk.card.controller;

import com.mdk.card.dto.BuildDto;
import com.mdk.card.dto.CardDto;
import com.mdk.card.dto.ErrorResponseDto;
import com.mdk.card.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.completedFuture;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/card", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CardController {

    public CardService cardService;

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



    @PostMapping("/create")
    public CompletableFuture<ResponseEntity<CardDto>> createCard(@RequestParam
                                                                     @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                                     String phoneNumber, @RequestParam BigDecimal cardLimit){
        CompletableFuture<ResponseEntity<CardDto>> completableFuture =
                completedFuture(
                        ResponseEntity.accepted().
                                body(this.cardService.createCard(phoneNumber,cardLimit))
                ).toCompletableFuture();

        return completableFuture;
    }

    @GetMapping("/phoneNumber")
    public  CompletableFuture<ResponseEntity<CardDto>>   fetchCardByPhoneNumber(@RequestParam
                                                                                    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                                                    String phoneNumber){
        CompletableFuture<ResponseEntity<CardDto>> completableFuture =
                completedFuture(
                        ResponseEntity.ok(this.cardService.findbyPhoneNumber(phoneNumber))
                ).toCompletableFuture();

        return completableFuture;
    }
    @PutMapping("/updateCard")
    public  CompletableFuture<ResponseEntity<CardDto>>   updateCard(@RequestParam
                                                                        @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                                        String phoneNumber, @RequestParam BigDecimal payment){
        CompletableFuture<ResponseEntity<CardDto>> completableFuture =
                completedFuture(
                        ResponseEntity.ok(this.cardService.updateCard(phoneNumber, payment))
                ).toCompletableFuture();

        return completableFuture;


    }

    @GetMapping("/fetchAll")
    public CompletableFuture<ResponseEntity<List<CardDto>>> getAllCards(){
        CompletableFuture<ResponseEntity<List<CardDto>>> completableFuture =
                completedFuture(
                        ResponseEntity.ok(this.cardService.getAllCards())
                ).toCompletableFuture();

        return completableFuture;
    }

    @DeleteMapping("/remove/{phoneNumber}")
    public ResponseEntity<Boolean> deleteCard(@PathVariable @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                  String phoneNumber){
       Boolean value = this.cardService.deleteCard(phoneNumber);

       return  new ResponseEntity<>(value,HttpStatus.ACCEPTED);
    }

}
