package com.kuang.service;

import com.kuang.pojo.Books;

import java.util.List;

public interface BookService {

    //    增加书
    int addBook(Books books);
    //    删除书
    int deleteBookById(int id);
    //    修改书
    int updateBook(Books books);
    //    查询 根据id查询
    Books queryBookById(int id);
    //    查询全部 返回list一个集合
    List<Books> queryAllBook();

}
