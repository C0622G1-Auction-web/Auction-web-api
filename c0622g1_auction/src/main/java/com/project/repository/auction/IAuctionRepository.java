package com.project.repository.auction;

import com.project.model.auction.Auction;
import com.project.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IAuctionRepository extends JpaRepository<Auction,Integer> {

    @Query(value = "select product.name, product.description,auction.auction_day,auction_status.name " +
            "from auction " +
            "join user on auction.user_id = user.id " +
            "join product on auction.product_id = product.id " +
            "join auction_status on product.auction_status_id = auction_status.id " +
            "where auction.user_id = :id ", nativeQuery = true)
    List<Product> showProductAuctionById(@Param("id") int id);
}
