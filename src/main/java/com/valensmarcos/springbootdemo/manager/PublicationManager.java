package com.valensmarcos.springbootdemo.manager;

import com.valensmarcos.springbootdemo.entity.Publication;
import com.valensmarcos.springbootdemo.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class PublicationManager {

    @Autowired
    PublicationRepository publicationRepository;

    public void add(Publication publication){
        publicationRepository.save(publication);
    }

    public List<Publication> findAllByTitleOrContent(String s){
        return this.publicationRepository.findAllByTitleContainsAndContentContains(s,s);
    }

}
