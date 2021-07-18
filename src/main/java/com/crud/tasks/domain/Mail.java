package com.crud.tasks.domain;

import lombok.*;

@Getter
//@Builder
@AllArgsConstructor
public final class Mail {
    private final String mailTo;
    private final String subject;
    private final String message;
    private final String toCc;
}
