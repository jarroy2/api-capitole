package com.capitole.infrastructure.database.h2.repository;

import com.capitole.infrastructure.database.h2.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository("productJpaRepository")
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p FROM PriceEntity p " +
            "WHERE p.product.id = :productId AND p.brand.id = :brandId " +
            "AND :date BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC")
    List<PriceEntity> findApplicablePrices(
            @Param("productId") Long productId,
            @Param("brandId") Long brandId,
            @Param("date") LocalDateTime date
    );
}
