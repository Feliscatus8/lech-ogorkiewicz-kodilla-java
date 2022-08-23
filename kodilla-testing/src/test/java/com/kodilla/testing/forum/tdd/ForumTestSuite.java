package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

public class ForumTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests");
    }
    @AfterAll
    public static void afterAllTests(){
        System.out.println("All tests are finished.");
    }
    @BeforeEach
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Nested
    class PostTests{
        @Test
        void testAddPost(){
            //Given
            ForumUser forumUser = new ForumUser("Gollum", "Smeagol");
            //When
            forumUser.addPost("Gollum", "My Preciousss");
            //Then
            Assertions.assertEquals(1, forumUser.getPostsQuantity());
        }
        @Test
        void testGetPost(){
            //Given
            ForumUser forumUser = new ForumUser("Gollum", "Smeagol");
            ForumPost thePost = new ForumPost("My precious is lost!", "Gollum");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());
            //When
            ForumPost retrievedPost = forumUser.getPost(0);
            //Then
            Assertions.assertEquals(thePost, retrievedPost);
        }
        @Test
        void testRemovePostNotExisting(){
            //Given
            ForumUser forumUser = new ForumUser("Gollum", "Smeagol");
            ForumPost thePost = new ForumPost("My precious is lost!", "Gollum");
            //When
            boolean result = forumUser.removePost(thePost);
            //Then
            Assertions.assertFalse(result);
        }
        @Test
        void testRemovePost(){
            //Given
            ForumUser forumUser = new ForumUser("Gollum", "Smeagol");
            ForumPost thePost = new ForumPost("My precious is lost!", "Gollum");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());
            //When
            boolean result = forumUser.removePost(thePost);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getPostsQuantity());
        }
    }
    @Nested
    class CommentTests {
        @Test
        void testAddComment() {
            //Given
            ForumUser forumUser = new ForumUser("Gollum", "Smeagol");
            ForumPost thePost = new ForumPost("My precious is lost!", "Gollum");
            //When
            forumUser.addComment(thePost, "Gollum", "Nasty hobbitses");
            //Then
            Assertions.assertEquals(1, forumUser.getCommentsQuantity());
        }

        @Test
        void testGetComment() {
            //Given
            ForumUser forumUser = new ForumUser("Gollum", "Smeagol");
            ForumPost thePost = new ForumPost("My precious is lost!", "Gollum");
            ForumComment theComment = new ForumComment(thePost, "Nasty hobbitses", "Gollum");
            forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());
            //When
            ForumComment retrievedComment = forumUser.getComment(0);
            //Then
            Assertions.assertEquals(theComment, retrievedComment);
        }

        @Test
        void testRemoveCommentNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("Gollum", "Smeagol");
            ForumPost thePost = new ForumPost("My precious is lost!", "Gollum");
            ForumComment theComment = new ForumComment(thePost, "Nasty hobbitses", "Gollum");

            //When
            boolean result = forumUser.removeComment(theComment);
            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveComment() {
            //Given
            ForumUser forumUser = new ForumUser("Gollum", "Smeagol");
            ForumPost thePost = new ForumPost("My precious is lost!", "Gollum");
            ForumComment theComment = new ForumComment(thePost, "Nasty hobbitses", "Gollum");
            forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

            //When
            boolean result = forumUser.removeComment(theComment);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getCommentsQuantity());
        }
    }
}
