package org.lu.service.impl;

import java.util.List;

import org.lu.entity.Resume;
import org.lu.entity.generator.ResumeContainer;
import org.lu.entity.generator.ResumeFactory;
import org.lu.repository.ResumeRepository;
import org.lu.service.ResumeService;
import org.lu.wrapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeRepository repository;

	@Transactional(readOnly = true)
	@Override
	public EntityWrapper<List<Resume>> getResumeByResumeName(String resumeName, int page)
			throws Exception {
		Pageable pageable = new PageRequest(page, ResumeService.PAGE_SIZE,
				Direction.DESC, ResumeService.RESUMENAME);
		Page<Resume> resumes = repository
				.findByResumeName(resumeName, pageable);
		EntityWrapper<List<Resume>> wrapper = new EntityWrapper<>();
		wrapper.setEntity(resumes.getContent());
		wrapper.setTotalNumberOfElement(resumes.getTotalElements());
		return wrapper;
	}

	// use dummy data, only for test
	@SuppressWarnings("unchecked")
	@Override
	public List<Resume> getAllResume() {
		ResumeContainer<List<Resume>> resumes = (ResumeContainer<List<Resume>>) ResumeContainer
				.getInstance();
		return resumes.getResumes();
	}

	@Transactional
	@Override
	public void insertData() {
		ResumeFactory.generateResumes();
		ResumeContainer<List<Resume>> resumes = (ResumeContainer<List<Resume>>) ResumeContainer
				.getInstance();
		resumes.getResumes().stream().forEach(e -> repository.save(e));
	}
}
