package com.yang.shopping.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 【请填写功能名称】对象 user
 *
 * @author yang
 * @date 2021-08-12
 */
public class User {


    /** $column.columnComment */
    private Long uid;

    /** $column.columnComment */

    private String uname;

    /** $column.columnComment */

    private String upd;

    /** $column.columnComment */

    private String usex;

    /** $column.columnComment */

    private Long uage;

    /** $column.columnComment */

    private Long uphone;

    /** $column.columnComment */

    private BigDecimal ubalance;

    /** $column.columnComment */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:sss",timezone = "GMT+8")
    private Date udate;

    public void setUid(Long uid)
    {
        this.uid = uid;
    }

    public Long getUid()
    {
        return uid;
    }
    public void setUname(String uname)
    {
        this.uname = uname;
    }

    public String getUname()
    {
        return uname;
    }
    public void setUpd(String upd)
    {
        this.upd = upd;
    }

    public String getUpd()
    {
        return upd;
    }
    public void setUsex(String usex)
    {
        this.usex = usex;
    }

    public String getUsex()
    {
        return usex;
    }
    public void setUage(Long uage)
    {
        this.uage = uage;
    }

    public Long getUage()
    {
        return uage;
    }
    public void setUphone(Long uphone)
    {
        this.uphone = uphone;
    }

    public Long getUphone()
    {
        return uphone;
    }
    public void setUbalance(BigDecimal ubalance)
    {
        this.ubalance = ubalance;
    }

    public BigDecimal getUbalance()
    {
        return ubalance;
    }
    public void setUdate(Date udate)
    {
        this.udate = udate;
    }

    public Date getUdate()
    {
        return udate;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upd='" + upd + '\'' +
                ", usex='" + usex + '\'' +
                ", uage=" + uage +
                ", uphone=" + uphone +
                ", ubalance=" + ubalance +
                ", udate=" + udate +
                '}';
    }
}