package com.didispace.web;

import com.didispace.common.util.AddressUtil;
import com.didispace.common.util.NetworkUtil;
import com.didispace.domain.Contact;
import com.didispace.domain.Customer;
import com.didispace.domain.Image;
import com.didispace.domain.Question;
import com.didispace.service.ContactService;
import com.didispace.service.ICustomerService;
import com.didispace.service.IImageService;
import com.didispace.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("windenergy")
public class WindEnergyController {
    @Autowired
    private IImageService iImageService;
    @Autowired
    private ContactService contactService;
    @Autowired
    private IQuestionService questionService;


    private void getContact(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("contact") != null) {
            model.addAttribute("contact", request.getSession().getAttribute("contact"));
        } else {
            Contact contact = contactService.find();
            model.addAttribute("contact", contact);
            request.getSession().setAttribute("contact", contact);
        }
    }


    /**
     * 主页
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {
        Image image = new Image();
        image.setImageType("11");
        List<Image> adImages = iImageService.selectListByCondition(image);

//        for (int i = adImages.size()-1; i >=0 ; i--) {
//            if (adImages.get(i).getEnFileName()==null){
//                adImages.remove(i);
//            }
//        }
        model.addAttribute("adimg", adImages);
        Contact contact = contactService.find();
        model.addAttribute("contact", contact);
        request.getSession().setAttribute("contact", contact);
        return "windenergy/index";
    }

    /**
     * 企业文化
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/aboutus")
    public String aboutus(HttpServletRequest request, Model model) {
        Image image = new Image();
        //关于我们的图片
//        logger.info("企业文化");
        image.setImageType("13");
        List<Image> aboutImage = iImageService.selectListByCondition(image);
        int index = 0;
        for (int i = 0; i < aboutImage.size(); i++) {
            if (aboutImage.get(i).getFileName().equals("20190419124013.jpg")) {
                index = i;
            }
        }
        List<Image> imageList = new ArrayList<>();
        imageList.add(aboutImage.get(index));
        aboutImage = null;
        model.addAttribute("aboutimgs", imageList);
        getContact(request, model);
        return "windenergy/aboutus";
    }

    /**
     * 联系我们
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/contact")
    public String contact(HttpServletRequest request, Model model) {
        getContact(request, model);
        return "windenergy/contact";
    }


    /**
     * 产品列表
     *
     * @param request
     * @param model
     * @param productType
     * @return
     */
    @RequestMapping("/products")
    public String products(HttpServletRequest request, Model model, String productType) {
        Image image = new Image();
        image.setImageType("5");
        image.setProductType(4);
        List<Image> mainImages = iImageService.selectListByCondition(image);
        model.addAttribute("imageList", mainImages);
        getContact(request, model);
        return "windenergy/products";
    }

    /**
     * 技术支持
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/technology")
    public String technology(HttpServletRequest request, Model model) {
        //常见功能
        List<Question> questions = questionService.selectList();
        //电池养护
        List<Question> introduces = questionService.findIntroduce();

        model.addAttribute("introduce", questions);
        model.addAttribute("questions", introduces);
        getContact(request, model);
        return "windenergy/technology";
    }

    /**
     * 经典案例
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/classicCase")
    public String classicCase(HttpServletRequest request, Model model) {
        Image image = new Image();
        image.setImageType("12");
        //查询案例
        List<Image> caseImage = iImageService.selectListByCondition(image);
        model.addAttribute("caseImgs", caseImage);
        getContact(request, model);
        return "windenergy/case";

    }

    /**
     * 地图
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("map")
    public String map(HttpServletRequest request, Model model) {
        getContact(request, model);
        return "windenergy/map";
    }


}
