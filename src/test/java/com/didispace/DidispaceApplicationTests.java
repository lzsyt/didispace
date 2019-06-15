package com.didispace;

import com.didispace.domain.Customer;
import com.didispace.domain.Image;
import com.didispace.mapper.CustomerMapper;
import com.didispace.service.IImageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DidispaceApplicationTests {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    IImageService iImageService;

    @Test
    public void contextLoads() {
        Image image = new Image();
        image.setImageType("1");
        List<Image> adImages = iImageService.selectListByCondition(image);
    }

    @Test
    public void test(){
        String dateTime = "2019-04-15";
        int first = dateTime.indexOf("-");
        int last = dateTime.lastIndexOf("-");
        String yeas = dateTime.substring(0, first);
        String month = dateTime.substring(first+1, last);
        String day = dateTime.substring(last+1, dateTime.length());
    }

}
