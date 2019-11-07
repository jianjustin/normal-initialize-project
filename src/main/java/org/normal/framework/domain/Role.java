package org.normal.framework.domain;

import javax.persistence.*;

@Table(name = "role")
@Entity
public class Role extends SuperEntity{
    @Id
    @GeneratedValue
    @Column(name = "PK_ID")
    public Long id;
    @Column(name = "MEMBER_ROLE_NAME")
    public String memberRoleName;
}
