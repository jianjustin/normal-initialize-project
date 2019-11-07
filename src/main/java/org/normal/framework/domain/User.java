package org.normal.framework.domain;

import javax.persistence.*;

@Table(name = "user")
@Entity
public class User extends SuperEntity{
    @Id
    @GeneratedValue
    @Column(name = "PK_ID")
    public Long id;
    @Column(name = "MEMBER_USER_NAME")
    public String memberUserName;
    @Column(name = "MEMBER_USER_PASSWORD")
    public String memberPassword;
}
