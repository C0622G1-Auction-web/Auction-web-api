package com.project.service.product.impl;

import com.project.model.product.ReviewStatus;
import com.project.repository.product.IReviewStatusRepository;
import com.project.service.product.IReviewStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewStatusService implements IReviewStatusService {
    @Autowired
    private IReviewStatusRepository reviewStatusRepository;

    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: get list review Status of products Sign up for auctions
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    @Override
    public List<ReviewStatus> findAll() {
        return reviewStatusRepository.findAll();
    }
}
