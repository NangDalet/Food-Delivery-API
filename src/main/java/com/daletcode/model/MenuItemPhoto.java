package com.daletcode.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name="tbl_menuItem_photo")
public class MenuItemPhoto extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String fileType;

    private String fileFormat;

    private double fileSize;

    private String fileName;

    private String smallUrl;

    private String mediumUrl;

    private String largeUrl;

    private String uploadBy;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    private MenuItem menuItem;

}
