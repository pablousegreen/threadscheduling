package intelmas.app.retriever.service;
//import static com.intelmas.service.FileProcessor.LOG;

import java.io.File;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.filters.RegexPatternFileListFilter;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Async;
//import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/** Class scanner/listener for Remedy files path 
 * @author Intelma
 *
 */
@Service
public class RemedyFileProcessor {
	
	 private static final Logger logger = LoggerFactory.getLogger(RemedyFileProcessor.class);
	
	/**
	 * Field injection value of path for Remedy files from application properties.
	 */
//	@Value("${import.directory.remedy:#{null}}")
	private String inputDirArne = "C://PABLO//VIDEOTUT//ENGLISH";
	
	/** Method scanner of Remedy path waiting for new files incoming.
	 * @return FileReadingMessageSource object created from file found in path and sent to the channel {@link com.intelmas.service.RemedyFileProcessor.processRemedyAdapter(Message<File>)}
	 */
	@Bean()
	@InboundChannelAdapter(value = "processRemedyAdapter", poller = @Poller(fixedDelay = "${importer.scan.period}", maxMessagesPerPoll = "${importer.scan.pool}"))
	public FileReadingMessageSource processRemedy() {
		logger.info("600 ___processRemedy ");
	    FileReadingMessageSource lm = new FileReadingMessageSource();
	    
	    if(inputDirArne != null) lm.setDirectory(new File(inputDirArne));
	    Pattern pattern = getFilePattern();
	    lm.setFilter(new RegexPatternFileListFilter(pattern));
	    lm.setUseWatchService(true);
	    lm.setWatchEvents(FileReadingMessageSource.WatchEventType.CREATE);
	    return lm;
	}
	
	protected Pattern getFilePattern(){
		Pattern pattern = Pattern.compile(".+(\\.xml|\\.zip|\\.csv|\\.txt|\\.mp4)");
		return pattern;
	}
	
	/** 
	 * @param message Message<File> object created from file from path and delivered from processArne adapter.
	 */
	@ServiceActivator(inputChannel = "processRemedyAdapter", outputChannel="afterProcessFileChannel")
    public void processRemedyAdapter(Message<File> message) {
       
		processFile(message);
//		LOG.info("Finish Processing ERBS File {}", message.toString());
    }
	
	
	@Async
	public void processFile(Message<File> message){
		
		
		
		
		File originalFile = message.getPayload();
		if(originalFile == null || originalFile.length() == 0){
			if(originalFile.length() == 0){
//				processFileAfter(originalFile, true);
				logger.info("File is empty, remove the file");
			}
			return;
		}else{
			logger.info(" 601__ We got the message: "+originalFile.getName());
		}
		
//		handler.processFile(message);
//		this.processFile(originalFile);
		
	}

	
}
