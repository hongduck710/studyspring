package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.util.UriComponentsBuilder;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;
	private int amount;
	
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1,10);
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;	
	}
	public String[] getTypeArr() { /* 검색조건을 배열로 만들어줌 */
		return type == null ? new String[] {} : type.split("");
	}

	//20240821- 이 부분부터
	 public String getListLink() { 
		 UriComponentsBuilder builder =  UriComponentsBuilder.fromPath("") 
		.queryParam("pageNum",this.pageNum)
		.queryParam("amount", this.getAmount())
		.queryParam("type", this.getType())
		.queryParam("keyword", this.getKeyword());
		 		 
		return builder.toUriString();
	
	  }
	 
	
}
