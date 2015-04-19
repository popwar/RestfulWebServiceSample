package org.lu.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.lu.entity.Resume;
import org.lu.wrapper.EntityWrapper;

@Path(ResumeService.BASE)
@Consumes(MediaType.APPLICATION_JSON)
public interface ResumeService {
	public static final String BASE = "/resumeService/resumes";
	public static final String RESUMENAME_PATH = "/{resumeName}";
	public static final String RESUMENAME = "resumeName";
	public static final String PAGE = "page";
	public static final int PAGE_SIZE = 1;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resume> getAllResume();

	@GET
	@Path(RESUMENAME_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	public EntityWrapper<List<Resume>> getResumeByResumeName(
			@PathParam(RESUMENAME) String resumeName, @QueryParam(PAGE) int page) throws Exception;
	
	@GET
	@Path("/insertData")
	public void insertData();
}
