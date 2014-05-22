package org.avm.common.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "domain")
public class Domain extends BacklogItem {

	private static final long serialVersionUID = 7406232910262586123L;

	@Column(name = "textColor", length = 7, nullable = true)
	private String textColor = " ";

	@Column(name = "color", length = 7, nullable = true)
	private String color = "#FFFFFF";

	@Column(name = "publish", nullable = true)
	private Boolean publish = true;

	@OneToMany(mappedBy = "domain", fetch = FetchType.LAZY, targetEntity = Feature.class)
	private List<Feature> features = new ArrayList<Feature>();


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentProductId", referencedColumnName = "id", nullable = false)
	private Product parentProduct;

	public void setParentProduct(Product product) {
		this.parentProduct = product;
	}

	public Product getParentProduct() {
		return parentProduct;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getPublish() {
		return publish;
	}

	public void setPublish(Boolean publish) {
		this.publish = publish;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((features == null) ? 0 : features.hashCode());
		result = prime * result + ((publish == null) ? 0 : publish.hashCode());
		result = prime * result + ((textColor == null) ? 0 : textColor.hashCode());
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
		Domain other = (Domain) obj;
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (features == null) {
			if (other.features != null) {
				return false;
			}
		} else if (!features.equals(other.features)) {
			return false;
		}
		if (publish == null) {
			if (other.publish != null) {
				return false;
			}
		} else if (!publish.equals(other.publish)) {
			return false;
		}
		if (textColor == null) {
			if (other.textColor != null) {
				return false;
			}
		} else if (!textColor.equals(other.textColor)) {
			return false;
		}
		return true;
	}

}
