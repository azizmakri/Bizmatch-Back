package tn.esprit.msclaim.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.msclaim.Entities.Role;
import tn.esprit.msclaim.Entities.User;
import tn.esprit.msclaim.Repositories.UserRepo;

@Service
public class UserService implements UserServiceImp{
    @Autowired
    UserRepo userRepository;

    public User getUserByid(Long id) {

        return userRepository.findByIdUserAndRole( id , Role.SUPPLIER );
    }

    public void blockUser(User user) {
        user.setBanned(true);
        userRepository.save(user);
    }
}
