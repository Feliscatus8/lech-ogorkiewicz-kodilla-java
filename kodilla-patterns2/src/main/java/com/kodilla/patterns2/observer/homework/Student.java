package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.forum.Observer;

public interface Student {
    void registerObserver(Teacher teacher);
    void notifyObservers();
    void removeObserver(Teacher teacher);
}
