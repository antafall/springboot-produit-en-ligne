package com.example.produitEnLigne.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable= false)
	private long id;
	private String name;
	private String desciption;
	private double prixActuel;
	private boolean promotion;
	private boolean produitSelectionne;
	private boolean disponible;
	private String nomPhoto;
	@ManyToOne
	private Category category;
	public Product(String name, String desciption, double prixActuel, boolean promotion, boolean produitSelectionne,
			boolean disponible, String nomPhoto, Category category) {
		super();
		this.name = name;
		this.desciption = desciption;
		this.prixActuel = prixActuel;
		this.promotion = promotion;
		this.produitSelectionne = produitSelectionne;
		this.disponible = disponible;
		this.nomPhoto = nomPhoto;
		this.category = category;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public double getPrixActuel() {
		return prixActuel;
	}
	public void setPrixActuel(double prixActuel) {
		this.prixActuel = prixActuel;
	}
	public boolean isPromotion() {
		return promotion;
	}
	public void setPromotion(boolean promotion) {
		this.promotion = promotion;
	}
	public boolean isProduitSelectionne() {
		return produitSelectionne;
	}
	public void setProduitSelectionne(boolean produitSelectionne) {
		this.produitSelectionne = produitSelectionne;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public String getNomPhoto() {
		return nomPhoto;
	}
	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", desciption=" + desciption + ", prixActuel=" + prixActuel + ", promotion="
				+ promotion + ", produitSelectionne=" + produitSelectionne + ", disponible=" + disponible
				+ ", nomPhoto=" + nomPhoto + ", category=" + category + "]";
	}
	
	

}
