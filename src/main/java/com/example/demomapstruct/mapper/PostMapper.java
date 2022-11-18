package com.example.demomapstruct.mapper;

import com.example.demomapstruct.dto.PostDto;
import com.example.demomapstruct.entity.PostEntity;
import java.util.Map;
import java.util.stream.Collectors;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {MetaInfoMapper.class})
public abstract class PostMapper {

    @Mapping(target = "likes", source = "likesCount")
    public abstract PostEntity convert(PostDto postDto);

    @InheritInverseConfiguration
    public abstract PostDto convert(PostEntity postEntity);

    protected Map<String, String> mapPostEntityPropertiesToPostDtoProperties(Map<Object, Object> postEntityProperties) {
        return postEntityProperties
            .entrySet().stream()
            .filter(e -> e.getKey() instanceof String && e.getValue() instanceof String)
            .collect(Collectors.toMap(e -> (String) e.getKey(), e -> (String) e.getValue()));
    }

}
