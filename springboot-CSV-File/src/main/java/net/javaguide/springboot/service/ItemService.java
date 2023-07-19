package net.javaguide.springboot.service;

import org.springframework.web.multipart.MultipartFile;

public interface ItemService {

	boolean hasCsvFormat(MultipartFile file);

	void processAndSaveData(MultipartFile file);

}
