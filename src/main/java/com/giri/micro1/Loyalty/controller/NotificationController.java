//package com.giri.micro1.Loyalty.controller;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.giri.micro1.Loyalty.dao.UserDao;
//import com.giri.micro1.Loyalty.model.User;
//import com.giri.micro1.Loyalty.service.EmailService;
//
//@RestController
//@RequestMapping("/notifications")
//public class NotificationController {
//	
//	 @Autowired
//	    private EmailService emailService;
//	 
//	 @Autowired
//	 private UserDao userdao;
//
//	    @GetMapping("/send")
//	    public String sendNotificationEmails(@RequestParam String productName) {
//	        // Fetch all users (implement this method based on your data source)
//	        List<User> users = userdao.listAllUser();
//	        
//
//	        // Extract email addresses
//	        List<String> emails = users.stream()
//	                                   .map(User::getEmail)
//	                                   .collect(Collectors.toList());
//	        // Send email to each user
//	        for (String email : emails) {
//	            emailService.sendSimpleMessage(
//	                email,
//	                "New Product Added",
//	                "Hello,\n\nA new product, " + productName + ", has been added to our catalog.\n\nBest regards,\nYour Company"
//	            );
//	        }
//
//	        return "Emails sent successfully";
//	    }
//
//	   
//
//}
