package in.ag.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ag.service.BiService;

@RestController
public class BiController {
	
	@Autowired
	private BiService biService;
	
	@GetMapping("/transfer")
	public ResponseEntity<List<String>> sendBenefit(){
	      biService.tnsfrBenefitAmt();
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@GetMapping("/csv")
	public void exportCsv(HttpServletResponse response)throws Exception {
		
        response.setContentType("text/csv");
		
		String key = "Content-Disposition";
		String value = "attachment;filename=citizens.csv";
		
		response.setHeader(key, value);
		biService.exportCsv(response);
	}

}
