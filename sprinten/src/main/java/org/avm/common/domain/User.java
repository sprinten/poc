package org.avm.common.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends Element {

	private static final long serialVersionUID = 234038202622720860L;

	@Column(name = "lastName", nullable = false)
	private String lastName = "Doe";

	@Column(name = "firstName", nullable = false)
	private String firstName = "John";

	@Column(name = "username", nullable = false, unique = true)
	private String username = "";

	@Column(name = "password", nullable = false)
	private String password = "";

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "velocity", nullable = false)
	private Boolean enabled = true;

	@Column(name = "accountExpired", nullable = false)
	private Boolean accountExpired;

	@Column(name = "accountLocked", nullable = false)
	private Boolean accountLocked;

	@Column(name = "passwordExpired", nullable = false)
	private Boolean passwordExpired;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "team_user", joinColumns = { @JoinColumn(name = "teamId") }, inverseJoinColumns = { @JoinColumn(name = "userId") })
	private List<Team> teams = new ArrayList<Team>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "task_worker", joinColumns = { @JoinColumn(name = "taskId") }, inverseJoinColumns = { @JoinColumn(name = "workerId") })
	private List<Task> tasks = new ArrayList<Task>(0);

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getAccountExpired() {
		return accountExpired;
	}

	public void setAccountExpired(Boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	public Boolean getAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(Boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public Boolean getPasswordExpired() {
		return passwordExpired;
	}

	public void setPasswordExpired(Boolean passwordExpired) {
		this.passwordExpired = passwordExpired;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((accountExpired == null) ? 0 : accountExpired.hashCode());
		result = prime * result + ((accountLocked == null) ? 0 : accountLocked.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((passwordExpired == null) ? 0 : passwordExpired.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (accountExpired == null) {
			if (other.accountExpired != null) {
				return false;
			}
		} else if (!accountExpired.equals(other.accountExpired)) {
			return false;
		}
		if (accountLocked == null) {
			if (other.accountLocked != null) {
				return false;
			}
		} else if (!accountLocked.equals(other.accountLocked)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (enabled == null) {
			if (other.enabled != null) {
				return false;
			}
		} else if (!enabled.equals(other.enabled)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (passwordExpired == null) {
			if (other.passwordExpired != null) {
				return false;
			}
		} else if (!passwordExpired.equals(other.passwordExpired)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}
}
