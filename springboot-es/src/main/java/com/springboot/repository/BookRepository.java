package com.springboot.repository;

import com.springboot.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 17:23 2020/12/6
 * @ Description：
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
}
