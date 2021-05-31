package com.lucene.responder.search.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.lucene.responder.search.model.DocumentRequest;
import com.lucene.responder.search.model.LuceneResponse;
import com.lucene.responder.search.service.SearchService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	
	private final List<String> RANDOM_INDEX = Arrays.asList("common", "ecom", "product1", "product2", "product3", "product4");
	
	@MessageMapping("index")
	LuceneResponse getCustomer(DocumentRequest request) {
		searchService.indexDocument(request);
        return new LuceneResponse(request.getId(), getRandomName());
    }


    private String getRandomName() {
        return RANDOM_INDEX.get(new Random().nextInt(RANDOM_INDEX.size() - 1));
    }

}
