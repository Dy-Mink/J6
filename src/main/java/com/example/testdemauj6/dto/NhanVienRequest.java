package com.example.testdemauj6.dto;

import com.example.testdemauj6.entity.entity.ChucVu;
import com.example.testdemauj6.entity.entity.NhanVien;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NhanVienRequest {

    @NotBlank(message = "k dc de trong")
    private String ma;

    private String ten;

    private Double luong;

    private String idCV;

    public NhanVien dto(NhanVien nhanVien){
        nhanVien.setMa(this.getMa());
        nhanVien.setTen(this.getTen());
        nhanVien.setLuong(this.getLuong());
        nhanVien.setChucVu(ChucVu.builder().idCV(Integer.valueOf(this.idCV)).build());

        return nhanVien;
    }
}
