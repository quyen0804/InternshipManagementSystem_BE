package com.ims.internship_management_system.configs.security;



import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.model.UserEntity;
import com.ims.internship_management_system.repository.InternRepository;
import com.ims.internship_management_system.repository.MentorRepository;
import com.ims.internship_management_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.getUserEntityByAccount(username)
                .orElseThrow(() ->
                         new UsernameNotFoundException("User Not Found with -> username or email " +
                                 ": " + username)
                );

        return UserPrincipal.build(userEntity);
    }
}
