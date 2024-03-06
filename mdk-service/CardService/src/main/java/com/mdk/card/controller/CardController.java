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
import jdk.jshell.SourceCodeAnalysis;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/card", produces = {MediaType.APPLICATION_JSON_VALUE})
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




    public CompletableFuture<ResponseEntity<CardDto>> createCard(String phoneNumber, BigDecimal loanAmount){
        return null;
    }



}
