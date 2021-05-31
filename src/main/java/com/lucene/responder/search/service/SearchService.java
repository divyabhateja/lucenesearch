package com.lucene.responder.search.service;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucene.responder.file.service.GoogleFileReaderService;
import com.lucene.responder.search.model.DocumentRequest;
@Service
public class SearchService {
	
	@Autowired
	private GoogleFileReaderService googleFileReaderService;
	
	
	@Autowired
	private LuceneService luceneService;
	
	
	

		public void indexDocument(DocumentRequest request) {
			try {
				List<Map<String,Object>> output = googleFileReaderService.getSheetValues();
				Directory document = luceneService.indexSheet("Feed",output);
				List<String> record = luceneService.searchbyProductName(document,"product_name","MAM Easy Start Anti-Colic Bottle 2 Pack 160ml 5oz Grey");
			} catch (IOException  |GeneralSecurityException e) {
				e.printStackTrace();
			}
			
		}



	

}
