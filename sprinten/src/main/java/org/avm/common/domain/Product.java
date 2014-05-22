package org.avm.common.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends Backlog {

	private static final long serialVersionUID = 8558832903350546856L;

	@Column(name = "name", nullable = false)
	private String name = "";

	@Column(name = "key", nullable = false)
	private String key;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, targetEntity = Feature.class)
	private List<Feature> features = new ArrayList<Feature>(0);

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, targetEntity = Story.class)
	private List<Story> stories = new ArrayList<Story>(0);

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, targetEntity = Release.class)
	private List<Release> releases = new ArrayList<Release>(0);

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, targetEntity = Impediment.class)
	private List<Impediment> impediments = new ArrayList<Impediment>(0);

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, targetEntity = Domain.class)
	private List<Domain> domains = new ArrayList<Domain>(0);

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "team_product", joinColumns = { @JoinColumn(name = "teamId") }, inverseJoinColumns = { @JoinColumn(name = "productId") })
	private List<Team> teams = new ArrayList<Team>(0);

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	public List<Story> getStories() {
		return stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
	}

	public List<Release> getReleases() {
		return releases;
	}

	public void setReleases(List<Release> releases) {
		this.releases = releases;
	}

	public List<Impediment> getImpediments() {
		return impediments;
	}

	public void setImpediments(List<Impediment> impediments) {
		this.impediments = impediments;
	}

	public List<Domain> getDomains() {
		return domains;
	}

	public void setDomains(List<Domain> domains) {
		this.domains = domains;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		Product other = (Product) obj;
		if (key == null) {
			if (other.key != null) {
				return false;
			}
		} else if (!key.equals(other.key)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
}
