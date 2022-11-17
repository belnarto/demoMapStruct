package com.example.demomapstruct.mapper;

import com.example.demomapstruct.dto.PostDto;
import com.example.demomapstruct.entity.PostEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class PostMapper {
    public final static PostMapper MAPPER = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "likes", source = "likesCount")
    public abstract PostEntity convert(PostDto postDto);

    @InheritInverseConfiguration
    public abstract PostDto convert(PostEntity postEntity);

}
