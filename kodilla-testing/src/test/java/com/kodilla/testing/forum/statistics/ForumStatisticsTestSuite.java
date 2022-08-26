package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {
    @Mock
    private Statistics statisticsMock;
    static private ForumStatsCalculator forumStatsCalculator = new ForumStatsCalculator();
    private List<String> generateUserList(int number){
        List<String> userList = new ArrayList<>();
        for(int n = 0; n < number; n++){
            userList.add("User" + n);
        }
        return userList;
    }
    @BeforeEach
    public void beforeEachTest(){
        ForumStatsCalculator forumStatsCalculator = new ForumStatsCalculator();
    }

    @Test
    void testCalculateAdvStatisticsNoPosts(){
        //Given
        when(statisticsMock.userNames()).thenReturn(generateUserList(10));

        //When
        forumStatsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, forumStatsCalculator.getUsersCount());
        assertEquals(0, forumStatsCalculator.getPostCount());
        assertEquals(0, forumStatsCalculator.getCommentCount());
        assertEquals(0, forumStatsCalculator.getPostsPerUser());
        assertEquals(0, forumStatsCalculator.getCommentsPerUser());
        assertNull(forumStatsCalculator.getCommentsPerPost());
    }
    @Test
    void testCalculateAdvStatistics1000Posts(){
        //Given
        when(statisticsMock.userNames()).thenReturn(generateUserList(10));
        when(statisticsMock.postCount()).thenReturn(1000);
        when(statisticsMock.commentCount()).thenReturn(200);

        //When
        forumStatsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, forumStatsCalculator.getUsersCount());
        assertEquals(1000, forumStatsCalculator.getPostCount());
        assertEquals(200, forumStatsCalculator.getCommentCount());
        assertEquals(100, forumStatsCalculator.getPostsPerUser());
        assertEquals(20, forumStatsCalculator.getCommentsPerUser());
        assertEquals(0.2, forumStatsCalculator.getCommentsPerPost());
    }
    @Test
    void testCalculateAdvStatistics0Comments(){
        //Given
        when(statisticsMock.userNames()).thenReturn(generateUserList(10));
        when(statisticsMock.postCount()).thenReturn(1000);

        //When
        forumStatsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, forumStatsCalculator.getUsersCount());
        assertEquals(1000, forumStatsCalculator.getPostCount());
        assertEquals(0, forumStatsCalculator.getCommentCount());
        assertEquals(100, forumStatsCalculator.getPostsPerUser());
        assertEquals(0, forumStatsCalculator.getCommentsPerUser());
        assertEquals(0, forumStatsCalculator.getCommentsPerPost());
    }
    @Test
    void testCalculateAdvStatisticsMorePosts(){
        //Given
        when(statisticsMock.userNames()).thenReturn(generateUserList(50));
        when(statisticsMock.postCount()).thenReturn(1000);
        when(statisticsMock.commentCount()).thenReturn(800);

        //When
        forumStatsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(50, forumStatsCalculator.getUsersCount());
        assertEquals(1000, forumStatsCalculator.getPostCount());
        assertEquals(800, forumStatsCalculator.getCommentCount());
        assertEquals(20, forumStatsCalculator.getPostsPerUser());
        assertEquals(16, forumStatsCalculator.getCommentsPerUser());
        assertEquals(0.8, forumStatsCalculator.getCommentsPerPost());
    }
    @Test
    void testCalculateAdvStatisticsMoreComments(){
        //Given
        when(statisticsMock.userNames()).thenReturn(generateUserList(10));
        when(statisticsMock.postCount()).thenReturn(100);
        when(statisticsMock.commentCount()).thenReturn(2000);

        //When
        forumStatsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, forumStatsCalculator.getUsersCount());
        assertEquals(100, forumStatsCalculator.getPostCount());
        assertEquals(2000, forumStatsCalculator.getCommentCount());
        assertEquals(10, forumStatsCalculator.getPostsPerUser());
        assertEquals(200, forumStatsCalculator.getCommentsPerUser());
        assertEquals(20, forumStatsCalculator.getCommentsPerPost());
    }
    @Test
    void testCalculateAdvStatisticsNoUsers(){
        //When
        forumStatsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, forumStatsCalculator.getUsersCount());
        assertEquals(0, forumStatsCalculator.getPostCount());
        assertEquals(0, forumStatsCalculator.getCommentCount());
        assertNull(forumStatsCalculator.getPostsPerUser());
        assertNull(forumStatsCalculator.getCommentsPerUser());
        assertNull(forumStatsCalculator.getCommentsPerPost());
    }
    @Test
    void testCalculateAdvStatistics100Users(){
        //Given
        when(statisticsMock.userNames()).thenReturn(generateUserList(100));
        when(statisticsMock.postCount()).thenReturn(1000);
        when(statisticsMock.commentCount()).thenReturn(200);

        //When
        forumStatsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, forumStatsCalculator.getUsersCount());
        assertEquals(1000, forumStatsCalculator.getPostCount());
        assertEquals(200, forumStatsCalculator.getCommentCount());
        assertEquals(10, forumStatsCalculator.getPostsPerUser());
        assertEquals(2, forumStatsCalculator.getCommentsPerUser());
        assertEquals(0.2, forumStatsCalculator.getCommentsPerPost());
    }
    @Test
    void testShowStatistics(){
        //Given
        when(statisticsMock.userNames()).thenReturn(generateUserList(100));
        when(statisticsMock.postCount()).thenReturn(1000);
        when(statisticsMock.commentCount()).thenReturn(200);

        //When
        forumStatsCalculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals("100 users, 1000 posts, 200 comments, 10.0 posts per user, 2.0 comments per user, 0.2 comments per post",
                forumStatsCalculator.showStatistics());
    }
}
