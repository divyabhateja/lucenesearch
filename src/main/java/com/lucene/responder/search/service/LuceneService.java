package com.lucene.responder.search.service;

import java.io.IOException;
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
import org.springframework.stereotype.Service;

@Service
public class LuceneService {
	
	public Directory indexSheet(String string, List<Map<String, Object>> output) throws IOException {
		Directory memoryIndex = new RAMDirectory();
		StandardAnalyzer analyzer = new StandardAnalyzer();
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
		IndexWriter writter = new IndexWriter(memoryIndex, indexWriterConfig);
		Document document = new Document();

		indexFieldInDocument(document,output);

		writter.addDocument(document);
		writter.close();
		return memoryIndex;
		
	}


	private void indexFieldInDocument(Document document, List<Map<String, Object>> output) {
		
		for(Map<String,Object> map : output) {
			for(Entry<String, Object> entry : map.entrySet()) {
					document.add(new TextField(entry.getKey(), entry.getValue().toString(), Field.Store.YES));
			}
		}
		
	}



	public List<String> searchbyProductName(Directory memoryIndex, String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

}
