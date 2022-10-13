package com.kodilla.patterns.prototype;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Board extends Prototype<Board> {
    private String name;
    private Set<TaskList> lists = new HashSet<>();

    public Board(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLists(Set<TaskList> lists) {
        this.lists = lists;
    }

    public Set<TaskList> getLists() {
        return lists;
    }

    @Override
    public String toString() {
        String s = "Board [" + name + "]\n";
        for (TaskList list : lists) {
            s = s + list.toString() + "\n";
        }
        return s;
    }

    public Board shallowCopy() throws  CloneNotSupportedException {
        return super.clone();
    }

    public Board deepCopy() throws CloneNotSupportedException {
        Board clonedBoard = super.clone();
        clonedBoard.lists = new HashSet<>();
        for (TaskList theList: lists) {
            TaskList clonedList = new TaskList(theList.getName());
            for (Task task : theList.getTasks()) {
                clonedList.getTasks().add(task);
            }
            clonedBoard.getLists().add(clonedList);
        }
        return clonedBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        if (!Objects.equals(name, board.name)) return false;
        return lists != null ? lists.equals(board.lists) : board.lists == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lists != null ? lists.hashCode() : 0);
        return result;
    }
}
