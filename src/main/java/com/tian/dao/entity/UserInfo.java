package com.tian.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = -829901939814462981L;
    private Long id;

    private String mobile;

    private String realName;

    private String nickName;

    private Byte sex;

    private String idCard;

    private String mail;

    private Date birthday;

    private Date createTime;

    private Date modifyTime;

    private String status;

    private Byte isDel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", realName='" + realName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", idCard='" + idCard + '\'' +
                ", mail='" + mail + '\'' +
                ", birthday=" + birthday +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", status='" + status + '\'' +
                ", isDel=" + isDel +
                '}';
    }
}