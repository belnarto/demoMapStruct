package com.example.demomapstruct.mapper;

import com.example.demomapstruct.dto.UserDto;
import com.example.demomapstruct.entity.UserEntity;
import com.example.demomapstruct.enums.AmazonSettingSyncPriceType;
import java.util.stream.Stream;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {PostMapper.class})
public abstract class UserMapper {

    @Mapping(target = "address", source = "mainAddress")
    @Mapping(target = "birthdate", source = "birthDate")
    @Mapping(target = "createdAt", source = "created")
    public abstract UserEntity convert(UserDto userDto);

    @InheritInverseConfiguration
    @Mapping(target = "additionalAddress", ignore = true)
    public abstract UserDto convert(UserEntity userEntity);

    protected int mapAmazonSettingSyncPriceType(AmazonSettingSyncPriceType amazonSettingSyncPriceType) {
        return amazonSettingSyncPriceType.getType();
    }

    protected AmazonSettingSyncPriceType mapAmazonSettingSyncPriceType(int amazonSettingSyncPriceType) {
        return Stream.of(AmazonSettingSyncPriceType.values())
            .filter(v -> v.getType() == amazonSettingSyncPriceType)
            .findFirst()
            .orElse(null);
    }
}
