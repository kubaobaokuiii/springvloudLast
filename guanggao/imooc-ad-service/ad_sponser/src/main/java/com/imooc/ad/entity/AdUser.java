package com.imooc.ad.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ad_user")
public class AdUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long userId;

  @Basic
  @Column(name = "username", nullable = false)
  private String username;

  @Basic
  @Column(name = "token", nullable = false)
  private String token;

  @Basic
  @Column(name = "user_status", nullable = false)
  private Integer userStatus;

  @Basic
  @Column(name = "create_time", nullable = false)
  private Date createTime;

  @Basic
  @Column(name = "update_time", nullable = false)
  private Date updateTime;


  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Integer getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(Integer userStatus) {
    this.userStatus = userStatus;
  }

  /**
   * 构造函数
   */
  public AdUser(String username, String token) {
    this.username = username;
    this.token = token;
    this.userStatus = CommonStatus.VALID.getStatus();
    this.createTime = new Date();
    this.updateTime = this.createTime;
  }

}
