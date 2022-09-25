package hashdriver;

import hash.*;

/**
 * @author Matthew Cipriotti
 */
public class Book {

	String title;
	String author;
	int pageCount;
	Date copyRight;
	
	public Book(String title, String author, int pageCount, Date copyRight) {
		this.title = title;
		this.author = author;
		this.pageCount = pageCount;
		this.copyRight = copyRight;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getPageCount() {
		return pageCount;
	}
	
	public Date getCopyRight() {
		return copyRight;
	}
	
	public String toString() {
		return "Author: " + author + ", Title: " + title + ", Copyright: " + copyRight + ", Pages: " + pageCount;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Book))
			return false;
		Book b = (Book) obj;
		return title.equals(b.getTitle()) && author.equals(b.getAuthor()) &&
				copyRight.equals(b.getCopyRight());
	}
	
	@Override
	public int hashCode() {
		int result = 31;
		
		result = 31 * result + title.hashCode();
		result = 31 * result + author.hashCode();
		result = 31 * result + copyRight.hashCode();
		
		return result;
	}
}
