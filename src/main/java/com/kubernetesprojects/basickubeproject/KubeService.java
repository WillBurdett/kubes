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

  public void addKubes(Long id) {
    Optional<Kube> optionalKube = kubeRepository.findById(id);

    if (optionalKube.isPresent()){
      Kube kube = optionalKube.get();
      String currentDimensions = kube.getDimensions();
      String[] arr = currentDimensions.split("x");
      String str = String.format("%sx%s", Integer.parseInt(arr[0])+1,Integer.parseInt(arr[1])+1);
      kube.setDimensions(str);
      kubeRepository.save(kube);
    }
  }
}
