package cn.yzx.community.controller;

import cn.yzx.community.mapper.blogMapper;
import cn.yzx.community.pojo.blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;

@Controller
@RequestMapping("/publish")
public class publishController {

    @Autowired
    private blogMapper mapper;

    @GetMapping
    public String publish() {
        return "publish";
    }

    @PostMapping
    public String addBlog(@RequestParam(defaultValue = "暂无标题") String title,
                          @RequestParam String value,
                          @RequestParam String tag,
                          @RequestParam(defaultValue = "https://unsplash.it/800/600?image=1050") String firstImg) {
        blog b = new blog();
        b.setTitle(title);
        b.setValue(value);
        b.setTag(tag);
        b.setFirstImg(firstImg);
        b.setCreateTime(new Date(System.currentTimeMillis()));
        b.setModifyTime(b.getCreateTime());
        mapper.addBlog(b);
        return "redirect:/";
    }

}
