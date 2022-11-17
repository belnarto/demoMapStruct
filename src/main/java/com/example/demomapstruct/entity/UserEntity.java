package com.example.demomapstruct.entity;

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
public class UserEntity {
    private long id;
    private String name;
    private String email;
    private String address;
    private LocalDate birthdate;
    private int amazonSettingSyncPriceType;
    private Map<String, String> properties;
    private Collection<String> tags;
    private String surname;
    private int age;
    private Gender gender;
    private double accountBalance;
    private Instant createdAt;
    private List<PostEntity> posts;
}
