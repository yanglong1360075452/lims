package com.wizinno.lims.user.service.data;

/**
 * @author LiuMei on 2017-06-02.
 */
public enum PermissionEnum {

    /**
     * 系统管理
     */
    SYSTEM_MANAGE(1,"系统管理"),
    ;

    private Integer nCode;

    private String name;


    PermissionEnum(Integer code, String name) {
        this.nCode = code;
        this.name = name;
    }

    public Integer toCode(){
        return this.nCode;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static PermissionEnum valueOf(Integer code) {
        for (PermissionEnum permissionEnum : PermissionEnum.values()){
            if (permissionEnum.toCode().equals(code)){
                return permissionEnum;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        for (PermissionEnum permissionEnum : PermissionEnum.values()){
            if (permissionEnum.toCode().equals(code)){
                return permissionEnum.name;
            }
        }
        return null;
    }
    
}
