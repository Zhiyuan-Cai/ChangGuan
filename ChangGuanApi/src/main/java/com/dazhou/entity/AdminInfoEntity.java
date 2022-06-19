package com.dazhou.entity;

import lombok.*;

@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
public class AdminInfoEntity {
    private int id;
    private String name;
    private String jobNum;
    private String sex;
    private String telephone;
    private String department;
    private String post;
    private int role;
    private String password;
    private boolean isDel;

}
