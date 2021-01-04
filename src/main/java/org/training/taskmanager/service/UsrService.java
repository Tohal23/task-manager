package org.training.taskmanager.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.training.taskmanager.model.Usr;
import org.training.taskmanager.object.usr.UsrCreateReq;
import org.training.taskmanager.repository.UsrRep;

@Service
public class UsrService implements UserDetailsService {

    private final UsrRep usrRep;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsrService(UsrRep usrRep) {
        this.usrRep = usrRep;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder(8);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usrRep.findByUsername(username);
    }

    public Long createUser(UsrCreateReq usrCreateReq) {
        if (usrCreateReq.getPassword().isEmpty() || usrCreateReq.getUsername().isEmpty()) {
            throw new RuntimeException();
        }

        if (usrRep.findByUsername(usrCreateReq.getUsername()) != null) {
            throw new RuntimeException();
        }

        Usr user = new Usr();
        user.setUsername(usrCreateReq.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(usrCreateReq.getPassword()));
        usrRep.save(user);

        return user.getId();
    }
}
