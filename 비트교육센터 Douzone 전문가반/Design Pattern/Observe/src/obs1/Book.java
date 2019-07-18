package obs1;

import java.util.ArrayList;
import java.util.List;

public class Book implements Observable {

	List<Customer> customerList = new ArrayList<>();

	private boolean checkBook = false;
	
	public boolean isCheckBook() {
		return checkBook;
	}
	
	public void newBook() {
		System.out.println("새로운 도서가 추가 되었습니다.");
		checkBook = true;
		bookUpdate();
	}

	@Override
	public void bookService(Customer c) {
		customerList.add(c);
	}

	@Override
	public void bookCancel(Customer c) {
		customerList.remove(c);
	}

	@Override
	public void bookUpdate() {
		// observerList.forEach( Observer::Updata );
		for(Customer customer : customerList) {
			customer.Updata();
		}
		
		System.out.println(customerList.size() + "명에게 책 소식을 전달했습니다.");
	}
}