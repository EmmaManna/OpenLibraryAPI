package ehu.isad;

import java.util.Arrays;

public class Details {
    private String subtitle = "";
    private String title;
    private String[] publishers;
    private int number_of_pages;

    @Override
    public String toString() {
        return "Details{" +
                "subtitle='" + subtitle + '\'' +
                ", title='" + title + '\'' +
                ", publishers=" + Arrays.toString(publishers) +
                ", number_of_pages=" + number_of_pages +
                '}';
    }

    public Details(){}

    public String getSubtitle() {
        return subtitle;
    }

    public String getTitle() {
        return title;
    }

    public String[] getPublishers() {
        return publishers;
    }

    public int getNumber_of_pages() {
        return number_of_pages;
    }
}
