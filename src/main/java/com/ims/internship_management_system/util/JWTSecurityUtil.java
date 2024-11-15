package com.ims.internship_management_system.util;


import com.ims.internship_management_system.configs.security.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public final class JWTSecurityUtil {
    public static Optional<UserPrincipal> getJWTUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication && null != authentication.getDetails()) {
            Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return object instanceof UserPrincipal ? Optional.of((UserPrincipal) object) : Optional.empty();
        } else {
            return Optional.empty();
        }
    }

    private JWTSecurityUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}