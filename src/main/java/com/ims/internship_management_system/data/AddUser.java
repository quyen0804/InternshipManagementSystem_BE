package com.ims.internship_management_system.data;

import com.ims.internship_management_system.constant.Role;
import com.ims.internship_management_system.model.MentorEntity;
import com.ims.internship_management_system.repository.MentorRepository;
import com.ims.internship_management_system.service.InternService;
import com.ims.internship_management_system.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AddUser implements CommandLineRunner {
    private final MentorService mentor;
    private final InternService intern;


    @Override
    public void run(String... args) throws Exception {
//        List<UserEntity> userEntityList= List.of(
//                new UserEntity("user1@gmail.com", "User 1", "1", "111111111111", "1111111111", true, LocalDate.of(2001,01,01),"VN", 1,1),
//                new UserEntity("user2@gmail.com", "User 2", "2", "222222222222", "2222222222", false, LocalDate.of(2002,02,02),"NY", 0,1)
//                );
//        userRepository.saveAll(userEntityList);
//
        List<MentorEntity> mentorEntityList = List.of(

//                new MentorEntity("duyvd4","duyvd4@fpt.com", "1234",
//                        "Tran Nguyen Thinh", "0123456789", true, LocalDate.of(1999,01,01),
//                        "Ha Noi, VN", "111111111111", Role.MENTOR, "FHN.DNA"),
//                new MentorEntity("thinhtn8","thinhtn8@fpt.com", "1234",
//                        "Vu Duc Duy", "1234567890", true, LocalDate.of(2000,01,01),
//                        "Ha Noi, VN", "000000000000", Role.MENTOR, "FHN.DNA")


        );
        for(MentorEntity mentorEntity : mentorEntityList){
            mentor.createMentor(mentorEntity);
        }
    }
}
