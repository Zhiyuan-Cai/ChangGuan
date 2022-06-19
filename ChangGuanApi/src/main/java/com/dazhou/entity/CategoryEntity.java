package com.dazhou.entity;

import lombok.*;


@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
public class CategoryEntity {
    private int id;
    private String name;
    private String cid;
    private String remark;
    private boolean isDel;
}
