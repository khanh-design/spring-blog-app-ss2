package com.example.springblogappss2.formatter;

import com.example.springblogappss2.model.Blog;
import com.example.springblogappss2.service.IBlogService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class FormatterBlog implements Formatter<Blog> {
    private final IBlogService blogService;

    public FormatterBlog(IBlogService blogService) {
        this.blogService = blogService;
    }

    @Override
    public Blog parse(String text, Locale locale) throws ParseException {
        Optional<Blog> blogOptional = blogService.findById(Long.parseLong(text));
        return blogOptional.orElse(null);
    }

    @Override
    public String print(Blog object, Locale locale) {
        return "[" + object.getId() + ", " +object.getTitle() + ", " + object.getContent() + "]";
    }
}

