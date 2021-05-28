package com.techtalentsouth.TechTalentBlog.Controller;


import com.techtalentsouth.TechTalentBlog.BlogPost.BlogPost;
import com.techtalentsouth.TechTalentBlog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blogposts")
public class BlogPostController {

    @Autowired
    BlogPostService blogPostService;


//    public BlogPostController(BlogPostService blogPostService) {
//        this.blogPostService = blogPostService;
//    }

    @GetMapping
    public String index(BlogPost blogPost, Model model) {
        model.addAttribute("posts", blogPostService.getAllBlogPosts());
        // this return value is a reference to a template
        // it will not literally return a string value
        return "blogpost/index";
    }

    @GetMapping("/new")
    public String newBlog(BlogPost blogPost) {
        return "blogpost/new";
    }

    @PostMapping
    public String addNewBlogPost(BlogPost blogPost, Model model) {
        blogPostService.addNewBlogPost(blogPost);
        model.addAttribute("title", blogPost.getTitle());
        model.addAttribute("author", blogPost.getAuthor());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());
        return "blogpost/result";
    }

    // method to check orderby methods
//    @GetMapping("/json")
//    @ResponseBody
//    public Iterable<Book> getAllDesc() {
//        return blogPostRepository.findByOrderByTitleAsc();
//    }

    @DeleteMapping("/{id}")
    public String deletePostWithId(@PathVariable Long id, BlogPost blogPost) {
        blogPostService.deletePostById(id);
        return "redirect:/blogposts";
    }

    @GetMapping("/{id}")
    public String editPostWithId(@PathVariable Long id,
                                 BlogPost blogPost,
                                 Model model){

        BlogPost foundPost = blogPostService.findBlogPostsById(id);
        model.addAttribute("blogPost", foundPost);

        return "blogpost/edit";
    }

    @PostMapping("/update/{id}")
    public String updateExistingPost(@PathVariable Long id,
                                     BlogPost blogPost,
                                     Model model){
        BlogPost editedPost = blogPostService.editBlogPostsById(id, blogPost);
        model.addAttribute("blogPost", editedPost);
        model.addAttribute("title", blogPost.getTitle());
        model.addAttribute("author", blogPost.getAuthor());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());
        return "blogpost/result";
    }


}

