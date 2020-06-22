package kr.ac.jejunu.user.Controller;

import kr.ac.jejunu.user.DTO.Post;
import kr.ac.jejunu.user.DAO.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.logging.Logger;

@Controller
//@RequiredArgsConstructor
public class PostController {
    @Autowired
    private PostDao postDao;

    @RequestMapping(path="/post")
    public Post getUser(@RequestParam("id") Integer id){
        return postDao.get(id);
    }


    @RequestMapping("/start")
    public ModelAndView startHtml(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("url", "/WEB-INF/static/startimg.jpg");
        return modelAndView;
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute Post post){
        System.out.println(postDao.toString());
        postDao.insert(post);
        return "/start";
    }

    @RequestMapping("/upload")
    public void upload() {

    }

}
