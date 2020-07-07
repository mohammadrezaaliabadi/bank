package com.example.bank.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    @Null
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String address;

    private OffsetDateTime createDate;
    private OffsetDateTime lastUpdateDate;
}
