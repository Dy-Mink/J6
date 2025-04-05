package com.example.testdemauj6.repos;

import com.example.testdemauj6.dto.NhanVienDto;
import com.example.testdemauj6.entity.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
    @Query(value = "select nv.ma_nhan_vien,nv.ho_ten,nv.luong,cv.ma_chuc_vu,cv.ten_chuc_vu \n" +
            "from nhan_vien nv join chuc_vu cv on nv.id_chuc_vu = cv.id\n", nativeQuery = true)

    List<NhanVienDto> getAll();

}