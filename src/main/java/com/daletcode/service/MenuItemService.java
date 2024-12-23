package com.daletcode.service;

import com.daletcode.dto.MenuItemRequest;
import com.daletcode.dto.MenuItemResponse;

import java.util.List;

public interface MenuItemService {

    MenuItemResponse create(MenuItemRequest menuItemRequest);
    MenuItemResponse update(Long id, MenuItemRequest menuItemRequest);
    void delete(Long id);
    MenuItemResponse getById(Long id);
    List<MenuItemResponse> getAll();
}
