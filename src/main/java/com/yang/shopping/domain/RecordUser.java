package com.yang.shopping.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RecordUser {

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
    private Double ubalance;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:sss",timezone = "GMT+8")
    private Date udate;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:sss",timezone = "GMT+8")
    private Date deleteTime;

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
    public void setUbalance(Double ubalance)
    {
        this.ubalance = ubalance;
    }

    public Double getUbalance()
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
    public void setDeleteTime(Date deleteTime)
    {
        this.deleteTime = deleteTime;
    }

    public Date getDeleteTime()
    {
        return deleteTime;
    }

    @Override
    public String toString() {
        return "RecordUser{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upd='" + upd + '\'' +
                ", usex='" + usex + '\'' +
                ", uage=" + uage +
                ", uphone=" + uphone +
                ", ubalance=" + ubalance +
                ", udate=" + udate +
                ", deleteTime=" + deleteTime +
                '}';
    }
}