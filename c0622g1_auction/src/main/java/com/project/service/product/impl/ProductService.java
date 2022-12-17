package com.project.service.product.impl;


import com.project.dto.product.ProductSearchByRoleAdminDto;
import com.project.dto.product.ProductDto;
import com.project.dto.product.ProductSearchDto;
import com.project.model.product.Product;
import com.project.model.product.dto.ProductDTO;
import com.project.repository.product.IProductRepository;
import com.project.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;
    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: get page products Sign up for auctions by user id
     * @param id
     * @param pageable
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    @Override
    public Page<ProductDto> showProductById(Integer id, Pageable pageable) {
        return productRepository.showProductById(id, pageable);
    }

    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: get page products Sign up for auctions by user id
     * @param id
     * @return void
     */

    @Override
    public void cancelProduct(Integer id) {
        productRepository.cancelProduct(id);
    }

    @Override
    public void saveProduct(Product product) {

    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to find product by id
     *
     * @param id
     * @return Optional product
     */
    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findProductById(id);
    }


    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: save Product
     */

//    @Override
//    public void saveProduct(Product product) {
//        productRepository.createProduct(product.getDescription(), product.getEndTime(), product.getInitialPrice(), product.getName(), product.getStartTime(), product.getCategory().getId(), product.getPriceStep().getId(), product.getUser().getId());
//
//    }

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     *
     * @param productId
     * @return HttpStatus.NOT_FOUND if result is not present or HttpStatus.OK if result is present
     */

    @Override
    public Optional<Product> findProductById(Integer productId) {
        return productRepository.findProductById(productId);
    }
    @Override
    public void saveProduct(ProductDTO productDTO) {
        productRepository.saveProduct(productDTO.getName(), productDTO.getInitialPrice(), productDTO.getUser(),
                productDTO.getCategory(), productDTO.getDescription(), productDTO.getPriceStep(),
                productDTO.getStartTime(), productDTO.getEndTime(), productDTO.getRegisterDay(),productDTO.getAuctionStatus(),productDTO.getReviewStatus());
    }

    @Override
    public void update(ProductDTO productDTO) {
        productRepository.updateProduct(productDTO.getName(), productDTO.getInitialPrice(), productDTO.getUser(),
                productDTO.getCategory(), productDTO.getDescription(), productDTO.getPriceStep(),
                productDTO.getStartTime(), productDTO.getEndTime(), productDTO.getRegisterDay(), productDTO.getId());

    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to find products list by List ids
     *
     * @param idList
     * @return product list
     */
    @Override
    public List<Product> findByListId(List<Integer> idList) {
        return productRepository.findByListId(idList);
    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to delete products list by List ids
     *
     * @param idList
     */
    @Override
    public void removeByListId(List<Integer> idList) {
        productRepository.removeByListId(idList);
    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to get products in page
     *
     * @param pageable
     * @return product page
     */
    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.getAll(pageable);
    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to search products by product name and category and seller name
     * and product initial price and auction status
     *
     * @param productSearchByRoleAdminDto
     * @param pageable
     * @return product page
     */
    @Override
    public Page<Product> searchByRoleAdmin(ProductSearchByRoleAdminDto productSearchByRoleAdminDto, Pageable
            pageable) {
        return productRepository.searchByRoleAdmin(productSearchByRoleAdminDto, pageable);
    }


    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to review product
     *
     * @param id
     */
    @Override
    public void review(Integer id) {
        productRepository.reviewProduct(id);
    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to don't review product
     *
     * @param id
     */
    @Override
    public void doNotReview(Integer id) {
        productRepository.doNotReviewProduct(id);
    }

    /**
     * Created SangDD
     * Date created 13/12/2022
     * Function: search and filter product by name, rangePrice, categoryID productAuctionStatus
     *
     * @param productSearchDto
     * @param pageable
     * @return Page<Product>
     */
    @Override
    public Page<Product> getAllAndSearch(ProductSearchDto productSearchDto, Pageable pageable) {
        return productRepository.getAllAndSearch(productSearchDto, pageable);

    }

}
