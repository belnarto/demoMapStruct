package com.example.demomapstruct.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AmazonSettingSyncPriceType {
    DO_NOT_SYNC(0),
    SYNC_FROM_AMAZON_TO_SHOPIFY(1),
    SYNC_FROM_SHOPIFY_TO_AMAZON(2),
    SYNC_BOTH_DIRECTION(3);

    private final int type;
}
