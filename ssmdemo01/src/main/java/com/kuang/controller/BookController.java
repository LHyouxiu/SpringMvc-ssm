package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

//    @Autowired
//    @Qualifier("BookServiceImpl")
//    private BookService bookService;
    private final BookService bookService;

    public BookController(@Qualifier("BookServiceImpl") BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);

        return "allBook";
    }

//    新增内容
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books){
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

//    修改内容
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id){
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book",books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book){
        System.out.println(book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books",books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

}



