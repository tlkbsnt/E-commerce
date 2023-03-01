package fr.bsnt.service;

import fr.bsnt.model.Admin;
import fr.bsnt.model.Users;
import fr.bsnt.repository.AdminRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
    }
    public Admin getById(Long id){
        return adminRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Admin not fount"+id));
    }
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
    public Admin updateAdmin(Long id, Admin admin){
        Admin adminById = adminRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Admin not found"+id));
        adminById.setAdmin_name(admin.getAdmin_name());
        adminById.setEmail(admin.getEmail());
        adminById.setPassword(admin.getPassword());

        return adminById;
    }
    public void deleteById(Long id){
        if(adminRepository.findById(id) != null) {
            adminRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Admin not found" + id);
        }
    }
}
