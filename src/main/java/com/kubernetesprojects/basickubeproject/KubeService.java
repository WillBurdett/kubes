package com.kubernetesprojects.basickubeproject;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KubeService {

  @Autowired
  private KubeRepository kubeRepository;

  public List<Kube> getAllKubes() {
    return kubeRepository.findAll();
  }

  public Optional<Kube> getKubeById(Long id) {
    return kubeRepository.findById(id);
  }

  public void createKube(Kube kube) {
    kubeRepository.save(kube);
  }

  public void deleteKube(Long id) {
    kubeRepository.deleteById(id);
  }
}
