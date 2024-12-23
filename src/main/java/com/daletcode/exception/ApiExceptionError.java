package com.daletcode.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiExceptionError {

    @JsonProperty("message")
    private String message;

    @JsonProperty("error_code")
    private String errorCode;

    @JsonProperty("status_code")
    private String statusCode;

    @JsonProperty("response_data")
    private Object responseData;
}
