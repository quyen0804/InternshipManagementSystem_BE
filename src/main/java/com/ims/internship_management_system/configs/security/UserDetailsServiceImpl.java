package com.ims.internship_management_system.configs.security;



import com.ims.internship_management_system.model.InternEntity;
import com.ims.internship_management_system.repository.InternRepository;
import com.ims.internship_management_system.repository.MentorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final InternRepository internRepository;
    private final MentorRepository mentorRepository;

    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {

        InternEntity userEntity = internRepository.findInternEntityByAccount(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with -> username or email : " + username)
                );

        return UserPrincipal.build(userEntity);
    }
}
