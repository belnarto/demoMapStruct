package com.example.demomapstruct.mapper;

import com.example.demomapstruct.dto.UserDto;
import com.example.demomapstruct.entity.UserEntity;
import com.example.demomapstruct.enums.AmazonSettingSyncPriceType;
import java.util.stream.Stream;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = PostMapper.class)
public abstract class UserMapper {
    public final static UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "address", source = "mainAddress")
    @Mapping(target = "birthdate", source = "birthDate")
    @Mapping(target = "createdAt", source = "created")
    @Mapping(target = "amazonSettingSyncPriceType", source = "amazonSettingSyncPriceType")
    public abstract UserEntity convert(UserDto userDto);

    @InheritInverseConfiguration
    @Mapping(target = "additionalAddress", ignore = true)
    @Mapping(target = "amazonSettingSyncPriceType", source = "amazonSettingSyncPriceType")
    public abstract UserDto convert(UserEntity userEntity);

    int mapAmazonSettingSyncPriceType(AmazonSettingSyncPriceType amazonSettingSyncPriceType) {
        return amazonSettingSyncPriceType.getType();
    }

    AmazonSettingSyncPriceType mapAmazonSettingSyncPriceType(int amazonSettingSyncPriceType) {
        return Stream.of(AmazonSettingSyncPriceType.values())
            .filter(v -> v.getType() == amazonSettingSyncPriceType)
            .findFirst()
            .orElse(null);
    }
}
