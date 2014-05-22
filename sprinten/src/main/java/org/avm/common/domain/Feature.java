package org.avm.common.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "feature")
public class Feature extends BacklogItem {

	private static final long serialVersionUID = 1056410099440109339L;

	@Column(name = "description", length = 40, nullable = false)
	private String color = "blue";

	@Column(name = "value", nullable = true)
	private Integer value;

	@Column(name = "rank", nullable = true)
	private Integer rank;

	@Column(name = "type", nullable = false)
	@Enumerated(EnumType.STRING)
	private Type type = Type.FUNCTIONAL;

	@OneToMany(mappedBy = "feature", fetch = FetchType.LAZY, targetEntity = Story.class)
	private List<Story> stories = new ArrayList<Story>();

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "parentDomainId", referencedColumnName = "id", nullable = true)
	private Domain parentDomain;

	public List<Story> getStories() {
		return stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
	}

	public Domain getParentDomain() {
		return parentDomain;
	}

	public void setParentDomain(Domain domain) {
		this.parentDomain = domain;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Feature other = (Feature) obj;
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (rank == null) {
			if (other.rank != null) {
				return false;
			}
		} else if (!rank.equals(other.rank)) {
			return false;
		}
		if (type != other.type) {
			return false;
		}
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}

	public enum Type {
		FUNCTIONAL(0), ARCHITECTURAL(1);

		private final int value;

		private Type(int value) {
			this.value = value;
		}

		public final int getValue() {
			return value;
		}
	}
}
