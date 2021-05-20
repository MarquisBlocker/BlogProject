package com.techtalentsouth.TechTalentBlog.service;

import com.techtalentsouth.TechTalentBlog.BlogPost.BlogPost;
import com.techtalentsouth.TechTalentBlog.Repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogPostServiceImpl implements BlogPostService{

    @Autowired
    BlogPostRepository blogPostRepository;



    @Override
    public BlogPost addNewBlogPost(BlogPost blogPost){
        return blogPostRepository.save(blogPost);
    }
}
