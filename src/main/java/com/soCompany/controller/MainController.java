package com.soCompany.controller;

import com.soCompany.entity.Book;
import com.soCompany.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/")
    public String mainPage(Model model) {
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "main";
    }

    @GetMapping("/add")
    public String addButton() {
        return "add-book";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam String title,
                          @RequestParam String author,
                          @RequestParam String genre,
                          @RequestParam int pages) {
        Book book = new Book();
        book.setAuthor(author);
        book.setGenre(genre);
        book.setTitle(title);
        book.setPages(pages);
        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable(value = "id") Long id) {
        bookRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Long id, Model model) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent()) {
            model.addAttribute("book", bookOptional.get());
            return "update-book";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable(value = "id") Long id,
                         @RequestParam String title,
                         @RequestParam String author,
                         @RequestParam String genre,
                         @RequestParam Integer pages) {
        Book book = new Book(id,title,author,genre,pages);
        bookRepository.save(book);

        return "redirect:/";
    }
}
