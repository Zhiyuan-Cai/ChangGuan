package com.dazhou.entity;

import lombok.*;

@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
public class GridInfoEntity {
    private int id;
    private String name;
    private String gridNum;
    private String description;
    private String remark;
    private boolean isDel;
}
