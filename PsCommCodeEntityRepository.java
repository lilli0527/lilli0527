package com.example.Pawsome.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Pawsome.entity.PsCommCodeEntity;
import com.example.Pawsome.entity.PsCommCodePKEntity;

@Repository
public interface PsCommCodeEntityRepository extends JpaRepository<PsCommCodeEntity, PsCommCodePKEntity> {

    public Optional<PsCommCodeEntity> findByTypeAndCommCode(String type, String commcode);
    
    public List<PsCommCodeEntity> findByType(String type);

}
