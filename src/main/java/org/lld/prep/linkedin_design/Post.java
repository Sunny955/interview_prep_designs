package org.lld.prep.linkedin_design;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Post {
    private final long postId;
    private final User postedBy;
    private final String post;
    private final Set<String> taggedUsers;
    private final Date timeStamp;

    public Post(long postId, User postedBy, String post, Set<String> taggedUsers, Date timeStamp) {
        this.postId = postId;
        this.postedBy = postedBy;
        this.post = post;
        this.taggedUsers = taggedUsers;
        this.timeStamp = timeStamp;
    }

    public long getPostId() {
        return postId;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public String getPost() {
        return post;
    }

    public Set<String> getTaggedUsers() {
        return new HashSet<>(taggedUsers);
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postedBy=" + postedBy +
                ", post='" + post + '\'' +
                ", taggedUsers=" + taggedUsers +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
