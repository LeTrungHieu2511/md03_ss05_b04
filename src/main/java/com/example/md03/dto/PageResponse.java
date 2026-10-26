package com.example.md03.dto;

import java.util.List;

public class PageResponse<T> {
    private List<T> items;
    private int page;
    private int size;
    private long totalItems;
    private int totalPages;
    private boolean last;

    public PageResponse(List<T> items, int page, int size, long totalItems, int totalPages, boolean last) {
        this.items = items;
        this.page = page;
        this.size = size;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
        this.last = last;
    }

    public List<T> getItems() { return items; }
    public int getPage() { return page; }
    public int getSize() { return size; }
    public long getTotalItems() { return totalItems; }
    public int getTotalPages() { return totalPages; }
    public boolean isLast() { return last; }
}