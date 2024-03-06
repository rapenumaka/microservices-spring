package com.mdk.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Schema(
        name = "Response",
        description = "Schema to hold Account information"
)
public class ResponseDto {

    private String statusCode;

    private String statusMessage;
}
