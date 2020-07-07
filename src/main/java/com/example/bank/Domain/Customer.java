package com.example.bank.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Null
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String address;

    private Timestamp createDate;
    private Timestamp lastUpdateDate;
}
