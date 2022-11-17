package com.example.demomapstruct.dto;

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
//    private String title;
//    private String url;
//    private long bytes;
//    private Boolean edited;
    private long likesCount;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
//    private Instant created;
//    private Map<Object, Object> properties;
//    private MetaInfoDto mainMeta;
//    private Set<MetaInfoDto> metaInfos;
}
