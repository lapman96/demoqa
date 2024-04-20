package org.demoqa.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Properties;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PagePaths {
    private static final Properties properties = PropertiesLoader.getProperties();
    public static final String BASE_UI_URL = properties.getProperty("base_url");

    //Paths to Element pages
    public static final String TEXT_BOX_PAGE_URL = properties.getProperty("text_box_page_url");
    public static final String CHECKBOX_BOX_PAGE_URL = properties.getProperty("check_box_page_url");
}
