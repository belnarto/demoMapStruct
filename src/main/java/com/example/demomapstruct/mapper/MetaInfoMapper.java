package com.example.demomapstruct.mapper;

import com.example.demomapstruct.dto.MetaInfoDto;
import com.example.demomapstruct.entity.MetaInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MetaInfoMapper {
    public final static MetaInfoMapper MAPPER = Mappers.getMapper(MetaInfoMapper.class);

    public abstract MetaInfoEntity convert(MetaInfoDto metaInfoDto);

    public abstract MetaInfoDto convert(MetaInfoEntity metaInfoEntity);

}
