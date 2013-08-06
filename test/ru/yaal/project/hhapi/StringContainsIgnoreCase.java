package ru.yaal.project.hhapi;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class StringContainsIgnoreCase extends TypeSafeMatcher<String> {
    private String substring;

    public StringContainsIgnoreCase(String substring) {
        this.substring = substring;
    }

    @Factory
    public static Matcher<String> stringContainsIgnoreCase(String substring) {
        return new StringContainsIgnoreCase(substring);
    }

    @Override
    public boolean matchesSafely(String str) {
        return str.toUpperCase().contains(substring.toUpperCase());
    }

    public void describeTo(Description description) {
        description.appendText("not contains the substring (case is ignored): ");
        description.appendValue(substring);
    }

}


