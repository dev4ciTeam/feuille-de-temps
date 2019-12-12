package io.yekolab.lab.agenda.entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ricken BAZOLO
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    protected long _id;
    @Column(name = "VERS")
    protected long _version;
    @Column(name = "DEL")
    protected boolean _deleted;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_CREATE")
    protected final Date _dateCreate = new Date(System.currentTimeMillis());
    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_DATE_EDIT")
    protected Date _lastDateEdit;
}
