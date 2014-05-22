package org.avm.common.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.avm.common.domain.Comment;
import org.avm.common.domain.Post;
import org.joda.time.DateTime;

public class PostService extends ItemService<Post> {

	private static final String[] TITLE_LIST = new String[] { "Curabitur lacinia pellentesque", "Just Another Blog Title", "My Third Test Post Title" };

	static final String[][] TAG_LIST = new String[][] { { "test", "sapien", "lacus" }, { "scrum", "agile", "values" }, { "test", "title", "post" } };

	private static final String[] COMMENT_LIST = new String[] { "I just want to comment as much as I want and your blog is shit.",
			"We love your blog. It's great. Best info ever. xo xo",
			"Sed sit amet pede in justo ultrices elementum. Nulla laoreet rhoncus neque. Ut nec sapien. Cum sociis natoque",
			"All twenty of its short-lived 2009-2010 run are currently on Netflix Instant. Good timing too, as the series has seen a bit of a renaissance as of lately." };

	private static final String[] CONTENT_LIST = new String[] {
			"<p> Sed sit amet pede in justo ultrices elementum. Nulla laoreet rhoncus neque. Ut nec sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. </p>"
					+ "<p> Suspendisse potenti. Ut aliquet, ligula a ultrices pellentesque, tellus augue convallis est, quis viverra sapien metus non sapien. Fusce sed orci. Vestibulum tellus nisl, venenatis commodo, molestie ut, tempor sollicitudin, ligula. Curabitur euismod lacinia lorem. Nulla gravida tincidunt mi. Nunc porta ipsum quis nulla. Aliquam erat volutpat. </p>"
					+ "<p> Ut eros risus, sodales eget, fermentum vitae, euismod eu, lacus. Ut congue metus nec quam. Nunc ligula tellus, feugiat ac, lobortis id, semper ac, nisl. In ac pede. Proin in felis eget sem volutpat commodo. Phasellus ac est vel sem accumsan bibendum. Mauris pretium. Cras nec tellus. Vestibulum at eros non erat adipiscing malesuada. Proin elementum est quis risus. </p>"
					+ "<p> Suspendisse potenti. Ut aliquet, ligula a ultrices pellentesque, tellus augue convallis est, quis viverra sapien metus non sapien. Fusce sed orci. Vestibulum tellus nisl, venenatis commodo, molestie ut, tempor sollicitudin, ligula. Curabitur euismod lacinia lorem. Nulla gravida tincidunt mi. Nunc porta ipsum quis nulla. Aliquam erat volutpat. </p>"
					+ "<p> Ut eros risus, sodales eget, fermentum vitae, euismod eu, lacus. Ut congue metus nec quam. Nunc ligula tellus, feugiat ac, lobortis id, semper ac, nisl. In ac pede. Proin in felis eget sem volutpat commodo. Phasellus ac est vel sem accumsan bibendum. Mauris pretium. Cras nec tellus. Vestibulum at eros non erat adipiscing malesuada. Proin elementum est quis risus. </p>",
			"<p>Sadly, some of the greatest shows are ones that find their audience too little too late. Some include \"Arrested Development,\" \"Veronica Mars,\" both Joss Whedon's \"Firefly\" and \"Dollhouse\" and another series among them is the Starz Network's <strong>\"Party Down\"</strong>, co-created by <strong>Paul Rudd</strong> and \"Mars\" creator <strong>Rob Thomas</strong> and starring <strong>Adam Scott</strong>, <strong>Martin Starr</strong>, <strong>Jane Lynch</strong>, and <strong>Lizzy Caplan</strong>. Like its fellow doomed series, \"Party Down\" <a href=\"http://www.firstshowing.net/2011/canceled-party-down-tv-series-may-find-life-again-in-feature-film/\">has been promised to return in film form</a> but just like many of the series in the same boat, has failed to come to fruition. However, Scott says that could actually change next summer. </p>"
					+ "<p>In speaking with <a href=\"http://blogs.indiewire.com/theplaylist/archives/adam_scott_says_party_down_movie_will_shoot_next_summer_if_schedules_can_be\">The Playlist</a> at TIFF - where Scott is for his film <a href=\"http://www.firstshowing.net/2011/video-blog-vigalondos-extraterrestre-westfeldts-friends-with-kids/\"><em>Friends with Kids</em></a> -  the actor seemed optimistic about a \"Party Down\" movie happening as soon as this time next year. Here's what Scott had to say:</p>"
					+ "<blockquote><p>\"We're like <strong>90% there</strong>, we're hoping to do it <strong>maybe next summer</strong>, if everyone's schedules work out and the guys get time to write a script. They have kind of a <strong>skeleton of a story worked out</strong> so we know where it's going to go but we just have to kind of cross the t's and dot the i's, or something. But Starz are being super cool and they're going to let us do it, and we're all excited, we all want to do it.\"</p></blockquote>"
					+ "<p>Being a big \"Party Down\" fan myself, this news obviously excites me though I'm trying not to get my hopes up too much. Have we not learned anything from the <a href=\"http://www.firstshowing.net/2010/will-arnett-says-arrested-development-movie-to-shoot-this-year/\">longtime back-and-forth of the \"Arrested Development\" film</a>? Until the camera is rolling and the cast shows up for that first morning of production to once again don those pink bow-ties and take us with them on their adventures of catering weird LA-area functions, then I will be forced to still draw my satisfaction from those two glorious seasons they gave us only to quickly leave us. .</p>"
					+ "<p>And if you've never seen a single episode out of those two seasons, you're in luck! All twenty of its short-lived 2009-2010 run are currently on Netflix Instant. Good timing too, as the series has seen a bit of a renaissance as of lately, seeing both <a href=\"http://drafthouse.com/movies/ultimate_party_down_marathon/austin\">a full marathon and live reunion</a> at the Alamo Drafthouse in June and <a href=\"http://www.youtube.com/watch?v=uOtx0O-H_7w\">a televised one on Adult Swim's \"Children's Hospital\"</a>. Hopefully, with Starz seeing there is an audience of devoted \"Party Downers\" out there and the show having a bit of a second life, we'll see a \"Party Down\" movie get down and party after all.</p>",
			"The shortest post ever" };

	private static final String[] AUTHOR_LIST = new String[] { "Admin", "Scrum", "John Doe" , "Michael J." };

	private static Post[] POST_LIST = new Post[3];

	static {
		List<Comment> comments = new ArrayList<Comment>();

		for (int i = 0; i < COMMENT_LIST.length; i++) {
			Comment comment = new Comment();
			comment.setId(i + 1);
			comment.setDateCreate(new DateTime(2012, i + 1, i + 1, i + 1, i + 1, i + 1, i + 1));
			comment.setAuthor(AUTHOR_LIST[i]);
			comment.setContent(COMMENT_LIST[i]);
			comments.add(comment);
		}

		for (int i = 0; i < POST_LIST.length; i++) {
			POST_LIST[i] = new Post();
			POST_LIST[i].setId(i);
			POST_LIST[i].setDateCreate(new DateTime(2012, i + 1, i + 1, i + 1, i + 1, i + 1, i + 1));
			POST_LIST[i].setTitle(TITLE_LIST[i]);
			POST_LIST[i].setContent(CONTENT_LIST[i]);
			POST_LIST[i].setAuthor(AUTHOR_LIST[i]);
			POST_LIST[i].setTags(Arrays.asList(TAG_LIST[i]));

			POST_LIST[i].setComments(comments);

		}
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		super.delete(id);
	}

	@Override
	public void save(Post bean) {
		// TODO Auto-generated method stub
		super.save(bean);
	}

	@Override
	public Collection<Post> findAll() {
		// TODO Replace this mock
		return Arrays.asList(POST_LIST);
	}

	@Override
	public Post findById(Integer id) {
		return POST_LIST[id];
	}

	public Set<String> findAllTags() {
		TreeSet<String> result = new TreeSet<String>();
		result.add("all");
		for (int j = 0; j < PostService.TAG_LIST.length; j++) {
			result.addAll(Arrays.asList(PostService.TAG_LIST[j]));
		}
		return result;
	}

	public List<Post> findByTag(String tag) {
		List<Post> posts = new ArrayList<Post>();
		for (int i = 0; i < TAG_LIST.length; i++) {
			for (int j = 0; j < TAG_LIST[i].length; j++) {
				if (TAG_LIST[i][j].equals(tag)) {
					posts.add(POST_LIST[i]);
				}
			}
		}
		return posts;
	}

	public Post findByLink(String value) {
		if ("all".equals(value)) {
			return null;
		}
		String[] strings = value.split("_");
		Integer id = Integer.valueOf(strings[strings.length - 1]);
		return POST_LIST[id];
	}

	public Collection<Post> findByAuthor(String author) {
		List<Post> posts = new ArrayList<Post>();
		for (int i = 0; i < AUTHOR_LIST.length; i++) {
			if (AUTHOR_LIST[i].equals(author)) {
				posts.add(POST_LIST[i]);
			}
		}
		return posts;
	}
}
