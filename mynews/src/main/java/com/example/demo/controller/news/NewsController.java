package com.example.demo.controller.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.entity.news.News;
import com.example.demo.domain.form.NewsEditForm;
import com.example.demo.domain.form.news.NewsCreateForm;
import com.example.demo.domain.service.news.NewsCreateService;
import com.example.demo.domain.service.news.NewsDeleteService;
import com.example.demo.domain.service.news.NewsEditService;
import com.example.demo.domain.service.news.NewsListService;

@Controller
public class NewsController {

    @GetMapping("/news/create")
    public String create(@ModelAttribute("form") NewsCreateForm newsCreateForm) {
        return "news/create";
    }
    
    @Autowired
    private NewsCreateService newsCreateService;
    
    @PostMapping("/news/create")
    public String create(@Validated @ModelAttribute("form") NewsCreateForm newsCreateForm,
            BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "news/create";
        }

        newsCreateService.create(newsCreateForm);

        return "redirect:/news/create/complete";
    }
    
    @GetMapping("/news/create/complete")
    public String complete() {
        return "news/complete";
    }
    
    @Autowired
    private NewsListService newsListService;
    
    @GetMapping("/news/list")
    public String list(@RequestParam(name = "title", required = false) String title, Model model) {

        List<News> newsList = newsListService.list(title);
        model.addAttribute("newsList", newsList);
        model.addAttribute("title", title);

        return "news/list";
    }
    
    @Autowired
    private NewsEditService newsEditService;

    @GetMapping("/news/edit/{id}")
    public String edit(@PathVariable int id,
                       @ModelAttribute("form") NewsEditForm form,
                       Model model) {

        model.addAttribute("news", newsEditService.findById(id));
        return "news/edit";
    }

    @PostMapping("/news/edit/{id}")
    public String edit(@PathVariable int id,
                       @Validated @ModelAttribute("form") NewsEditForm form,
                       BindingResult result,
                       Model model) {

        if (result.hasErrors()) {
            model.addAttribute("news", newsEditService.findById(id));
            return "news/edit";
        }

        newsEditService.edit(id, form);
        return "redirect:/news/edit/complete";
    }

    
    @Autowired
    private NewsDeleteService newsDeleteService;
    
    @PostMapping("/news/delete")
    public String delete(@RequestParam(name = "id", required = true) int id, Model model) {
        newsDeleteService.delete(id);
        return "redirect:/news/list";
    }
}
