package com.example.request;

import lombok.Data;

@Data
public class SearchRequest {
	private Long id;
	private int pageIndex;
	private int pageSize;
	private String keyword;
	private String orderBy;
}
