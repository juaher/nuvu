/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.api.model;

import java.io.Serializable;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author juanh
 */
public class LoginModel implements Serializable{
    private String username;
    private String password;

    public LoginModel() {
    }

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getpassMd5() {
        return DigestUtils.md5Hex(this.getPassword()).toUpperCase();
    }

    
}
