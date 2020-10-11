package com.t1809e.rms.repository;

import com.t1809e.rms.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {
    @Query("SELECT m from Menu as m JOIN m.roles as r WHERE r.id = (?1)")
    List<Menu> findAllByRoles(String roleName);
}
