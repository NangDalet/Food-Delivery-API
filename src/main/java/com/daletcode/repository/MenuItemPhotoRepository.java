package com.daletcode.repository;

import com.daletcode.model.MenuItemPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MenuItemPhotoRepository extends JpaRepository<MenuItemPhoto,Long> {

    List<MenuItemPhoto> findAllByIdIn(Set<Long> ids);

}
