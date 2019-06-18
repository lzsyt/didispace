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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller
@SessionAttributes(value = {"contact"})
public class Controller {
    @Autowired
    private IImageService iImageService;
    @Autowired
    private ContactService contactService;
    @Autowired
    private IQuestionService questionService;
    @Autowired
    private ICustomerService customerService;


    @ModelAttribute("contact")
    public Contact getUser() {
        Contact contact = contactService.find();
        return contact;

    }


    /**
     * 主页
     *
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(Map<String, Object> map, Model model) {
        Image image = new Image();
        image.setImageType("1");
        List<Image> adImages = iImageService.selectListByCondition(image);
        model.addAttribute("adimg", adImages);
        model.addAttribute("contact", map.get("contact"));
        return "index";
    }

    /**
     * 企业文化
     *
     * @param model
     * @return
     */
    @RequestMapping("/aboutus")
    public String aboutus(Map<String, Object> map,Model model) {
        Image image = new Image();
        //关于我们的图片
//        logger.info("企业文化");
        image.setImageType("4");
        List<Image> aboutImage = iImageService.selectListByCondition(image);
        model.addAttribute("aboutimgs", aboutImage);
        model.addAttribute("contact", map.get("contact"));
        return "aboutus";
    }

    /**
     * 联系我们
     *
     * @param model
     * @return
     */
    @RequestMapping("/contact")
    public String contact(Map<String, Object> map,Model model) {
        model.addAttribute("contact", map.get("contact"));
        return "contact";
    }

    /**
     * 产品列表
     *
     * @param model
     * @return
     */
    @RequestMapping("/products")
    public String products(Map<String, Object> map,Model model, String productType) {
        Image image = new Image();
        if (StringUtil.isNotEmpty(productType)) {
            image.setProductType(Integer.valueOf(productType));
            if (productType.equals("2")) {
                model.addAttribute("type", "光合硅能");
            }
            if (productType.equals("3")) {
                model.addAttribute("type", "太阳能电池板");
            }
        } else {
            image.setProductType(2);
            model.addAttribute("type", "光合硅能");
        }
        image.setImageType("5");
        List<Image> mainImages = iImageService.selectListByCondition(image);
        model.addAttribute("imageList", mainImages);
        model.addAttribute("contact", map.get("contact"));
        return "products";
    }

    /**
     * 技术支持
     */
    @RequestMapping("/technology")
    public String technology(Map<String, Object> map,Model model) {
        //常见功能
        List<Question> questions = questionService.selectList();
        //电池养护
        List<Question> introduces = questionService.findIntroduce();

        model.addAttribute("introduce",questions);
        model.addAttribute("questions", introduces);
        model.addAttribute("contact", map.get("contact"));
        return "technology";
    }

    /**
     * 经典案例
     * @param map
     * @param model
     * @return
     */
    @RequestMapping("/classicCase")
    public String classicCase(Map<String, Object> map,Model model) {
        Image image = new Image();
        image.setImageType("3");
        //查询案例
        List<Image> caseImage = iImageService.selectListByCondition(image);
        model.addAttribute("caseImgs", caseImage);
        model.addAttribute("contact", map.get("contact"));
        return "case";

    }

    /**
     *  地图
     * @param map
     * @param model
     * @return
     */
    @RequestMapping("map")
    public String map(Map<String, Object> map,Model model){
        model.addAttribute("contact", map.get("contact"));
        return "map";
    }

    /*添加客户*/
    @RequestMapping("/customer")
    @ResponseBody
    public String customer(HttpServletRequest request, String phone, String name, String message, String website){
      Customer customer=new Customer();
      customer.setName(name);
      customer.setMessage(message);
      customer.setMobile(phone);
      customer.setWebsite(website);
      customer.setRegisterTime(new Date());

      //获取IP和真实地址
      try {
        String ip = NetworkUtil.getIpAddress(request);
        String adress = AddressUtil.getAdress(ip);
        customer.setIp(ip);
        customer.setAddress(adress);
      } catch (IOException e) {
        e.printStackTrace();
      }

      customerService.insert(customer);
      return "success";
    }

}
