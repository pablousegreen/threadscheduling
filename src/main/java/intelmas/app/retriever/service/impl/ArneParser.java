package intelmas.app.retriever.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;


import intelmas.app.retriever.model.CdCatalog;
import intelmas.app.retriever.model.NodesOssEntity;
import intelmas.app.retriever.service.TopologyParserService;


/** Class implementation of parser for ARNE files type.
 * @author Intelma
 *
 */
@Component("arneParser")
@PropertySource(value = { "classpath:application.properties" })
public class ArneParser /*implements TopologyParserService*/ {

//	@Autowired
//	private OssRepository ossRepository;
//
//	@Autowired
//	private NodesOssRepository nodesRepository;
//
//	@Autowired
//	private NodesNameRepository nodesNameRepository;
//	
//	@Autowired
//	private NodesTypeRepository nodesTypeRepository;

//	///////////////@Value("${cassandra.insert.size}")
	private int insertSize;
	
	private static final Logger LOG = LoggerFactory.getLogger(ArneParser.class);
	
	public static void main(String[] args) {
		parser(new File("C:\\PABLO\\cd_catalog.xml"));
//	    System.out.println("99: "+toZonedDateTime(new Date()));
//	    System.out.println("100.-Days: "+get());
	  }

	
//	@Override
	public static void parser(File originalFile) {
		List<CdCatalog> typeList = new ArrayList<CdCatalog>();
		

		LOG.info("currentFile: " + originalFile.getName());
		if (originalFile.isFile()
				&& (!originalFile.getName().contains("processed") || !originalFile.getName().contains("PROCESSED"))) {


				List<CdCatalog> empList = parseXML(originalFile);
				for (CdCatalog nodesOssEntity : empList) {
					
					
				originalFile.renameTo(new File(originalFile.getAbsolutePath() + ".processed"));
			}
		}
	}

	/**
	 * @param fileName File object with XML format to parse. 
	 * @param ossEntityInfo OssEntity object with OSS information found in cassandra DB.
	 * @return List with NodesOssEntity objects extracted from XML file.
	 */
	private static List<CdCatalog> parseXML(File fileName) {
		List<CdCatalog> nodeList = new ArrayList<>();
		List<NodesOssEntity> existNodes = new ArrayList<>();
		CdCatalog node = null;
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {
			////////////nodesRepository.findAll().forEach(existNodes::add);

			XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(fileName));
			int event = xmlStreamReader.getEventType();
			LOG.info("XML BAse : "+xmlStreamReader.getAttributeValue(0));
			List<CdCatalog> nodesFilter = nodeList.stream().collect(Collectors.toList());
					LOG.info(xmlStreamReader.getAttributeValue(0));
//			List<NodesOssEntity> nodesFilter = nodeList.stream().filter(
//					param -> xmlStreamReader.getAttributeValue(0).equals(param.getKey().getNode_name()))
//					.collect(Collectors.toList());
//					LOG.info(xmlStreamReader.getAttributeValue(0));
			
			if(nodesFilter!=null) {
				nodesFilter.stream().forEach(nodeValue -> {
//					LOG.info(" 1. TITLE: "+nodeValue.getKey().getNode_name());
				});
			}else {
				LOG.info("EMPTY LIST:nodesFilter ");
			}

		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
			LOG.error("Exception when executing saving documents [Exception:{}]", e.toString());
		}
		return nodeList;
	}

	/**
	 * @param currentFile File object found in ARNE path
	 * @return OssEntity object with result data from cassandra query. 
	 */
//	public OssEntity findOssEntityPath(File currentFile) {
//
//		System.out.println(currentFile.getPath());
//		OssEntity OssEntityInfo = null;
//
//		// Directory Structure: /pdata/topology/ericsson/arne/<hostname or ossname>/<filename>
//		String directory = StringUtils.substringAfter(currentFile.getPath(), File.separator+"pdata"+File.separator);
//		String[] filePaths = StringUtils.split(directory, File.separator);
//		String oss = "";
//		String tech = "";
//		String vendor = "";
//		
//		if (filePaths.length > 1) vendor = filePaths[1];
//		if (filePaths.length > 3) oss = filePaths[3];
//		if (directory.contains("3g")) tech = "3G";
//		if (directory.contains("4g") || directory.contains("lte")) tech = "4G";
//
//
//		try {
//
//			OssEntityInfo = ossRepository.findByName(vendor, oss);
//
//			if (OssEntityInfo == null) {
//				OssEntityInfo = new OssEntity();
//
//
//				OssEntityInfo.setOss_name(oss);
//				OssEntityInfo.setOss_organisation(vendor);
//				OssEntityInfo.setOss_tech(tech);
//
//				ossRepository.save(OssEntityInfo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return OssEntityInfo;
//	}

}
