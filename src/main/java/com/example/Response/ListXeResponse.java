package com.example.Response;
import java.util.List;
import org.springframework.data.domain.Pageable;
import com.example.service.impl.XeServiceimpl;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
public class ListXeResponse {
	private List<XeResponse> xeResponses;
	private long total;
	private Pageable pageable;
	public ListXeResponse(List<XeResponse> xeResponses, long total, Pageable pageable) {
		super();
		this.xeResponses = xeResponses;
		this.total = total;
		this.pageable = pageable;
	}
	public ListXeResponse() {
		super();
	}
	
}
