package com.mdk.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Schema(
        name = "Build",
        description = "Schema to hold Account information"
)
public class BuildDto {

    private String environment;

    private String version;
}
