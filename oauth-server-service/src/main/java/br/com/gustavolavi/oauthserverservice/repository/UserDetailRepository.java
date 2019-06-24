package br.com.gustavolavi.oauthserverservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavolavi.oauthserverservice.model.User;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<User,Integer> {


    Optional<User> findByUsername(String name);

}