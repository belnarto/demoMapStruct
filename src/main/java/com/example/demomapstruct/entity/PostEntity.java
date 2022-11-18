package com.example.demomapstruct.entity;

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
public class PostEntity {
    private Long id;
    private String title;
    private boolean edited;
    private long likes;
    private MetaInfoEntity mainMeta;
    private Instant created;
    private String url;
    private long bytes;
    private Map<Object, Object> properties;
    private Set<MetaInfoEntity> metaInfos;
}
