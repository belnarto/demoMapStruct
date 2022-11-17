package com.example.demomapstruct.dto;

import com.example.demomapstruct.enums.AmazonSettingSyncPriceType;
import com.example.demomapstruct.enums.Gender;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String mainAddress;
    private String additionalAddress;
    private int age;
    private Gender gender;
    private double accountBalance;
    private Instant created;
    private LocalDate birthDate;
    private AmazonSettingSyncPriceType amazonSettingSyncPriceType;
    private Map<String, String> properties;
    private List<String> tags;
    private Collection<PostDto> posts;
}
