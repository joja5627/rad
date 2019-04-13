package io.rad.web.service;

public interface ISecurityUserService {

    String validatePasswordResetToken(long id, String token);

}
