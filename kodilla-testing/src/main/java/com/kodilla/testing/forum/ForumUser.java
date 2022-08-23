package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ForumUser {
    private String name;
    private String realName;
    private List<ForumPost> posts = new ArrayList<>();
    private List<ForumComment> comments = new LinkedList<>();

    public ForumUser(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }
    public void addPost(String author, String postBody){
        this.posts.add(new ForumPost(postBody, author));
    }
    public void addComment(ForumPost thePost, String author, String commentBody){
        this.comments.add(new ForumComment(thePost, commentBody, author));
    }
    public int getPostsQuantity(){
        return this.posts.size();
    }
    public int getCommentsQuantity(){
        return this.comments.size();
    }
    public ForumPost getPost(int postNumber){
        if(postNumber >= 0 && postNumber < this.posts.size()) {
            return this.posts.get(postNumber);
        }
        return null;
    }
    public ForumComment getComment(int commentNumber){
        if(commentNumber >= 0 && commentNumber < this.comments.size()) {
            return this.comments.get(commentNumber);
        }
        return null;
    }
    public boolean removePost(ForumPost thePost){
        boolean result = false;
        if(this.posts.contains(thePost)){
            this.posts.remove(thePost);
            result = true;
        }
        return result;
    }
    public boolean removeComment(ForumComment theComment){
        boolean result = false;
        if(this.comments.contains(theComment)){
            this.comments.remove(theComment);
            result = true;
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}
