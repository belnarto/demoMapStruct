package com.example.demomapstruct.dto;

import java.time.Instant;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    private long id;
    private String title;
    private String url;
    private long bytes;
    private Boolean edited;
    private long likesCount;
    private Instant created;
    private Map<String, String> properties;
    private MetaInfoDto mainMeta;
    private Set<MetaInfoDto> metaInfos;
}
