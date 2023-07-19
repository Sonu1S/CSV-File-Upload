package net.javaguide.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.javaguide.springboot.response.ResponseMessage;
import net.javaguide.springboot.service.ItemService;

@RestController
@RequestMapping("/files")
public class ItemController {
    @Autowired
	private ItemService service;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file
//    		@RequestParam("itemcode") String itemCode,
//            @RequestParam("itemName") String itemName,//itemcode
//            @RequestParam("category") String category,
//            @RequestParam("description") String description,
//            @RequestParam("originalPrice") String originalPrice,
//            @RequestParam("discountPrice") String discountPrice,
//            @RequestParam("quantity") String quantity,
//            @RequestParam("message") String message,
//            @RequestParam("storeId") String storeId
    		){
		if(service.hasCsvFormat(file)) {
			service.processAndSaveData(file);
	         return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(
	        		 "Uploaded the file successfully : "+ file.getOriginalFilename()));
			
		}else
             return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
            		 .body(new ResponseMessage("please upload CSV file"));
    	
    }
    
    
//    @Autowired
//    public FileController(FileService fileService) {
//        this.fileService = fileService;
//    }
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
//                                             @RequestParam("itemName") String itemName,
//                                             @RequestParam("description") String description) {
//        // Check if file is empty
//        if (file.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
//        }
//
//        // Save item details
//        Item item = new Item();
//        item.setItemName(itemName);
//        item.setDescription(description);
//
//        try {
//            // Set file data, assuming you want to store the file content as a byte array
//            item.setFileData(file.getBytes());
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process file");
//        }
//
//        // Save the item to the database
//        Item savedItem = itemService.saveItem(item);
//
//        if (savedItem == null)
}