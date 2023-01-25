package com.haijing.jupiter.entity.request;

import com.haijing.jupiter.entity.db.Item;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FavoriteRequestBody {

    @JsonProperty("favorite")
    private Item favoriteItem;

    public Item getFavoriteItem() {
        return favoriteItem;
    }
}

