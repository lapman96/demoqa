package com.expandtesting.data;

import core.data.DataFromPropertyFiles;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PagePaths extends DataFromPropertyFiles {

    public static final String EXPAND_TESTING_BASE_UI_URL = properties.getProperty("expand_testing_ui_base_url");

    public static final String EXPAND_TESTING_LOGIN_PAGE = properties.getProperty("expand_testing_login_page_url");

    public static final String EXPAND_TESTING_MY_NOTES_PAGE_URL = properties.getProperty("expand_testing_my_notes_page_url");
}
