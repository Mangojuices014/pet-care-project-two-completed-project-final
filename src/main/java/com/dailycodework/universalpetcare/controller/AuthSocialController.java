package com.dailycodework.universalpetcare.controller;

import com.dailycodework.universalpetcare.config.GooglePojo;
import com.dailycodework.universalpetcare.enums.ETypeAccount;
import com.dailycodework.universalpetcare.enums.Gender;
import com.dailycodework.universalpetcare.model.Role;
import com.dailycodework.universalpetcare.model.User;
import com.dailycodework.universalpetcare.repository.RoleRepository;
import com.dailycodework.universalpetcare.repository.UserRepository;
import com.dailycodework.universalpetcare.security.jwt.JwtUtils;
import com.dailycodework.universalpetcare.service.role.IRoleService;
import com.dailycodework.universalpetcare.utils.FacebookUtils;
import com.dailycodework.universalpetcare.utils.GoogleUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.hc.client5.http.ClientProtocolException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class AuthSocialController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final GoogleUtils googleUtils;
    private final PasswordEncoder encoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final IRoleService roleService;
    private final FacebookUtils facebookUtils;

    @RequestMapping(value = "/oauth2/google")
    public RedirectView loginGoogle(HttpServletRequest request) throws ClientProtocolException, IOException {
        String code = request.getParameter("code");
        if (code == null || code.isEmpty()) {
            return new RedirectView("http://localhost:5174/oauth2/redirect?status=false");
        }
        ObjectMapper mapper = new ObjectMapper();
        String token = googleUtils.getToken(code);
        JsonNode node = mapper.readTree(token);
        String accessToken = node.get("access_token").textValue();
        GooglePojo googlePojo = null;
        if (accessToken != null) {
            googlePojo = googleUtils.getUserInfo(accessToken);
        }

        UserDetails userDetail = googleUtils.buildUser(googlePojo);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
                userDetail.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepository.findOneByEmail(userDetail.getUsername());
        if (user == null) {
            user = new User();
            user.setEnabled(true);
            user.setEmail(googlePojo.getEmail());
            user.setUsername(googlePojo.getEmail());
            user.setLastName(googlePojo.getFamily_name());
            user.setFirstName(googlePojo.getGiven_name());
            if (user.getGender() != null) {
                user.setGender(Gender.valueOf(String.valueOf(googlePojo.getGender()).toUpperCase())); // Chuyển đổi từ String sang Enum
            } else {
                user.setGender(Gender.HIDE);  // Nếu không có gender, mặc định là OTHER
            }
            user.setPhoneNumber(googlePojo.getPhone_number());
            user.setPassword(encoder.encode(googlePojo.getSocial_user_id()));
            user.setFullName(googlePojo.getName());
            user.setUserType("PATIENT");
            user.setType_account(ETypeAccount.GOOGLE);
            Set<Role> roles = new HashSet<>();
            Role userRole = roleRepository.findByName("ROLE_PATIENT")
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
            roles.add(userRole);
            user.setRoles(roles);
            userRepository.save(user);
        }
        Authentication authen = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), googlePojo.getSocial_user_id()));
        String jwt = jwtUtils.generateTokenForUser(authen);
        return new RedirectView(
                "http://localhost:5174/oauth2/redirect?status=true&token=" + jwt + "&username=" + user.getEmail());
    }

        @RequestMapping("/oauth2/facebook")
        public RedirectView loginFacebook(HttpServletRequest request) throws ClientProtocolException, IOException {
            String code = request.getParameter("code");

            if (code == null || code.isEmpty()) {
                return new RedirectView("http://localhost:5174/oauth2/redirect?status=false");
            }
            ObjectMapper mapper = new ObjectMapper();
            String token = facebookUtils.getToken(code);
            JsonNode node = mapper.readTree(token);
            String accessToken = node.get("access_token").textValue();
            com.restfb.types.User user = facebookUtils.getUserInfo(accessToken);
            System.out.println("First Name: " + user.getFirstName());
            System.out.println("Last Name: " + user.getLastName());
            System.out.println("Gender: " + user.getGender());
            System.out.println(user); // Kiểm tra dữ liệu trả về từ Facebook
            UserDetails userDetail = facebookUtils.buildUser(user);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
                    userDetail.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            User userEntity = userRepository.findOneByUsername(userDetail.getUsername());
            if (userEntity == null) {
                userEntity = new User();
                userEntity.setEnabled(true);
                StringBuilder str = new StringBuilder();
                str.append(user.getId());
                str.reverse();
                String randomemail = "facebook-" + str + "@yopmail.com";
                if (user.getEmail() != null) {
                    userEntity.setEmail(user.getEmail());
                } else {
                    userEntity.setEmail(randomemail);
                }
                userEntity.setUsername(user.getId());
                userEntity.setFullName(user.getLastName()+user.getFirstName());
                userEntity.setLastName(user.getLastName());
                userEntity.setFirstName(user.getFirstName());
                if (user.getGender() != null) {
                    userEntity.setGender(Gender.valueOf(user.getGender().toUpperCase())); // Chuyển đổi từ String sang Enum
                } else {
                    userEntity.setGender(Gender.HIDE);  // Nếu không có gender, mặc định là OTHER
                }

                userEntity.setPhoneNumber("N/A");
                userEntity.setPassword(encoder.encode(user.getId()));
                userEntity.setType_account(ETypeAccount.FACEBOOK);
                userEntity.setUserType("PATIENT");
                List<Role> roles = new ArrayList<Role>();
                Role userRole = roleRepository.findByName("ROLE_PATIENT")
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                roles.add(userRole);
                userEntity.setRoles(roles);

                userRepository.save(userEntity);
            }
            String username = userEntity.getUsername();
            Authentication authen = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, username));
            String jwt = jwtUtils.generateTokenForUser(authen);
            return new RedirectView("http://localhost:5174/oauth2/redirect?status=true&token=" + jwt + "&username="
                    + userEntity.getUsername());
        }

}
