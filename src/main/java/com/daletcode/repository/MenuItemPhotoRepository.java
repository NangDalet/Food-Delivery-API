package com.daletcode.repository;

import com.daletcode.model.MenuItemPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemPhotoRepository extends JpaRepository<MenuItemPhoto,Long> {
}
