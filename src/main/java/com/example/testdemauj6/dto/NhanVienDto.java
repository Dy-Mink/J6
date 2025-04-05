package com.example.testdemauj6.dto;

import jakarta.validation.constraints.NotBlank;

public interface NhanVienDto {

    String getMaNhanVien();

    String getHoTen();

    Double getLuong();

    String getMaChucVu();

    String getTenChucVu();
}
