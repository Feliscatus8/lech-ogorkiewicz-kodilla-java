package com.kodilla.testing.forum.statistics;

public class ForumStatsCalculator {
    private int usersCount;
    private int postCount;
    private int commentCount;
    private Double postsPerUser;
    private Double commentsPerUser;
    private Double commentsPerPost;

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostCount() {
        return postCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public Double getPostsPerUser() {
        return postsPerUser;
    }

    public Double getCommentsPerUser() {
        return commentsPerUser;
    }

    public Double getCommentsPerPost() {
        return commentsPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics){
        this.usersCount = statistics.userNames().size();
        this.postCount = statistics.postCount();
        this.commentCount = statistics.commentCount();
        if(this.usersCount != 0){
            this.postsPerUser = (double)this.postCount / this.usersCount;
            this.commentsPerUser = (double)this.commentCount / this.usersCount;
        }else{
            this.postsPerUser = null;
            this.commentsPerUser = null;
        }
        if (this.postCount != 0){
            this.commentsPerPost = (double)this.commentCount / this.postCount;
        }else this.commentsPerPost = null;
    }
    public String showStatistics(){
        return this.usersCount + " users, " + this.postCount + " posts, " + this.commentCount + " comments, " +
                this.postsPerUser + " posts per user, " + this.commentsPerUser + " comments per user, " +
                this.commentsPerPost + " comments per post";
    }
}
