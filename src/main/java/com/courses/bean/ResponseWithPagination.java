package com.courses.bean;

import java.util.Collection;

public class ResponseWithPagination<T> {
    private Pagination pagination;
    private Collection<T> results;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Collection<T> getResults() {
        return results;
    }

    public void setResults(Collection<T> results) {
        this.results = results;
    }
}
