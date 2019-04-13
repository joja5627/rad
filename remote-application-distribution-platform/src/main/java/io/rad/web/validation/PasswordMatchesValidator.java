package io.rad.web.validation;

import io.rad.web.domain.UserForm;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final UserForm user = (UserForm) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }

}
