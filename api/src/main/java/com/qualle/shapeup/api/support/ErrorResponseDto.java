package com.qualle.shapeup.api.support;

import lombok.*;

import java.util.Collection;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDto {

    private String type;

    private String messageTitle;

    private String message;

    private Map<String, String> additionalProperties;

    private Collection<String> stack;
}
