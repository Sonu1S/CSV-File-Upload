package net.javaguide.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="item_code")
	private String itemcode;
	@Column(name="item_name")
	private String itemName;
	@Column(name="category")
	private String category;
	@Column(name="description")
	private String description;
	@Column(name="original_price")
	private String originalPrice;
	@Column(name="discount_price")
	private String discountPrice;
	@Column(name="quantity")
	private String quantity;
	@Column(name="message")
	private String message;
	@Column(name="store_id")
	private String storeId;
	
	public long getId() {
		return id;
	}
	public String getItemcode() {
		return itemcode;
	}
	public String getItemName() {
		return itemName;
	}
	public String getCategory() {
		return category;
	}
	public String getDescription() {
		return description;
	}
	public String getOriginalPrice() {
		return originalPrice;
	}
	public String getDiscountPrice() {
		return discountPrice;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getMessage() {
		return message;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}
	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public Item(long id, String itemcode, String itemName, String category, String description, String originalPrice,
			String discountPrice, String quantity,String message,String storeId) {
		super();
		this.id = id;
		this.itemcode = itemcode;
		this.itemName = itemName;
		this.category = category;
		this.description = description;
		this.originalPrice = originalPrice;
		this.discountPrice = discountPrice;
		this.quantity = quantity;
		this.message = message;
		this.storeId = storeId;
	}
	public Item() {
		super();
	}
	

	
}
