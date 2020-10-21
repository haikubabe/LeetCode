package Medium;

import java.util.*;

/**
 * Leetcode - #355
 */
public class Twitter
{
    private static class Tweet {
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
            this.next = null;
        }
    }

    private static class User {
        private int id;
        private Set<Integer> followees;
        private Tweet recentTweet;

        public User(int id) {
            this.id = id;
            this.followees = new HashSet<>();
            this.recentTweet = null;
        }

        public void follow(int followeeId) {
            followees.add(followeeId);
        }

        public void unfollow(int followeeId) {
            followees.remove(followeeId);
        }

        public void postTweet(int tweetId) {
            Tweet tweet = new Tweet(tweetId);
            tweet.next = recentTweet;
            this.recentTweet = tweet;
        }
    }

    private static int timestamp = 0;
    private Map<Integer, User> userMap;

    /** Initialize your data structure here. */
    public Twitter() {
        this.userMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId,user);
        }
        userMap.get(userId).postTweet(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users
     * who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeedList = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return newsFeedList;
        }
        PriorityQueue<Tweet> tweets = new PriorityQueue<>((o1, o2) -> o2.time - o1.time);
        User user = userMap.get(userId);
        if (user.recentTweet != null) {
            tweets.add(user.recentTweet);
        }
        Set<Integer> followees = user.followees;
        for (int f : followees) {
            User followeeUser = userMap.get(f);
            if (followeeUser.id != user.id && followeeUser.recentTweet != null) {
                tweets.add(followeeUser.recentTweet);
            }
        }
        int count = 0;
        while (!tweets.isEmpty() && count < 10) {
            Tweet latestTweet = tweets.poll();
            newsFeedList.add(latestTweet.id);
            count++;
            if (latestTweet.next != null) {
                tweets.add(latestTweet.next);
            }
        }
        return newsFeedList;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            userMap.put(followerId, user);
        }
        if (!userMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }

    public static void main(String[] args)
    {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        twitter.follow(1,1);
        System.out.println(twitter.getNewsFeed(1));
    }
}
