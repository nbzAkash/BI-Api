package in.ag.service;

import javax.servlet.http.HttpServletResponse;

import in.ag.entity.EdEligDtlsEntity;

public interface BiService {
	
	
	public void exportCsv(HttpServletResponse response)throws Exception;

}
