package intelmas.app.retriever.service;

import java.util.Map;

public interface ConstruramaMailService {
	void sendMail(final String to, final String cc, final String bcc, final String subject, final String body)
			throws Exception;

	void sendMail(final String to, final String cc, final String bcc, final String subject, final String body,
			final Map<String, String> attachments) throws Exception;
	
	public void sendBasicMail (final String to, final String cc, final String bcc, final String subject, final String body);
	
	public void SendEmailUsingGMailSMTP(final String mailId, final String to, final String cc, final String bcc, final String subject, final String body) throws Exception;
}
