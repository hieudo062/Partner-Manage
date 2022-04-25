package com.unikom.partnermanage.dto.request;

import lombok.Data;

@Data
public class Search {

    private String code;
    private String name;
    private Integer foundedYear;
    private Integer quantityOfEmployee;

}
