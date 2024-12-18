package com.dailycodework.universalpetcare.utils;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import lombok.RequiredArgsConstructor;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class FacebookUtils {

    private final Environment env;

    public String getToken(final String code)
            throws ClientProtocolException, IOException {
        String link = String.format(Objects.requireNonNull(env.getProperty("facebook.link.get.token")),
                env.getProperty("facebook.app.id"),
                env.getProperty("facebook.app.secret"),
                env.getProperty("facebook.redirect.uri"),
                code);
        String response = Request.Get(link).execute().returnContent().asString();
        return response;
    }

    public com.restfb.types.User getUserInfo(final String accessToken) {
        FacebookClient facebookClient = new DefaultFacebookClient(accessToken, env.getProperty("facebook.app.secret"), Version.LATEST);
        // Lấy các trường first_name, last_name, gender, email từ Facebook
        return facebookClient.fetchObject("me", com.restfb.types.User.class, Parameter.with("fields", "first_name,last_name,gender"));
    }


    public UserDetails buildUser(com.restfb.types.User user) {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_PATIENT"));
//		System.out.println(user.getEmail());
        UserDetails userDetail = new User(user.getId(), "", enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities);
        return userDetail;
    }

}
