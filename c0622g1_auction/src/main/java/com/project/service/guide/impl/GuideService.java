package com.project.service.guide.impl;

import com.project.model.guide.Guide;
import com.project.repository.guide.IGuideRepository;
import com.project.service.guide.IGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideService implements IGuideService {
    @Autowired
    private IGuideRepository guideRepository;

    @Override
    public List<Guide> findAllGuide() {
        return guideRepository.findAllGuide();
    }

    @Override
    public Guide getGuideById(int id) {
        return guideRepository.getGuideById(id);
    }

    @Override
    public void createGuide(Guide guide) {
        guideRepository.createGuide(guide.getTitle(),guide.getContent());
    }

    @Override
    public void updateGuide(Guide guide) {
        guideRepository.updateGuide(guide.getId(),guide.getTitle(),guide.getContent());
    }
}
