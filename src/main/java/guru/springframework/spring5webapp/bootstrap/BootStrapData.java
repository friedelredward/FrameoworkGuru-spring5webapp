package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 12/23/19.
 */
//annotation needed to be detected by spring and commandline run to be run
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepo publisherRepo;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepo publisherRepo) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepo = publisherRepo;

    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap command");
        System.out.println("Number of Books: " + bookRepository.count());

        Publisher pub1= new Publisher("address", "madrid", "mostoles", 155);
        publisherRepo.save(pub1);
        System.out.println("number of publishers:"+ publisherRepo.count());
    }
}
