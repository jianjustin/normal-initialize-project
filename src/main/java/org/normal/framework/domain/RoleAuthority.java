package org.normal.framework.domain;

import javax.persistence.*;

@Table(name = "role_authority")
@Entity
public class RoleAuthority extends SuperEntity{
    @Id
    @GeneratedValue
    @Column(name = "PK_ID")
    public Long id;
    @Column(name = "MEMBER_ROLE_ID")
    public Long memberRoleId;
    @Column(name = "MEMBER_AUTHORITY_ID")
    public Long memberAuthorityId;
}
