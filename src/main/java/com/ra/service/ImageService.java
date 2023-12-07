package com.ra.service;

import com.ra.model.Images;

import java.util.List;

public interface ImageService {
    boolean save(Images images);
    List<Images> getImageByProductId(String productId);
}
