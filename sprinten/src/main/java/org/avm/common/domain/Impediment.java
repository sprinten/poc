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

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "impediment")
public class Impediment extends BacklogItem {

	private static final long serialVersionUID = -8538287505887051515L;

	@DateTimeFormat(pattern = C_DATE_PATTERN)
	@Column(name = "dateOpen", nullable = false)
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime dateOpen;

	@DateTimeFormat(pattern = C_DATE_PATTERN)
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@Column(name = "dateClose", nullable = true)
	private DateTime dateClose;

	@Column(name = "impact", length = 3000, nullable = false)
	private String impact = "";

	@Column(name = "solution", length = 3000, nullable = false)
	private String solution = "";

	@Column(name = "rank", nullable = true)
	private Integer rank;

	@Column(name = "state", nullable = false)
	@Enumerated(EnumType.STRING)
	private State state = State.TODO;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "impediment")
	private List<Task> tasks = new ArrayList<Task>(0);

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentProductId", referencedColumnName = "id", nullable = false)
	private Product parentProduct;

	public void setParentProduct(Product product) {
		this.parentProduct = product;
	}

	public Product getParentProduct() {
		return parentProduct;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public DateTime getDateOpen() {
		return dateOpen;
	}

	public void setDateOpen(DateTime dateOpen) {
		this.dateOpen = dateOpen;
	}

	public DateTime getDateClose() {
		return dateClose;
	}

	public void setDateClose(DateTime dateClose) {
		this.dateClose = dateClose;
	}

	public String getImpact() {
		return impact;
	}

	public void setImpact(String impact) {
		this.impact = impact;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateClose == null) ? 0 : dateClose.hashCode());
		result = prime * result + ((dateOpen == null) ? 0 : dateOpen.hashCode());
		result = prime * result + ((impact == null) ? 0 : impact.hashCode());
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((solution == null) ? 0 : solution.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Impediment other = (Impediment) obj;
		if (dateClose == null) {
			if (other.dateClose != null) {
				return false;
			}
		} else if (!dateClose.equals(other.dateClose)) {
			return false;
		}
		if (dateOpen == null) {
			if (other.dateOpen != null) {
				return false;
			}
		} else if (!dateOpen.equals(other.dateOpen)) {
			return false;
		}
		if (impact == null) {
			if (other.impact != null) {
				return false;
			}
		} else if (!impact.equals(other.impact)) {
			return false;
		}
		if (rank == null) {
			if (other.rank != null) {
				return false;
			}
		} else if (!rank.equals(other.rank)) {
			return false;
		}
		if (solution == null) {
			if (other.solution != null) {
				return false;
			}
		} else if (!solution.equals(other.solution)) {
			return false;
		}
		if (state != other.state) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Element o) {
		if (!(o instanceof Impediment)) {
			throw new IllegalArgumentException();
		}
		return rank.compareTo(((Impediment) o).rank);
	}

	public enum State {
		TODO(1), SOLVING(3), SOLVED(7);

		private final int value;

		private State(int value) {
			this.value = value;
		}

		public final int getValue() {
			return value;
		}
	}
}
