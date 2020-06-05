package servlet.Model;

public class BookVO {
	private String isbn;
	private String title;
	private String genre;
	private String country;
	private String publishDate;
	private String publisher;
	private String author;
	private int price;
	private String unit;
	private String summary;
	
	public BookVO(String isbn, String title, String genre, String country, String publishDate, String publisher,
			String author, int price, String unit, String summary) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.genre = genre;
		this.country = country;
		this.publishDate = publishDate;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.unit = unit;
		this.summary = summary;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "BookVO [isbn=" + isbn + ", title=" + title + ", genre=" + genre + ", country=" + country
				+ ", publishDate=" + publishDate + ", publisher=" + publisher + ", author=" + author + ", price="
				+ price + ", unit=" + unit + ", summary=" + summary + "]";
	}
	
	
	
	
	
	

}
