package com.example.testdemauj6.service;

import com.example.testdemauj6.dto.NhanVienDto;
import com.example.testdemauj6.dto.NhanVienRequest;
import com.example.testdemauj6.entity.entity.NhanVien;
import com.example.testdemauj6.repos.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVienDto> getAll() {
        return nhanVienRepository.getAll();
    }

    public Page<NhanVien> getAllNV(int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return nhanVienRepository.findAll(pageable);
    }

    public NhanVien add(NhanVien nhanVien){
        return nhanVienRepository.save(nhanVien);
    }

    public NhanVien addNV(NhanVienRequest nhanVien){
        NhanVien nv = nhanVien.dto(new NhanVien());
        return nhanVienRepository.save(nv);
    }

    public Boolean delete(int id){
        Optional<NhanVien> optional = nhanVienRepository.findById(id);
        if(optional.isPresent()){
            NhanVien nv = optional.get();
            nhanVienRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
