package in.ag.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import in.ag.entity.EdEligDtlsEntity;
import in.ag.repository.EdEligRepository;

public class BiServiceImpl implements BiService {

	@Autowired
	private EdEligRepository edRepo;

	

	@Override
	public void exportCsv(HttpServletResponse response) throws Exception {

		List<EdEligDtlsEntity> citizenData = edRepo.getCitizenData();

		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = { "Case Num", "Full Name", "SSN", "Plan Name", "Benefit Amount" };
		String[] nameMapping = { "caseNum", "holderName", "holderSsn", "planName", "benefitAmt" };

		csvWriter.writeHeader(csvHeader);

		for (EdEligDtlsEntity citizen : citizenData) {
			csvWriter.write(citizen, nameMapping);
		}

		csvWriter.close();

	}

}
