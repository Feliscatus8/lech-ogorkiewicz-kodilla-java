package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> userList= new ArrayList<>();
    public Forum(){
        this.userList.add(new ForumUser(1, "CatLover", 'M', LocalDate.of(1984, 5, 25), 512));
        this.userList.add(new ForumUser(2, "TigerLover", 'F', LocalDate.of(1974, 5, 25), 8));
        this.userList.add(new ForumUser(3, "PallasCatLover", 'M', LocalDate.of(1994, 5, 25), 4));
        this.userList.add(new ForumUser(4, "EuropeanWildcatLover", 'F', LocalDate.of(2004, 5, 25), 2));
        this.userList.add(new ForumUser(5, "AfricanWildcatLover", 'M', LocalDate.of(1997, 5, 25), 0));
        this.userList.add(new ForumUser(6, "LeopardLover", 'F', LocalDate.of(1986, 5, 25), 32));
        this.userList.add(new ForumUser(7, "SnowPantherLover", 'M', LocalDate.of(1991, 5, 25), 64));
        this.userList.add(new ForumUser(8, "LionLover", 'F', LocalDate.of(2007, 5, 25), 128));
        this.userList.add(new ForumUser(9, "MountainLionLover", 'M', LocalDate.of(2003, 5, 25), 16));
        this.userList.add(new ForumUser(10, "MarbledCatLover", 'F', LocalDate.of(1972, 5, 25), 256));
    }
    public List<ForumUser> getList(){return new ArrayList<>(this.userList);}
}
