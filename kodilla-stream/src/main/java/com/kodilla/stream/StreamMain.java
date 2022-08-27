package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args){
        System.out.println("7.3 ForumUsers filtering\n");
        Forum forum = new Forum();
        Map<Integer, ForumUser> userMap = forum.getList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> user.getDateOfBirth().plusYears(20).isBefore(LocalDate.now()))
                .filter(user -> user.getPostCount() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));

        userMap.entrySet().stream()
                .forEach(System.out::println);

        System.out.println("\n7.1 Poem beautifier\n");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("This is an example text", (text) -> "ABC " + text + " ABC");
        poemBeautifier.beautify("This is an example text", (text) -> text.toUpperCase());
        poemBeautifier.beautify("This is an example text", (text) -> text.replace('s', 'n'));
        poemBeautifier.beautify("This is an example text", (text) -> text.replaceAll("text", "meow"));
    }
}