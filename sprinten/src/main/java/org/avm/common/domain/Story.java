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

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "story")
public class Story extends BacklogItem {

	private static final long serialVersionUID = -8644122786142519542L;

	@Column(name = "type", nullable = false)
	@Enumerated(EnumType.STRING)
	private Type type = Type.USER_STORY;

	@Column(name = "frequency", nullable = false)
	@Enumerated(EnumType.STRING)
	private Frequency frequency = Frequency.DAY;

	@Column(name = "state", nullable = false)
	@Enumerated(EnumType.STRING)
	private State state = State.SUGGESTED;

	@DateTimeFormat(pattern = C_DATE_PATTERN)
	@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@Column(name = "dateSuggested", nullable = true)
	private DateTime dateSuggested;

	@DateTimeFormat(pattern = C_DATE_PATTERN)
	@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@Column(name = "dateAccepted", nullable = true)
	private DateTime dateAccepted;

	@DateTimeFormat(pattern = C_DATE_PATTERN)
	@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@Column(name = "datePlanned", nullable = true)
	private DateTime datePlanned;

	@DateTimeFormat(pattern = C_DATE_PATTERN)
	@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@Column(name = "dateEstimated", nullable = true)
	private DateTime dateEstimated;

	@DateTimeFormat(pattern = C_DATE_PATTERN)
	@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@Column(name = "dateInProgress", nullable = true)
	private DateTime dateInProgress;

	@DateTimeFormat(pattern = C_DATE_PATTERN)
	@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@Column(name = "dateDone", nullable = true)
	private DateTime dateDone;

	@Column(name = "effort", nullable = true)
	private Integer effort = null;

	@Column(name = "priority", nullable = false)
	private Integer priority = 0;

	@Column(name = "affectVersion", nullable = true)
	private String affectVersion;

	@Column(name = "storyPoints", nullable = false)
	private Integer storyPoints = 0;

	@Column(name = "typeOfUser", nullable = false)
	private String typeOfUser = "";

	@Column(name = "goal", length = 1000, nullable = true)
	private String goal;

	@Column(name = "reason", length = 1000, nullable = true)
	private String reason;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "featureId", nullable = true)
	private Feature feature;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sprintId", nullable = true)
	private Sprint sprint;

	@OneToMany(mappedBy = "story", fetch = FetchType.LAZY, targetEntity = Task.class)
	private List<Task> tasks = new ArrayList<Task>(0);

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency executionFrequency) {
		this.frequency = executionFrequency;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public DateTime getDateSuggested() {
		return dateSuggested;
	}

	public void setDateSuggested(DateTime suggestedDate) {
		this.dateSuggested = suggestedDate;
	}

	public DateTime getDateAccepted() {
		return dateAccepted;
	}

	public void setDateAccepted(DateTime acceptedDate) {
		this.dateAccepted = acceptedDate;
	}

	public DateTime getDatePlanned() {
		return datePlanned;
	}

	public void setDatePlanned(DateTime plannedDate) {
		this.datePlanned = plannedDate;
	}

	public DateTime getDateEstimated() {
		return dateEstimated;
	}

	public void setDateEstimated(DateTime estimatedDate) {
		this.dateEstimated = estimatedDate;
	}

	public DateTime getDateInProgress() {
		return dateInProgress;
	}

	public void setDateInProgress(DateTime inProgressDate) {
		this.dateInProgress = inProgressDate;
	}

	public DateTime getDateDone() {
		return dateDone;
	}

	public void setDateDone(DateTime doneDate) {
		this.dateDone = doneDate;
	}

	public String getTypeOfUser() {
		return typeOfUser;
	}

	public void setTypeOfUser(String origin) {
		this.typeOfUser = origin;
	}

	public Integer getEffort() {
		return effort;
	}

	public void setEffort(Integer effort) {
		this.effort = effort;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer rank) {
		this.priority = rank;
	}

	public Integer getStoryPoints() {
		return storyPoints;
	}

	public void setStoryPoints(Integer value) {
		this.storyPoints = value;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String textICan) {
		this.goal = textICan;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String textTo) {
		this.reason = textTo;
	}

	public String getAffectVersion() {
		return affectVersion;
	}

	public void setAffectVersion(String affectVersion) {
		this.affectVersion = affectVersion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateAccepted == null) ? 0 : dateAccepted.hashCode());
		result = prime * result + ((affectVersion == null) ? 0 : affectVersion.hashCode());
		result = prime * result + ((dateDone == null) ? 0 : dateDone.hashCode());
		result = prime * result + ((effort == null) ? 0 : effort.hashCode());
		result = prime * result + ((dateEstimated == null) ? 0 : dateEstimated.hashCode());
		result = prime * result + ((frequency == null) ? 0 : frequency.hashCode());
		result = prime * result + ((dateInProgress == null) ? 0 : dateInProgress.hashCode());
		result = prime * result + ((typeOfUser == null) ? 0 : typeOfUser.hashCode());
		result = prime * result + ((sprint == null) ? 0 : sprint.hashCode());
		result = prime * result + ((datePlanned == null) ? 0 : datePlanned.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((dateSuggested == null) ? 0 : dateSuggested.hashCode());
		result = prime * result + ((goal == null) ? 0 : goal.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((storyPoints == null) ? 0 : storyPoints.hashCode());
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
		Story other = (Story) obj;
		if (dateAccepted == null) {
			if (other.dateAccepted != null) {
				return false;
			}
		} else if (!dateAccepted.equals(other.dateAccepted)) {
			return false;
		}
		if (affectVersion == null) {
			if (other.affectVersion != null) {
				return false;
			}
		} else if (!affectVersion.equals(other.affectVersion)) {
			return false;
		}
		if (dateDone == null) {
			if (other.dateDone != null) {
				return false;
			}
		} else if (!dateDone.equals(other.dateDone)) {
			return false;
		}
		if (effort == null) {
			if (other.effort != null) {
				return false;
			}
		} else if (!effort.equals(other.effort)) {
			return false;
		}
		if (dateEstimated == null) {
			if (other.dateEstimated != null) {
				return false;
			}
		} else if (!dateEstimated.equals(other.dateEstimated)) {
			return false;
		}
		if (frequency != other.frequency) {
			return false;
		}
		if (dateInProgress == null) {
			if (other.dateInProgress != null) {
				return false;
			}
		} else if (!dateInProgress.equals(other.dateInProgress)) {
			return false;
		}
		if (typeOfUser == null) {
			if (other.typeOfUser != null) {
				return false;
			}
		} else if (!typeOfUser.equals(other.typeOfUser)) {
			return false;
		}
		if (sprint == null) {
			if (other.sprint != null) {
				return false;
			}
		} else if (!sprint.equals(other.sprint)) {
			return false;
		}
		if (datePlanned == null) {
			if (other.datePlanned != null) {
				return false;
			}
		} else if (!datePlanned.equals(other.datePlanned)) {
			return false;
		}
		if (priority == null) {
			if (other.priority != null) {
				return false;
			}
		} else if (!priority.equals(other.priority)) {
			return false;
		}
		if (state != other.state) {
			return false;
		}
		if (dateSuggested == null) {
			if (other.dateSuggested != null) {
				return false;
			}
		} else if (!dateSuggested.equals(other.dateSuggested)) {
			return false;
		}
		if (goal == null) {
			if (other.goal != null) {
				return false;
			}
		} else if (!goal.equals(other.goal)) {
			return false;
		}
		if (reason == null) {
			if (other.reason != null) {
				return false;
			}
		} else if (!reason.equals(other.reason)) {
			return false;
		}
		if (type != other.type) {
			return false;
		}
		if (storyPoints == null) {
			if (other.storyPoints != null) {
				return false;
			}
		} else if (!storyPoints.equals(other.storyPoints)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Element o) {
		if (!(o instanceof Story)) {
			throw new IllegalArgumentException();
		}
		return priority.compareTo(((Story) o).priority);
	}

	public static enum Type {
		TECHNICAL(3), DEFECT(2), USER_STORY(0);

		private final int value;

		private Type(int value) {
			this.value = value;
		}

		public final int getValue() {
			return value;
		}
	}

	public static enum State {

		SUGGESTED(1), DONE(7), ACCEPTED(2), PLANNED(4), ESTIMATED(3), INPROGRESS(5);

		private final int value;

		private State(int value) {
			this.value = value;
		}

		public final int getValue() {
			return value;
		}
	}

	public enum Frequency {
		HOUR(0), DAY(1), WEEK(2), MONTH(3);
		private final int value;

		private Frequency(int value) {
			this.value = value;
		}

		public final int getValue() {
			return value;
		}
	}
}