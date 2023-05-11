package com.kubernetesprojects.basickubeproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KubeRepository extends JpaRepository <Kube, Long> {}
