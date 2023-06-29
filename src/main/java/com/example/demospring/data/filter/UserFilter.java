package com.example.demospring.data.filter;

import com.example.demospring.data.UserRole;
import com.example.demospring.data.entities.UserEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserFilter extends JPAFilter<UserEntity> {
    @Setter
    private String email;

    @Setter
    private UserRole role = null;
    @Override
    public Predicate getPredicate(CriteriaBuilder criteriaBuilder, Root root) {
      Predicate predicateEmail = equals(criteriaBuilder, root, "email", email);

      Predicate predicateRole = null;
      if (role != null){
          predicateRole = equals(criteriaBuilder, root, "role", role);
      }

        List<Predicate> predicates = Arrays.asList(predicateEmail,predicateRole);
        List<Predicate> notNull = new ArrayList<>();
        for (Predicate p : predicates){
            if (p != null){
                notNull.add(p);
            }
        }

         return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
