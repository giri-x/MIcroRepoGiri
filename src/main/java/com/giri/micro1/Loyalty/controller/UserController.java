package com.giri.micro1.Loyalty.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.giri.micro1.Loyalty.model.User;
import com.giri.micro1.Loyalty.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/registerUser")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            
            if (user.getEmail() == null || user.getPassword() == null || user.getPhoneNo() == null  || user.getUserName() == null) {
                return ResponseEntity.badRequest().body("All fields are required.");
            }
 
            
            service.addUser(user);
 
            return ResponseEntity.ok("User registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Error occurred during registration: " + e.getMessage());
        }
    }
 
    @PostMapping("/loginUser")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            // Find the  by email
            Optional<User> userOptional = service.findbyemail(user.getEmail());
            if (!userOptional.isPresent()) {
                return ResponseEntity.badRequest().body("Invalid email");
            }
 
            User userFound = userOptional.get();
            Map<String, Long> map=new HashMap<>();
            map.put("userId", userFound.getUserId());
 
            // Check if password matches
            if (!user.getPassword().equals(userFound.getPassword())) {
                return ResponseEntity.badRequest().body("Invalid password");
            }
 
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Error occurred during login: " + e.getMessage());
        }
    }
    
    @GetMapping("/userLogin/{email}/{password}	")
	public ResponseEntity<?>  validateLogin(@PathVariable("email") String email, @PathVariable("password") String password) {
		try {
			Optional<User> user=service.UserLogin(email, password);
			if(user != null) {
				System.out.println("tHE"+user.get().getUserId());
				return ResponseEntity.ok(user.get().getUserId());
				
			}
		
		} catch (Exception e) {
			
		}
		
		return (ResponseEntity<?>) ResponseEntity.badRequest();
	}
    
	@GetMapping("/findAllUser")
	public List<User> findAllUser() {
		return service.findAllUser();
	}
	

    @PutMapping("/users/{userId}/totalAmount")
    public ResponseEntity<String> updateTotalAmount(@PathVariable("userId") Long userId,
                                                     @RequestParam("totalAmount") Double totalAmount) {
        try {
            service.updateTotalAmount(userId, totalAmount);
            return ResponseEntity.ok("Total amount updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating total amount: " + e.getMessage());
        }
    }
    
    @PutMapping("/users/{userId}/rewardCoins")
    public ResponseEntity<String> updateRewardCoins(@PathVariable("userId") Long userId,
                                                     @RequestParam("rewardCoins") Double rewardCoins) {
        try {
            service.updateRewardCoins(userId, rewardCoins);
            return ResponseEntity.ok("Total rewardCoins updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating total amount: " + e.getMessage());
        }
    }
    
//    @GetMapping("/users/rewardCoins/{email}")
//    public ResponseEntity<Double> getRewardCoins(@PathVariable("userId") Long userId) {
//        try {
//            Double rewardCoins = service.getRewardCoins(userId);
//            if (rewardCoins != null) {
//                return ResponseEntity.ok(rewardCoins);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(null);
//        }
//    }
    
//  @GetMapping("/users/rewardCoins/{email}")
//  public ResponseEntity<Double> getRewardCoins(@PathVariable("email") String email) {
//      try {
//          Double rewardCoins = service.getRewardCoins(email);
//          if (rewardCoins != null) {
//              return ResponseEntity.ok(rewardCoins);
//          } else {
//              return ResponseEntity.notFound().build();
//          }
//      } catch (Exception e) {
//          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                  .body(null);
//      }
//  }
	
//  @GetMapping("/rewardCoins/{email}")
//  public ResponseEntity<Double> getRewardCoins(@PathVariable("email") String email) {
//      try {
//          Double rewardCoins = service.getRewardCoins(email);
//          if (rewardCoins != null) {
//              return ResponseEntity.ok(rewardCoins);
//          } else {
//              return ResponseEntity.notFound().build();
//          }
//      } catch (Exception e) {
//          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                  .body(null);
//      }
//  }
    
    @GetMapping("/rewardCoins/{email}")
    public ResponseEntity<Double> getRewardCoins(@PathVariable("email") String email) {
        try {
            Double rewardCoins = service.getRewardCoins(email);
            if (rewardCoins != null) {
                return ResponseEntity.ok(rewardCoins);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/loginCust/{email}/{userPassword}")
	public User loginCust(@PathVariable("email") String email,
			@PathVariable("userPassword") String password) {
 
		return service.custLogin(email, password);
 
	}
    
    
 
}
