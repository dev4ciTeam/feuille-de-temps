package io.yekolab.lab.agenda.entities;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ricken BAZOLO
 */
@Entity
@Table(name = "tbl_user", schema = "agenda_db")
@NamedQueries({
    @NamedQuery(name = "UserEntity.findAllByEmail", query = "SELECT u FROM UserEntity u WHERE u.email = :email"),
    @NamedQuery(name = "UserEntity.findAllByCredential", query = "SELECT u FROM UserEntity u WHERE u.email = :email AND u.password = :password"),
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseEntity{
    private static final Set<String> DEFAULT_ROLE = new HashSet<>(Arrays.asList(Roles.ROLE_USER));
    @Basic
    @Column(name = "EMAIL", length = 80)
    private String email;
    @Basic
    @Column(name = "PASSWORD", length = 8)
    private String password;
    @Basic
    @Column(name = "NOM", length = 50)
    private String nom;
    @Basic
    @Column(name = "PRENOM", length = 50)
    private String prenom;
    @Basic
    @Column(name = "FONCTION", length = 50)
    private String fonction;
    @Column(name = "IMAGE", length = 65555)
    private byte[] image;
    @Column(name = "PHOTO")
    private String urlImage;
    @ElementCollection(targetClass = Roles.class)
    @CollectionTable(name = "tbl_user_roles", schema = "agenda_db")
    private final Set<String> roles = DEFAULT_ROLE;

    @Override
    public String toString() {
        return this.nom+" "+this.prenom;
    }
    
    
}
