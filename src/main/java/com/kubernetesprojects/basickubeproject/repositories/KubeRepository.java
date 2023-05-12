package com.kubernetesprojects.basickubeproject.repositories;

import com.kubernetesprojects.basickubeproject.models.Kube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KubeRepository extends JpaRepository <Kube, Long> {}
