package com.example.testdemauj6.contro;

import com.example.testdemauj6.dto.NhanVienDto;
import com.example.testdemauj6.dto.NhanVienRequest;
import com.example.testdemauj6.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nhan-vien")
public class NhanVienContro {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(nhanVienService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> page(@RequestParam(defaultValue = "0",name = "page") int page) {
        return ResponseEntity.ok(nhanVienService.getAllNV(page));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody NhanVienRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            return ResponseEntity.ok(errors);
        }else{
            return ResponseEntity.ok(nhanVienService.addNV(request));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (nhanVienService.delete(id)) {
            return ResponseEntity.ok("Delete success");
        }else{
            return ResponseEntity.ok("Delete failed");
        }
    }
}
