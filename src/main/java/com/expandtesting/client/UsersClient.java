package com.expandtesting.client;

import com.expandtesting.models.request.GetTokenRequestFormParams;
import com.expandtesting.models.response.gettoken.GetTokenResponse;
import io.restassured.http.ContentType;
import io.restassured.http.Header;

import static com.expandtesting.data.enums.HttpHeaders.CONTENT_TYPE;
import static com.expandtesting.data.EndpointsRoutes.login;

public class UsersClient extends BaseClient {

    public String getToken(GetTokenRequestFormParams getTokenRequestParams) {
        postWithFormParams(login(), getTokenRequestParams,
                new Header(CONTENT_TYPE.getHeaderName(), ContentType.URLENC.withCharset("UTF-8")));
        return getResponse().as(GetTokenResponse.class).getData().getToken();
    }
}
