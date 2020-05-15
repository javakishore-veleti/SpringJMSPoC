package rtcm.app.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaseDetails {

	private Long id;

	private String title;
	private String description;

	private Map<String, Object> caseAddlData = new HashMap<>();
	private List<Long> caseDocumentIds = new ArrayList<>();

	public CaseDetails() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, Object> getCaseAddlData() {
		return caseAddlData;
	}

	public void setCaseAddlData(Map<String, Object> caseAddlData) {
		this.caseAddlData = caseAddlData;
	}

	public List<Long> getCaseDocumentIds() {
		return caseDocumentIds;
	}

	public void setCaseDocumentIds(List<Long> caseDocumentIds) {
		this.caseDocumentIds = caseDocumentIds;
	}

}
