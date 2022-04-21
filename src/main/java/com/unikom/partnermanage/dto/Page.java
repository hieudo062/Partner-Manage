package com.unikom.partnermanage.dto;

import lombok.Data;

@Data
public class Page {

    private int page;
    private int size;
    private int offset;

    public int getOffset() {
        return (this.page - 1) * this.size ;
    }
}
