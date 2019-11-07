package org.normal.framework.domain;

import javax.persistence.*;

@Table(name = "user_role")
@Entity
public class UserRole extends SuperEntity{
    @Id
    @GeneratedValue
    @Column(name = "PK_ID")
    public Long id;
    @Column(name = "MEMBER_USER_ID")
    public Long memberUserId;
    @Column(name = "MEMBER_ROLE_ID")
    public Long memberRoleId;
}
