package org.avm.common.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "task")
public class Task extends BacklogItem implements Serializable {

	private static final long serialVersionUID = -7399441592678920364L;

	@Column(name = "type", nullable = false)
	@Enumerated(EnumType.STRING)
	private Type type = Type.DEFAULT;

	@Column(name = "state", nullable = false)
	@Enumerated(EnumType.STRING)
	private State state = State.WAIT;

	@Column(name = "estimation", nullable = true)
	private Integer estimation;

	@Column(name = "rank", nullable = false)
	private Integer rank;

	@Column(name = "blocked", nullable = false)
	private Boolean blocked = false;

	@DateTimeFormat(pattern = C_DATE_PATTERN)
	@Column(name = "doneDate", nullable = true)
	@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime doneDate;

	@DateTimeFormat(pattern = C_DATE_PATTERN)
	@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@Column(name = "inProgressDate", nullable = true)
	private DateTime inProgressDate;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "task_worker", joinColumns = { @JoinColumn(name = "workerId") }, inverseJoinColumns = { @JoinColumn(name = "taskId") })
	private List<User> workers = new ArrayList<User>(0);

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "impedimentId", referencedColumnName = "id", nullable = true)
	private Impediment impediment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storyId", referencedColumnName = "id", nullable = true)
	private Story story;

	public List<User> getWorkers() {
		return workers;
	}

	public void setWorkers(List<User> owners) {
		this.workers = owners;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public Impediment getImpediment() {
		return impediment;
	}

	public void setImpediment(Impediment impediment) {
		this.impediment = impediment;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public Task.Type getType() {
		return type;
	}

	public void setType(Task.Type type) {
		this.type = type;
	}

	public Integer getEstimation() {
		return estimation;
	}

	public void setEstimation(Integer estimation) {
		this.estimation = estimation;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public DateTime getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(DateTime doneDate) {
		this.doneDate = doneDate;
	}

	public DateTime getInProgressDate() {
		return inProgressDate;
	}

	public void setInProgressDate(DateTime inProgressDate) {
		this.inProgressDate = inProgressDate;
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
		result = prime * result + ((blocked == null) ? 0 : blocked.hashCode());
		result = prime * result + ((doneDate == null) ? 0 : doneDate.hashCode());
		result = prime * result + ((estimation == null) ? 0 : estimation.hashCode());
		result = prime * result + ((inProgressDate == null) ? 0 : inProgressDate.hashCode());
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Task other = (Task) obj;
		if (blocked == null) {
			if (other.blocked != null) {
				return false;
			}
		} else if (!blocked.equals(other.blocked)) {
			return false;
		}
		if (doneDate == null) {
			if (other.doneDate != null) {
				return false;
			}
		} else if (!doneDate.equals(other.doneDate)) {
			return false;
		}
		if (estimation == null) {
			if (other.estimation != null) {
				return false;
			}
		} else if (!estimation.equals(other.estimation)) {
			return false;
		}
		if (inProgressDate == null) {
			if (other.inProgressDate != null) {
				return false;
			}
		} else if (!inProgressDate.equals(other.inProgressDate)) {
			return false;
		}
		if (rank == null) {
			if (other.rank != null) {
				return false;
			}
		} else if (!rank.equals(other.rank)) {
			return false;
		}
		if (state != other.state) {
			return false;
		}
		if (type != other.type) {
			return false;
		}
		return true;
	}

	public static enum Type {

		RECURRENT(10), URGENT(11), DEFAULT(0);

		private final int value;

		private Type(int value) {
			this.value = value;
		}

		public final int getValue() {
			return value;
		}
	}

	public static enum State {

		BUSY(1), DONE(3), WAIT(0);

		private final int value;

		private State(int value) {
			this.value = value;
		}

		public final int getValue() {
			return value;
		}
	}
}
