package com.example.customermanagememt.controller;

import com.example.customermanagememt.model.Customer;
import com.example.customermanagememt.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AppController {
    private final CustomerService customerService;

    @GetMapping("/customers")
    public String customers(Model model) {
        model.addAttribute("title", "Manage Customer");
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("size", customers.size());
        model.addAttribute("customerNew", new Customer());
        return "customers";
    }

    @PostMapping("/save-customer")
    public String save(@ModelAttribute("customerNew") Customer customer, RedirectAttributes redirectAttributes) {
        try {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("success", "Add successfully!");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "Duplicate, please check again!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error server");
        }
        return "redirect:/customers";
    }

    @RequestMapping(value = "/delete-customer", method = RequestMethod.GET)
    public String deleteCustomer(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            customerService.delete(id);
            redirectAttributes.addFlashAttribute("success", "Delete successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error deleting customer");
        }
        return "redirect:/customers";
    }
}

