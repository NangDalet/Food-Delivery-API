package com.daletcode.service.handler;

import com.daletcode.constant.Constant;
import com.daletcode.dto.MenuItemPhotoRequest;
import com.daletcode.dto.MenuItemRequest;
import com.daletcode.dto.MenuItemResponse;
import com.daletcode.model.MenuItem;
import com.daletcode.model.MenuItemPhoto;
import com.daletcode.model.Restaurant;
import com.daletcode.repository.MenuItemPhotoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuItemHandlerService {

    private final MenuItemPhotoRepository menuItemPhotoRepository;

    public boolean verifyMenuItemPhoto(MenuItemRequest menuItemRequest) {
        // verify menu item photo
        // logic verify menu item photo will write here
        Set<Long> menuItemPhotoIds = menuItemRequest
                .getMenuItemPhotoRequests()
                .stream().map(MenuItemPhotoRequest::getId).
                collect(Collectors.toSet());

        List<MenuItemPhoto> menuItemPhotos = menuItemPhotoRepository.findAllByIdIn(menuItemPhotoIds);
        if(menuItemPhotos.isEmpty()) {
            log.info("Menu item photo not found");
            return false;
        }
        return true;
    }

    public MenuItem convertMenuItemRequestToMenuItem(MenuItemRequest menuItemRequest,
                                                     MenuItem menuItem, Restaurant restaurant) {
        menuItem.setName(menuItemRequest.getName());
        menuItem.setCode(menuItemRequest.getCode());
        menuItem.setPrice(menuItemRequest.getPrice());
        menuItem.setDescription(menuItemRequest.getDescription());
        menuItem.setAvailability(menuItemRequest.getAvailability());
        menuItem.setRestaurant(restaurant);
        if(menuItem.getId() == null) {
            menuItem.setUpdatedAt(new Date());
            menuItem.setUpdatedBy(Constant.SYSTEM);
        }

        return menuItem;
    }

    public MenuItemResponse convertMenuItemToMenuItemResponse(MenuItem menuItem) {
        return MenuItemResponse.builder()
                .id(menuItem.getId())
                .name(menuItem.getName())
                .code(menuItem.getCode())
                .price(menuItem.getPrice())
                .description(menuItem.getDescription())
                .availability(menuItem.getAvailability())
                .restaurantId(menuItem.getRestaurant().getId())
                .build();
    }
}