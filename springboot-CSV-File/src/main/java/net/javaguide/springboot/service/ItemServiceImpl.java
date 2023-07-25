package net.javaguide.springboot.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.javaguide.springboot.Repository.ItemRepository;
import net.javaguide.springboot.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository repository;
	
	@Override
	public boolean hasCsvFormat(MultipartFile file) {
     String type = "text/csv";
     if(!type.equals(file.getContentType()))
    	 return false;
		return true;
	}

	@Override
	public void processAndSaveData(MultipartFile file) {
	  try {
		  List<Item> items = csvToItems(file.getInputStream());
	     repository.saveAll(items);
	      
	  } catch (IOException e) {
		  e.printStackTrace();
	}	
	}

	private List<Item> csvToItems(InputStream inputStream) {
	try 
		(BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
		CSVParser csvParser = new CSVParser(fileReader,
			CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());){
	
		List<Item> items = new ArrayList<Item>();
		List<CSVRecord> records = csvParser.getRecords();
		for(CSVRecord csvRecord : records) {
			
			Item item = new Item(Long.parseLong(csvRecord.get("id")), csvRecord.get("item_code"),
			csvRecord.get("item_name"),csvRecord.get("category"), csvRecord.get("description"), 
			csvRecord.get("original_price"), csvRecord.get("discount_price"), 
			csvRecord.get("quantity"), csvRecord.get("message"), csvRecord.get("store_id"));
		items.add(item);
		}
		return items;
	}catch (Exception e) {

	}
		return null;
	}

}
