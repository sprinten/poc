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
@Table(name = "sprint")
public class Sprint extends Backlog {

	private static final long serialVersionUID = -3313833236276367849L;

	@Column(name = "state", nullable = false)
	@Enumerated(EnumType.STRING)
	private State state = State.WAIT;

	@Column(name = "retrospective", nullable = true)
	private String retrospective;

	@Column(name = "doneDefinition", nullable = true)
	private String doneDefinition;

	@DateTimeFormat(pattern = C_DATE_PATTERN)
	@Column(name = "dateActivation", nullable = true)
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime dateActivation;

	@DateTimeFormat(pattern = C_DATE_PATTERN)
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@Column(name = "dateClose", nullable = true)
	private DateTime dateClose;

	@Column(name = "velocity", nullable = false)
	private Double velocity = 0d;

	@Column(name = "capacity", nullable = false)
	private Double capacity = 0d;

	@Column(name = "dailyWorkTime", nullable = false)
	private Double dailyWorkTime = 8d;

	@Column(name = "resource", nullable = true)
	private Integer resource;

	@OneToMany(mappedBy = "sprint", fetch = FetchType.LAZY, targetEntity = Story.class)
	private List<Story> stories = new ArrayList<Story>();

	@OneToMany(mappedBy = "sprint", fetch = FetchType.LAZY, targetEntity = Task.class)
	private List<Task> tasks = new ArrayList<Task>(0);

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "releaseId", referencedColumnName = "id", nullable = false)
	private Release release;

	public List<Story> getStories() {
		return stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getRetrospective() {
		return retrospective;
	}

	public void setRetrospective(String retrospective) {
		this.retrospective = retrospective;
	}

	public String getDoneDefinition() {
		return doneDefinition;
	}

	public void setDoneDefinition(String doneDefinition) {
		this.doneDefinition = doneDefinition;
	}

	public DateTime getDateActivation() {
		return dateActivation;
	}

	public void setDateActivation(DateTime activationDate) {
		this.dateActivation = activationDate;
	}

	public DateTime getDateClose() {
		return dateClose;
	}

	public void setDateClose(DateTime closeDate) {
		this.dateClose = closeDate;
	}

	public Double getVelocity() {
		return velocity;
	}

	public void setVelocity(Double velocity) {
		this.velocity = velocity;
	}

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	public Double getDailyWorkTime() {
		return dailyWorkTime;
	}

	public void setDailyWorkTime(Double dailyWorkTime) {
		this.dailyWorkTime = dailyWorkTime;
	}

	public Integer getResource() {
		return resource;
	}

	public void setResource(Integer resource) {
		this.resource = resource;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateActivation == null) ? 0 : dateActivation.hashCode());
		result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((dateClose == null) ? 0 : dateClose.hashCode());
		result = prime * result + ((dailyWorkTime == null) ? 0 : dailyWorkTime.hashCode());
		result = prime * result + ((doneDefinition == null) ? 0 : doneDefinition.hashCode());
		result = prime * result + ((resource == null) ? 0 : resource.hashCode());
		result = prime * result + ((retrospective == null) ? 0 : retrospective.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((velocity == null) ? 0 : velocity.hashCode());
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
		Sprint other = (Sprint) obj;
		if (dateActivation == null) {
			if (other.dateActivation != null) {
				return false;
			}
		} else if (!dateActivation.equals(other.dateActivation)) {
			return false;
		}
		if (capacity == null) {
			if (other.capacity != null) {
				return false;
			}
		} else if (!capacity.equals(other.capacity)) {
			return false;
		}
		if (dateClose == null) {
			if (other.dateClose != null) {
				return false;
			}
		} else if (!dateClose.equals(other.dateClose)) {
			return false;
		}
		if (dailyWorkTime == null) {
			if (other.dailyWorkTime != null) {
				return false;
			}
		} else if (!dailyWorkTime.equals(other.dailyWorkTime)) {
			return false;
		}
		if (doneDefinition == null) {
			if (other.doneDefinition != null) {
				return false;
			}
		} else if (!doneDefinition.equals(other.doneDefinition)) {
			return false;
		}
		if (resource == null) {
			if (other.resource != null) {
				return false;
			}
		} else if (!resource.equals(other.resource)) {
			return false;
		}
		if (retrospective == null) {
			if (other.retrospective != null) {
				return false;
			}
		} else if (!retrospective.equals(other.retrospective)) {
			return false;
		}
		if (state != other.state) {
			return false;
		}
		if (velocity == null) {
			if (other.velocity != null) {
				return false;
			}
		} else if (!velocity.equals(other.velocity)) {
			return false;
		}
		return true;
	}

	public static enum State {

		INPROGRESS(2), DONE(3), WAIT(1);

		private final int value;

		private State(int value) {
			this.value = value;
		}

		public final int getValue() {
			return value;
		}
	}
}
