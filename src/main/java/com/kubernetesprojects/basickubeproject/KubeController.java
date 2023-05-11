package com.kubernetesprojects.basickubeproject;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kube")
public class KubeController {

  @Autowired
  private KubeService kubeService;

  @GetMapping
  public List<Kube> getAllKubes(){
    return kubeService.getAllKubes();
  }

  @GetMapping
  @RequestMapping("/{id}")
  public Optional<Kube> getKubeById(@PathVariable Long id){
    return kubeService.getKubeById(id);
  }

  @PostMapping
  public void createKube(@RequestBody Kube kube){
    kubeService.createKube(kube);
  }

  @DeleteMapping
  @RequestMapping("/1/{id}")
  public void deleteKube(@PathVariable Long id){
    kubeService.deleteKube(id);
  }
}
