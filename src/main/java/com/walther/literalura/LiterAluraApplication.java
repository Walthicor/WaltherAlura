package com.walther.literalura;

import com.walther.literalura.model.Book;
import com.walther.literalura.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	// Inyección de dependencias de BookService
	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		System.out.println("Bienvenido a LiterAlura");

		while (!exit) {
			System.out.println("Menu de opciones:");
			System.out.println("1. Buscar por Título");
			System.out.println("2. Buscar por Autor");
			System.out.println("3. Filtrar por Tema");
			System.out.println("4. Ver Detalles de un Libro");
			System.out.println("5. Listar Libros Populares");
			System.out.println("6. Salir");
			System.out.println("\nSeleccione una opción:");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consumir nueva línea

			switch (choice) {
				case 1:
					System.out.print("Ingrese el título: ");
					String title = scanner.nextLine();
					List<Book> booksByTitle = bookService.searchByTitle(title);
					booksByTitle.forEach(book -> System.out.println(book.getTitle()));
					break;
				case 2:
					System.out.print("Ingrese el autor: ");
					String author = scanner.nextLine();
					List<Book> booksByAuthor = bookService.searchByAuthor(author);
					booksByAuthor.forEach(book -> System.out.println(book.getTitle()));
					break;
				case 3:
					System.out.print("Ingrese el tema: ");
					String theme = scanner.nextLine();
					List<Book> booksByTheme = bookService.filterByTheme(theme);
					booksByTheme.forEach(book -> System.out.println(book.getTitle()));
					break;
				case 4:
					System.out.print("Ingrese el ID del libro: ");
					Long id = scanner.nextLong();
					scanner.nextLine(); // Consumir nueva línea
					bookService.getBookDetails(id)
							.ifPresentOrElse(
									book -> System.out.println("Título: " + book.getTitle() + ", Autor: " + book.getAuthor()),
									() -> System.out.println("Libro no encontrado")
							);
					break;
				case 5:
					List<Book> popularBooks = bookService.listPopularBooks();
					popularBooks.forEach(book -> System.out.println(book.getTitle()));
					break;
				case 6:
					exit = true;
					System.out.println("Saliendo de LiterAlura. ¡Hasta pronto!");
					break;
				default:
					System.out.println("Opción no válida. Intente de nuevo.");
					break;
			}
		}

		scanner.close();
	}
}

