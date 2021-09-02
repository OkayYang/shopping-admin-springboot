package com.yang.shopping.domain;


/**
 * 【请填写功能名称】对象 admin
 *
 * @author yang
 * @date 2021-08-06
 */
public class Admin
{
    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    private String name;

    /** $column.columnComment */
    private String password;

    private String realName;

    private Integer age;

    private String phone;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}