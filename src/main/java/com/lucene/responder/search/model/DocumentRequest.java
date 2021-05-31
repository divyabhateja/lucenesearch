package com.lucene.responder.search.model;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Data
public class DocumentRequest {
	private String id;

	public DocumentRequest() {
	}

	public DocumentRequest(String id) {
		this.id = id;
	}
}
