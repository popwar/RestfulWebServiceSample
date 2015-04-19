package org.lu.ut;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lu.service.client.ResumeClient;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ResumeClientTest {

	@Test
	public void getAllResumes() {
		ResumeClient.getAllResumes();
	}
}
