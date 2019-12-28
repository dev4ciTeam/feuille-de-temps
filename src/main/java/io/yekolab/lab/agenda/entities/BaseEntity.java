package io.yekolab.lab.agenda.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ricken BAZOLO
 */
@MappedSuperclass
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    protected long id;
    @Column(name = "VERS")
    protected long version;
    @Column(name = "DEL")
    protected boolean deleted;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_CREATE")
    protected final Date dateCreate = new Date(System.currentTimeMillis());
    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_DATE_EDIT")
    protected Date lastDateEdit;
}
