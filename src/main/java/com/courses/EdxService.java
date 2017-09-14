package com.courses;

import com.courses.bean.EdxCourse;
import com.courses.bean.ResponseWithPagination;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

public class EdxService {
    private static final String apiReference = "https://courses.edx.org/api/courses/v1/courses/";
    private static final ObjectMapper mapper = new ObjectMapper();
    private Gson gson = new Gson();

    public Set<EdxCourse> getCourseList() throws IOException, URISyntaxException {
        ResponseWithPagination<EdxCourse> page;
        Set<EdxCourse> courses = new HashSet<>();
        do {
            page = getCoursePage();
            courses.addAll(page.getResults());
        } while(StringUtils.isNotEmpty(page.getPagination().getNext()));

        System.out.printf("");
        return courses;
    }

    private ResponseWithPagination<EdxCourse>  getCoursePage() throws URISyntaxException, IOException {
        return gson
                .fromJson(IOUtils.toString(new URI(apiReference), "UTF-8"),
                        new TypeToken<ResponseWithPagination<EdxCourse>>(){}.getType());
    }

}
