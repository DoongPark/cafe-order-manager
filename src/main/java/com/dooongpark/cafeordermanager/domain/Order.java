package com.dooongpark.cafeordermanager.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private Long orderNum;
    private String menu;
    private Long pay;
}
