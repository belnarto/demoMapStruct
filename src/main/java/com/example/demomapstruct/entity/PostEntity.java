package com.example.demomapstruct.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostEntity {
    private Long id;
//    private String title;
//    private boolean edited;
    private long likes;
//    private MetaInfoEntity mainMeta;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
//    private Instant created;
//    private String url;
//    private long bytes;
//    private Map<Object, Object> properties;
//    private Set<MetaInfoEntity> metaInfos;
}
