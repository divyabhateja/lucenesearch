package com.lucene.responder.search.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DocumentRequest {
	private String id;

	public DocumentRequest() {
	}

	public DocumentRequest(String id) {
		this.id = id;
	}
}
