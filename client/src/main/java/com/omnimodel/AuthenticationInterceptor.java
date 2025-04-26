package com.omnimodel;

/**
 * OkHttp Interceptor that adds an authorization token header
 * 
 * @deprecated Use {@link com.omnimodel.client.AuthenticationInterceptor}
 */
@Deprecated
public class AuthenticationInterceptor extends com.omnimodel.client.AuthenticationInterceptor {

    AuthenticationInterceptor(String token) {
        super(token);
    }

}
