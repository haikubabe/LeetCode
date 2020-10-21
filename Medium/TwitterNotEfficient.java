package Medium;

import java.util.*;

/**
 * Leetcode - #355
 * Not efficient solution
 */
public class TwitterNotEfficient
{
    private List<Tweet> tweets;
    private Map<Integer, Set<Integer>> followees;

    private static class Tweet {

        private int userId;
        private int tweetId;

        public Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }

    public TwitterNotEfficient() {
        this.tweets = new ArrayList<>();
        this.followees = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(userId, tweetId);
        tweets.add(tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        Set<Integer> followees = null;
        if (this.followees.containsKey(userId)) {
            followees = this.followees.get(userId);
        }
        for (int i=tweets.size()-1, count=0; i>=0 && count<10; i--) {
            Tweet tweet = tweets.get(i);
            if (tweet.userId == userId || followees != null && followees.contains(tweet.userId)) {
                newsFeed.add(tweet.tweetId);
                count++;
            }
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> followees = new HashSet<>();
        if (this.followees.containsKey(followerId)) {
            followees = this.followees.get(followerId);
        }
        followees.add(followeeId);
        this.followees.put(followerId, followees);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followees.containsKey(followerId)) {
            Set<Integer> followees = this.followees.get(followerId);
            followees.remove(followeeId);
            this.followees.put(followerId, followees);
        }
    }

    public static void main(String[] args)
    {
        TwitterNotEfficient twitterNotEfficient = new TwitterNotEfficient();
        twitterNotEfficient.postTweet(1, 5);
        twitterNotEfficient.postTweet(2, 3);
        twitterNotEfficient.postTweet(1, 101);
        twitterNotEfficient.postTweet(2, 13);
        twitterNotEfficient.postTweet(2, 10);
        twitterNotEfficient.postTweet(1, 2);
        twitterNotEfficient.postTweet(1, 94);
        twitterNotEfficient.postTweet(2, 505);
        twitterNotEfficient.postTweet(1, 333);
        twitterNotEfficient.postTweet(2, 22);
        twitterNotEfficient.postTweet(1, 11);
        twitterNotEfficient.postTweet(1, 205);
        twitterNotEfficient.postTweet(2, 203);
        twitterNotEfficient.postTweet(1, 201);
        twitterNotEfficient.postTweet(2, 213);
        twitterNotEfficient.postTweet(1, 200);
        twitterNotEfficient.postTweet(2, 202);
        twitterNotEfficient.postTweet(1, 204);
        twitterNotEfficient.postTweet(2, 208);
        twitterNotEfficient.postTweet(2, 233);
        twitterNotEfficient.postTweet(1, 222);
        twitterNotEfficient.postTweet(2, 211);
        System.out.println(twitterNotEfficient.getNewsFeed(1));
        twitterNotEfficient.follow(1, 2);
        System.out.println(twitterNotEfficient.getNewsFeed(1));
        twitterNotEfficient.unfollow(1, 2);
        System.out.println(twitterNotEfficient.getNewsFeed(1));
    }
}
