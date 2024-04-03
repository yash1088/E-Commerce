/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springBoot.Model;

import java.util.List;

/**
 *
 * @author Yash
 */

public class MyData {
    private boolean success;
    private int total_photos;
    private String message;
    private int offset;
    private int limit;
    private List<Photo> photos; 

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotal_photos() {
        return total_photos;
    }

    public void setTotal_photos(int total_photos) {
        this.total_photos = total_photos;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
    
    @Override
    public String toString() {
        return "MyData{" + "success=" + success + ", total_photos=" + total_photos + ", message=" + message + ", offset=" + offset + ", limit=" + limit + ", photos=" + photos + '}';
    }
}
