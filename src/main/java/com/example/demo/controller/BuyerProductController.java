package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@RestController这个注解其实就是@ResponseBody和@Controller注解的组合而已*/
/*相当于整个类中所有方法的返回值都为json字符串 */
@RestController
/* @RequestMapping是Spring Web应用程序中最常被用到的注解之一。
这个注解会将HTTP请求映射到MVC和REST控制器的处理方法上。  */
@RequestMapping("/buyer/product")
public class BuyerProductController {



}
