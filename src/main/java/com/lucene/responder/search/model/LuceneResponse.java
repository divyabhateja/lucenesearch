package com.lucene.responder.search.model;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Data
public class LuceneResponse {

	private String id;

	private String name;

	public LuceneResponse() {
	}

	public LuceneResponse(String id, String name) {
		this.id = id;
		this.name = name;
	}

}
