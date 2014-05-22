package org.avm.common.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public abstract class Element implements Comparable<Element>, Serializable {

	private static final long serialVersionUID = -575055419062359396L;

	public static final String C_DATE_PATTERN = "dd/mm/yyyy hh:mm:ss";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @DateTimeFormat(pattern = C_DATE_PATTERN)
    @Column(name = "dateChange", nullable = false)
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime dateChange;

    @DateTimeFormat(pattern = C_DATE_PATTERN)
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    @Column(name = "dateCreate", nullable = false)
    private DateTime dateCreate;

    @Version
    private Integer version;

    public Element() {
    }

    @PrePersist
    public void onPersist() {
        dateCreate = new DateTime().withMillisOfSecond(0);
        dateChange = new DateTime().withMillisOfSecond(0);
    }

    @PreUpdate
    public void onUpdate() {
        dateChange = new DateTime().withMillisOfSecond(0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public DateTime getDateChange() {
        return dateChange;
    }

    public void setDateChange(DateTime lastChange) {
        dateChange = lastChange;
    }

    public DateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(DateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dateChange == null) ? 0 : dateChange.hashCode());
        result = prime * result + ((dateCreate == null) ? 0 : dateCreate.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Element other = (Element) obj;

        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }

        if (version == null) {
            if (other.version != null) {
                return false;
            }
        } else if (!version.equals(other.version)) {
            return false;
        }

        if (dateCreate == null) {
            if (other.dateCreate != null) {
                return false;
            }
        } else if (!dateCreate.equals(other.dateCreate)) {
            return false;
        }
        if (dateChange == null) {
            if (other.dateChange != null) {
                return false;
            }
        } else if (!dateChange.equals(other.dateChange)) {
            return false;
        }

        return true;
    }

    public int compareTo(Element other) {
        return id.compareTo(other.id);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Element [");
        builder.append("id=");
        builder.append(id);
        builder.append(", dateCreate=");
        builder.append(dateCreate);
        builder.append(", dateChange=");
        builder.append(dateChange);
        builder.append(", version=");
        builder.append(version);
        builder.append("]");
        return builder.toString();
    }
}