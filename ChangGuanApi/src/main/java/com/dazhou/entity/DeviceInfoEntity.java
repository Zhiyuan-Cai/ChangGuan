package com.dazhou.entity;

import lombok.*;


@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
public class DeviceInfoEntity {
    private int id;
    private String deviceName;
    private String deviceNum;
    private String deviceIP;
    private String category;
    private String sceneName;
    private String sceneNum;
    private String controlName;
    private String controlNum;
    private String gridName;
    private String gridNum;
    private String description;
    private String remark;
    private boolean isDel;
}
