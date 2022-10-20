package ru.ifellow_180surveybot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Contact;

@RequiredArgsConstructor
@Service
public class UserService {
//
//    private final UserRepository userRepository;
//
//    public UserEntity getByID(Long id){
//        try {
//            return userRepository.getReferenceById(id);
//        } catch (Exception e){
//            return null;
//        }
//    }
//
//    public UserEntity createUser(Contact contact, String email){
//        UserEntity user = new UserEntity();
//        user.setUserId(contact.getUserId());
//        user.setFirstName(contact.getFirstName());
//        user.setLastName(contact.getLastName());
//        user.setPhoneNumber(contact.getPhoneNumber());
//        if (email != null && !email.isEmpty()){
//            user.setEmail(email);
//        }
//        return userRepository.saveAndFlush(user);
//    }
//
//    public UserEntity updateUser(UserEntity user, String email){
//        if (email != null && !email.isEmpty()){
//            user.setEmail(email);
//        }
//        return userRepository.saveAndFlush(user);
//    }
//
//    public UserEntity findByEmail(String email){
//        return userRepository.getByEmail(email);
//    }
}
