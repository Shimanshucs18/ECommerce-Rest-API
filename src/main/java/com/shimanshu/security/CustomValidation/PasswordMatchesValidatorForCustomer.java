package com.shimanshu.security.CustomValidation;

import com.shimanshu.security.dto.SignupCustomerDao;
import com.shimanshu.security.entity.UserEntity;
import org.springframework.security.core.userdetails.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidatorForCustomer implements ConstraintValidator<PasswordMatchesForCustomer,Object> {
    @Override
    public void initialize(final PasswordMatchesForCustomer constraintAnnotation){

    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context){
        final SignupCustomerDao user = (SignupCustomerDao) obj;
        return user.getPassword().equals(user.getConfirmPassword());
    }
}
