package com.mdk.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseDto {

    private String statusCode;

    private String statusMessage;
}
