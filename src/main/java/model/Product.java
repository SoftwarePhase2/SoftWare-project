package model;

public class Product {
	private String category, name,description,status;
	private int id,width,height, idCustomer,idWorker;



	public Product(int id, String name, String category, int width, int height, String description, int idCustomer, int idWorker,String status) {
		this.category = category;
		this.name = name;
		this.description = description;
		this.width = width;
		this.height = height;
		this.idCustomer = idCustomer;
		this.idWorker = idWorker;
		this.id = id;
		this.status=status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	
	public int getIdWorker() {
		return idWorker;
	}
	
	public void setIdWorker(int idWorker) {
		this.idWorker = idWorker;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLength() {
		return width;
	}

	public void setLength(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
