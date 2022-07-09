package com.food_delivery.foodDeliveryApp.Model;

public class food_categories {
	private String food_id;
	private String category;
	private String cat;
	private String image;
	private String name;
	private float price;
	private String s_desc;
	private String description;

	public food_categories() {

	}

	public food_categories(String food_id, String category, String cat, String image, String name, float price,
			String s_desc, String description) {
		super();
		this.food_id = food_id;
		this.category = category;
		this.cat = cat;
		this.image = image;
		this.name = name;
		this.price = price;
		this.s_desc = s_desc;
		this.description = description;
	}

	public String getFood_id() {
		return food_id;
	}

	public void setFood_id(String food_id) {
		this.food_id = food_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getS_desc() {
		return s_desc;
	}

	public void setS_desc(String s_desc) {
		this.s_desc = s_desc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
