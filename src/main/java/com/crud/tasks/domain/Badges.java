package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Badges {

    private int votes;

    @JsonProperty("attachmentsByType")
    private AttachmentsByType attachments;

}
