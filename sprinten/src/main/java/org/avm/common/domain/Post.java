package org.avm.common.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post extends Element {

	private static final long serialVersionUID = 4566662818123778028L;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "content", nullable = false)
	private String content = "";

	@Column(name = "author", length = 20, nullable = false)
	private String author;

	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY, targetEntity = Comment.class)
	private List<Comment> comments = new ArrayList<Comment>(0);

	@Column(name = "tags", nullable = true)
	private List<String> tags = new ArrayList<String>(0);

	public Post() {
		author = "admin";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortTitle() {
		if (title.length() < 14) {
			return title;
		}
		StringBuffer result = new StringBuffer();
		String[] words = title.split(" ");

		for (int i = 0; i < words.length; i++) {
			if (result.toString().length() < 10) {
				result.append(words[i] + " ");
			}
		}

		return result.toString() + "...";
	}

	public String getLinkTitle() {
		StringBuffer result = new StringBuffer();
		String[] words = title.split(" ");

		for (int i = 0; i < words.length; i++) {
			result.append(words[i] + "_");
		}

		result.append(getId());

		return result.toString();
	}

	public String getLinkAuthor() {
		StringBuffer result = new StringBuffer();
		String[] words = author.split(" ");

		result.append(words[0]);
		for (int i = 1; i < words.length; i++) {
			result.append("_" + words[i]);
		}

		return result.toString();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String user) {
		this.author = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
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
		Post other = (Post) obj;
		if (comments == null) {
			if (other.comments != null) {
				return false;
			}
		} else if (!comments.equals(other.comments)) {
			return false;
		}
		if (content == null) {
			if (other.content != null) {
				return false;
			}
		} else if (!content.equals(other.content)) {
			return false;
		}
		if (tags == null) {
			if (other.tags != null) {
				return false;
			}
		} else if (!tags.equals(other.tags)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!author.equals(other.author)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Post [title=" + title + ", content=" + content + ", author=" + author + ", comments=" + comments + ", tags=" + tags + "]";
	}
}
