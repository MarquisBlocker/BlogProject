package com.techtalentsouth.TechTalentBlog.service;

import com.techtalentsouth.TechTalentBlog.BlogPost.BlogPost;
import com.techtalentsouth.TechTalentBlog.Repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    @Autowired
    BlogPostRepository blogPostRepository;

//    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
//        this.blogPostRepository = blogPostRepository;
//    }

    @Override
    public BlogPost addNewBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @Override
    public Iterable<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    @Override
    public void deletePostById(Long id) {
        blogPostRepository.deleteById(id);
    }

    @Override
    public BlogPost findBlogPostsById(Long id) {
        return blogPostRepository.findById(id).orElseThrow();
    }

    @Override
    public BlogPost editBlogPostsById(Long id, BlogPost blogPost) {
        BlogPost foundPost = findBlogPostsById(id);
        // now we need to edit our object
        foundPost.setBlogEntry(blogPost.getBlogEntry());
        foundPost.setAuthor(blogPost.getAuthor());
        foundPost.setTitle(blogPost.getTitle());
        return addNewBlogPost(foundPost);
    }

}

