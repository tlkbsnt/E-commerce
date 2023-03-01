package fr.bsnt.controller;

import fr.bsnt.model.Admin;
import fr.bsnt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    public List<Admin> getAllAdmin(){
        return adminService.getAllAdmin();
    }
    @GetMapping("/{id}")
    public Admin getUserById(@PathVariable Long id) {
        return adminService.getById(id);
    }
    @PostMapping
    public Admin createUser(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }
    @PutMapping("/update/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        return adminService.updateAdmin(id, admin);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteById(id);
    }
}
