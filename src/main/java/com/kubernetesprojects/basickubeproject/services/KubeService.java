package com.kubernetesprojects.basickubeproject.services;

import com.kubernetesprojects.basickubeproject.exceptions.ZeroOrNegativeDimensionsNotAllowed;
import com.kubernetesprojects.basickubeproject.models.Kube;
import com.kubernetesprojects.basickubeproject.repositories.KubeRepository;
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

  public void alterKubes(Long id, String arithmeticOperator) {
    Optional<Kube> optionalKube = kubeRepository.findById(id);

    if (optionalKube.isPresent()){
      Kube kube = optionalKube.get();
      int currentWidth = convertDimensionsToInt(kube.getDimensions());
      switch (arithmeticOperator){
        case "+":
          currentWidth++;
          break;
        case "-":
          currentWidth--;
          break;
        }
       if (currentWidth <= 0){
         throw new ZeroOrNegativeDimensionsNotAllowed("Cannot perform operation as dimensions would equal or fall "
             + "below zero");
       }

      kube.setDimensions(String.format("%sx%s", currentWidth, currentWidth));
      kubeRepository.save(kube);
      }
    }

    public int convertDimensionsToInt(String dimensions){
      String[] strArr = dimensions.split("x");
      return Integer.parseInt(strArr[0]);
    }

}
