package org.lu.service.client;

import java.util.List;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.lu.entity.Resume;
import org.lu.service.ResumeService;

public class ResumeClient {

	private final static ResumeService resumeService = JAXRSClientFactory
			.create("https://localhost:8443/RestWebService/rest",
					ResumeService.class);;

	public static void getAllResumes() {
		List<Resume> resumes = resumeService.getAllResume();
		System.out.println(resumes.size());
	}
}
