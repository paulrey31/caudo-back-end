package com.caudo.caudo_back_end.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class Solution {

    @Id
    private String id;

    @ElementCollection
    private List<Integer> solution;

    private String status;

    // Getters et setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public List<Integer> getSolution() { return solution; }
    public void setSolution(List<Integer> solution) { this.solution = solution; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}