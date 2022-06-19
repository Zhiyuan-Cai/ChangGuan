package com.dazhou.entity;

import lombok.*;


@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
public class ControlInfoEntity {
    private int id;
    private String controlName;
    private String controlNum;
    private String gridName;
    private String gridNum;
    private String description;
    private String remark;
    private boolean isDel;
}
