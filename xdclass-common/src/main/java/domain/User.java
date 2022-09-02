package domain;

import lombok.Data;

import java.util.Date;

/**
 * @author on 2022/08/15.
 */
@Data
public class User {

    private Integer id;
    private String phone;
    private String pwd;
    private Integer sex;
    private String img;
    private Date createTime;
    /**
     * 1是普通用户，2是管理员
     */
    private Integer role;
    private String username;
    private String wechat;

}
