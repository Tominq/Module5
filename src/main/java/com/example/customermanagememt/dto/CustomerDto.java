package com.example.customermanagememt.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long id;
    @Size(min = 5, max = 15, message = "User name contains 5-15 chracters")
    private String name;
    private String email;
    private String address;
}
