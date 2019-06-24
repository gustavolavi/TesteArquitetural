package br.com.gustavolavi.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * User
 */
@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String login;
    private String Senha;

}