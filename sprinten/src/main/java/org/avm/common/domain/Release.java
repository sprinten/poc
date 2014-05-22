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
@Table(name = "release")
public class Release extends Backlog {

	private static final long serialVersionUID = -454533210406032422L;

	@Column(name = "state", nullable = false)
	@Enumerated(EnumType.STRING)
	private State state = State.WAIT;

	@Column(name = "velocity", nullable = false)
	private Double velocity = 0d;

	@Column(name = "vision", nullable = true)
	private String vision = "";

	@Column(name = "name", nullable = false, unique = true)
	private String name = "R";

	@OneToMany(mappedBy = "release", fetch = FetchType.LAZY, targetEntity = Sprint.class)
	private List<Sprint> sprints = new ArrayList<Sprint>(0);

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentProductId", referencedColumnName = "id", nullable = false)
	private Product parentProduct;

	public Product getParentProduct() {
		return parentProduct;
	}

	public void setParentProduct(Product product) {
		this.parentProduct = product;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Double getVelocity() {
		return velocity;
	}

	public void setVelocity(Double releaseVelocity) {
		this.velocity = releaseVelocity;
	}

	public String getVision() {
		return vision;
	}

	public void setVision(String vision) {
		this.vision = vision;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((velocity == null) ? 0 : velocity.hashCode());
		result = prime * result + ((sprints == null) ? 0 : sprints.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((vision == null) ? 0 : vision.hashCode());
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
		Release other = (Release) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (velocity == null) {
			if (other.velocity != null) {
				return false;
			}
		} else if (!velocity.equals(other.velocity)) {
			return false;
		}
		if (sprints == null) {
			if (other.sprints != null) {
				return false;
			}
		} else if (!sprints.equals(other.sprints)) {
			return false;
		}
		if (state != other.state) {
			return false;
		}
		if (vision == null) {
			if (other.vision != null) {
				return false;
			}
		} else if (!vision.equals(other.vision)) {
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
