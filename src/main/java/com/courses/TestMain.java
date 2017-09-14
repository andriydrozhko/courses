package com.courses;

import java.io.IOException;
import java.net.URISyntaxException;

public class TestMain {
    public static void main(String...args) {
        EdxService edxService = new EdxService();
        try {
            edxService.getCourseList();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
