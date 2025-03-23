package org.lld.prep.linkedin_design;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        LinkedIn linkedIn = new LinkedIn();

        linkedIn.addUser("u1","Jain");
        linkedIn.addUser("u2","Hindu");
        linkedIn.addUser("u3","Muslim");

        linkedIn.followUser("u1", "u2"); // u1 follows u2
        linkedIn.followUser("u1", "u3");
        linkedIn.followUser("u3", "u2");

        linkedIn.createPost("u2", "Hello from Bob!", new HashSet<>(Arrays.asList("u1", "u3"))); // Bob tags Alice & Charlie
        linkedIn.createPost("u3", "Charlie here!", new HashSet<>(Collections.singleton("u1")));

        // Fetch data
        System.out.println("U1 Posts: " + linkedIn.getAllPosts("u1"));
        System.out.println("U2 followers: " + linkedIn.getFollowers("u2"));
        System.out.println("U1 followings: " + linkedIn.getFollowings("u1"));
        System.out.println("U1 relevant posts: " + linkedIn.getRelevantPost("u1"));
        System.out.println("Posts Mentioning U1: " + linkedIn.getPostsMentioningUser("u1"));
    }
}
