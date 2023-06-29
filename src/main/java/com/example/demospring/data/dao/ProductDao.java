package com.example.demospring.data.dao;

import com.example.demospring.data.entities.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    private final EntityManager entityManager;

    @Autowired
    public ProductDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void addProduct(ProductEntity toAdd){
        entityManager.persist(toAdd);
    }

    public ProductEntity update(ProductEntity toUpdate){
        return entityManager.merge(toUpdate);
    }

    public List<ProductEntity> findAll(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> criteriaQuery = criteriaBuilder.createQuery(ProductEntity.class);

        Root<ProductEntity> root = criteriaQuery.from(ProductEntity.class);
        criteriaQuery.select(root);

        TypedQuery query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();

    }
}
