package org.avm.common.domain;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BacklogItem extends Element {

	private static final long serialVersionUID = -6800252500987149051L;

	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;

	@Column(name = "description", length = 3000, nullable = true)
	private StringBuffer description;

	@Column(name = "notes", length = 5000, nullable = true)
	private Set<String> notes = new TreeSet<String>();

	@ManyToOne
	@JoinColumn(name = "backlogId", referencedColumnName = "id", nullable = false)
	private Backlog backlog;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ownerId", referencedColumnName = "id", nullable = true)
	private User owner;

	public User getOwner() {
		return owner;
	}

	public void setOwner(User user) {
		this.owner = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StringBuffer getDescription() {
		return description;
	}

	public void setDescription(StringBuffer description) {
		this.description = description;
	}

	public Set<String> getNotes() {
		return notes;
	}

	public void setNotes(Set<String> notes) {
		this.notes = notes;
	}

	public Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((backlog == null) ? 0 : backlog.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BacklogItem other = (BacklogItem) obj;
		if (backlog == null) {
			if (other.backlog != null) {
				return false;
			}
		} else if (!backlog.equals(other.backlog)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (notes == null) {
			if (other.notes != null) {
				return false;
			}
		}
		return true;
	}
}
