package com.techtalentsouth.TechTalentBlog.service;

import com.techtalentsouth.TechTalentBlog.BlogPost.BlogPost;

import java.util.Optional;

//this service is going to serve as a contract for our implementation
public interface BlogPostService {

    BlogPost addNewBlogPost(BlogPost blogPost);
}
