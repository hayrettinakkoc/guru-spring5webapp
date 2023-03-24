package bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import domain.Author;
import domain.Book;
import repositories.AuthorRepository;
import repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner{

	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	
	public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository) {
		super();
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Author eric=new  Author("Eric", "Eddison");
		Book kitap=new Book("Ligth of Lamb", "123123");
		eric.getBooks().add(kitap);
		kitap.getAuthor().add(eric);
		authorRepository.save(eric);
		bookRepository.save(kitap);
		
		Author rod=new Author("Rod","Johnson");
		Book kitap2=new Book("Noejb","46797988");
		rod.getBooks().add(kitap2);
		kitap.getAuthor().add(rod);
		authorRepository.save(rod);
		bookRepository.save(kitap2);
		
		System.out.println("started");
		System.out.println("number of books"+bookRepository.count());
		
	}

	
}
