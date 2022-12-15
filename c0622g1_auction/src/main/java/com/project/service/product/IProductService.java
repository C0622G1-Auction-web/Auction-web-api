package com.project.service.product;


<<<<<<< HEAD
import com.project.dto.product.ProductSearchByRoleAdminDto;
=======
import com.project.model.product.Product;
import com.project.model.product.dto.ProductDTO;

import java.util.Optional;


import com.project.dto.ProductSearchByRoleAdminDto;
>>>>>>> 36e019559080780e3aa592ba0c210420f2b24902

import com.project.dto.product.ProductSearchDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
public interface IProductService {


    Optional<Product> findById(Integer id);

    void saveProduct(ProductDTO ProductDTO);

    void update(ProductDTO ProductDTO);


    List<Product> findByListId(List<Integer> idList);

    void removeByListId(List<Integer> idList);

    Page<Product> getAll(Pageable pageable);

    Page<Product> searchByRoleAdmin(ProductSearchByRoleAdminDto productSearchByRoleAdminDto, Pageable pageable);


    void review(Integer id);

    void doNotReview(Integer id);


    /**
     * Created SangDD
     * Date created 13/12/2022
     * Function: search and filter product by name, rangePrice, categoryID productAuctionStatus
     * @param productSearchDto
     * @param pageable
     * @return Page<Product>
     */
    Page<Product> getAllAndSearch(ProductSearchDto productSearchDto, Pageable pageable);

}
