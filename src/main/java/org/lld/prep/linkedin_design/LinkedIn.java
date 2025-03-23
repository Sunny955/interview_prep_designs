package org.lld.prep.linkedin_design;

import java.util.*;

public class LinkedIn {
    private final Map<String, User> users = new HashMap<>();
    private final Map<User, List<Post>> userPosts = new HashMap<>();
    private final Map<User, Set<User>> followers = new HashMap<>();
    private final Map<User, Set<User>> followings = new HashMap<>();
    private final Map<String, List<Post>> mentions = new HashMap<>();

    public void addUser(String userId, String userName) {
        if(users.get(userId) != null) {
            return;
        }
        User u = new User(userId, userName);
        users.put(userId, u);
        userPosts.put(u, new ArrayList<>());
        followers.put(u, new HashSet<>());
        followings.put(u, new HashSet<>());
    }

    public void followUser(String followerId, String followingId) {
        User follower = users.get(followerId);
        User followee = users.get(followingId);

        if(follower != null && followee != null) {
            followers.get(followee).add(follower);
            followings.get(follower).add(followee);
        }
    }

    public void createPost(String userId, String content, Set<String> taggedUsers) {
        User author = users.get(userId);
        Random random = new Random();

        long randomLong = random.nextLong();

        if(author != null) {
            Post p = new Post(randomLong, author, content, taggedUsers, new Date());
            userPosts.get(author).add(p);

            for (String taggedUser : taggedUsers) {
                mentions.computeIfAbsent(taggedUser, k -> new ArrayList<>()).add(p);
            }
        }
    }

    public List<Post> getAllPosts(String userId) {
        User user = users.get(userId);

        if(user != null) {
            return userPosts.get(user);
        }
        return new ArrayList<>();
    }

    public Set<User> getFollowers(String userId) {
        User user = users.get(userId);

        if(user != null) {
            return followers.get(user);
        }
        return new HashSet<>();
    }

    public Set<User> getFollowings(String userId) {
        User user = users.get(userId);

        if(user != null) {
            return followings.get(user);
        }
        return new HashSet<>();
    }

    public List<Post> getRelevantPost(String userId) {
        User user = users.get(userId);

        if(user == null) {
            return new ArrayList<>();
        }

        Set<User> followingOfUser = followings.get(user);
        List<Post> relevantPosts = new ArrayList<>();

        for(User u: followingOfUser) {
            List<Post> posts = userPosts.get(u);

            relevantPosts.addAll(posts);
        }

        return relevantPosts;
    }

    public List<Post> getPostsMentioningUser(String userId) {
        return mentions.getOrDefault(userId, new ArrayList<>());
    }
}
