package org.lu.ut;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lu.entity.Resume;
import org.lu.repository.ResumeRepository;
import org.lu.service.ResumeService;
import org.lu.service.impl.ResumeServiceImpl;
import org.lu.wrapper.EntityWrapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

@RunWith(PowerMockRunner.class)
public class ResumeTest {

	private final String resumeName = "tt";
	private final int page = 1;
	private Pageable pageable = null;

	@Mock
	private ResumeRepository repository;

	@InjectMocks
	private ResumeServiceImpl resumeServiceImpl;

	@Before
	public void initData() {
		pageable = new PageRequest(page, ResumeService.PAGE_SIZE,
				Direction.DESC, ResumeService.RESUMENAME);
	}

	@Test
	public void getResumeByResumeNameNegativeTest() throws Exception {
		PowerMockito.when(repository.findByResumeName(resumeName, pageable))
				.thenReturn(null);
		EntityWrapper<List<Resume>> wrapper = resumeServiceImpl
				.getResumeByResumeName(resumeName, page);
		Assert.assertEquals(0, wrapper.getTotalNumberOfElement());
	}
}
