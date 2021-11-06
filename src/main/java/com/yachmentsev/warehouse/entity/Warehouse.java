package com.yachmentsev.warehouse.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "warehouse")
@Data//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor//ломбок аннотация: конструктор без аргуметов
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouse")
    //private List<Pipe> pipeList;


    //public Warehouse(int id, String name, List<Pipe> pipeList) {
    //    this.id = id;
    //    this.name = name;
    //    this.pipeList = pipeList;
    //}

    //public int getId() {
   //     return id;
    //}

    //public void setId(int id) {
    //    this.id = id;
    //}

    //public String getName() {
    //    return name;
    //}

    //public void setName(String name) {
    //    this.name = name;
    //}

    //public List<Pipe> getPipeList() {
    //    return pipeList;
    //}

    //public void setPipeList(List<Pipe> pipeList) {
   //     this.pipeList = pipeList;
   // }
}