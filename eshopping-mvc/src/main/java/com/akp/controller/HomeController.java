package com.akp.controller;

import com.akp.model.Product;
import com.akp.model.User;
import com.akp.service.ProductService;
import com.akp.service.UserService;
import com.akp.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

/**
 * @author Aashish Patel
 */
@Controller
public class HomeController {

    private static final int INITIAL_PAGE = 0;

    private final ProductService productService;

    private final UserService userService;

    @Autowired
    public HomeController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public ModelAndView home(@RequestParam("page") Optional<Integer> page, Principal principal) {

        /**
         * Evaluate page. If requested parameter is null or less than 0 (to
         * prevent exception), return initial size. Otherwise, return value of
         * param. decreased by 1.
         * */
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        /* Filtering the products based on customer region */
        Optional<User> user = userService.findByUsername(principal.getName());
        Page<Product> products = productService.findAllProductsByRegionPageable(user.get().getCustomer().getRegion(),
                PageRequest.of(evalPage, 5));
        Pager pager = new Pager(products);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", products);
        modelAndView.addObject("pager", pager);
        modelAndView.setViewName("/home");
        return modelAndView;
    }

}
