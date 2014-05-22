package org.avm.common.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public abstract class Backlog extends Element {

	private static final long serialVersionUID = 8719560052290655075L;

	@DateTimeFormat(pattern = C_DATE_PATTERN)
	@Column(name = "dateStart", nullable = false)
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime dateStart;

	@DateTimeFormat(pattern = C_DATE_PATTERN)
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@Column(name = "dateEnd", nullable = true)
	private DateTime dateEnd;

	@Column(name = "description", nullable = true)
	private String description;

	@Column(name = "goal", nullable = true)
	private String goal;

	@Column(name = "orderNumber", nullable = true)
	private Integer orderNumber;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DateTime getDateStart() {
		return dateStart;
	}

	public void setDateStart(DateTime startDate) {
		this.dateStart = startDate;
	}

	public DateTime getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(DateTime endDate) {
		this.dateEnd = endDate;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public int compareTo(Element o) {
		if (!(o instanceof Backlog)) {
			throw new IllegalArgumentException();
		}
		return orderNumber.compareTo(((Backlog) o).orderNumber);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateEnd == null) ? 0 : dateEnd.hashCode());
		result = prime * result + ((goal == null) ? 0 : goal.hashCode());
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result + ((dateStart == null) ? 0 : dateStart.hashCode());
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
		Backlog other = (Backlog) obj;
		if (dateEnd == null) {
			if (other.dateEnd != null) {
				return false;
			}
		} else if (!dateEnd.equals(other.dateEnd)) {
			return false;
		}
		if (goal == null) {
			if (other.goal != null) {
				return false;
			}
		} else if (!goal.equals(other.goal)) {
			return false;
		}
		if (orderNumber == null) {
			if (other.orderNumber != null) {
				return false;
			}
		} else if (!orderNumber.equals(other.orderNumber)) {
			return false;
		}
		if (dateStart == null) {
			if (other.dateStart != null) {
				return false;
			}
		} else if (!dateStart.equals(other.dateStart)) {
			return false;
		}
		return true;
	}
}
