/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.api.controllerImpl;

import com.nuvu.api.controller.UserController;
import com.nuvu.api.model.LoginModel;
import com.nuvu.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author juanh
 */
@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UsuarioRepository userRepository;

    @Value("${nuvu.api.jwtSecret}")
    private String jwtSecret;
        @Value("${nuvu.api.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Override
    @PostMapping(value = "login")
    public ResponseEntity<?> login(@RequestBody LoginModel login) {
        final int existUser = userRepository.existsByUsernameAndPassword(login.getUsername(), login.getpassMd5());
        if (existUser == 0) {
            return ResponseEntity.ok("Credenciales inválidas");
        }
        String token = getJWTToken(login.getUsername());
        return ResponseEntity.ok(token);
    }

    @Override
    @PostMapping(value = "logout", produces = MediaType.APPLICATION_JSON_VALUE)
    public String logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getJWTToken(String username) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + jwtExpirationMs);
        String token = Jwts
                .builder()
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(Calendar.getInstance().getTime())
                .setExpiration(calendar.getTime())
                .signWith(SignatureAlgorithm.HS512,
                        jwtSecret.getBytes()).compact();

        return token;
    }
}
