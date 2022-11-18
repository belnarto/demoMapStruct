package com.example.demomapstruct.mapper;

import com.example.demomapstruct.dto.MetaInfoDto;
import com.example.demomapstruct.entity.MetaInfoEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class MetaInfoMapper {

    public abstract MetaInfoEntity convert(MetaInfoDto metaInfoDto);

    public abstract MetaInfoDto convert(MetaInfoEntity metaInfoEntity);

}
