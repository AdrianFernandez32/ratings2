package com.cetys.rating.DAO.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rating", schema = "public")
public class RatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private int ratingId;

    @Column(name = "privacidad")
    private String privacidad;

    @Column(name = "limpieza")
    private String limpieza;

    @Column(name = "comodidad")
    private String comodidad;

    @Column(name = "espacio")
    private String espacio;

    @Column(name = "fecha")
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "restroom_id")
    private RestroomEntity restroom;

    // Getter para ratingId
    public int getRatingId() {
        return ratingId;
    }

    // Setter para ratingId
    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    // Getter para privacidad
    public String getPrivacidad() {
        return privacidad;
    }

    // Setter para privacidad
    public void setPrivacidad(String privacidad) {
        this.privacidad = privacidad;
    }

    // Getter para limpieza
    public String getLimpieza() {
        return limpieza;
    }

    // Setter para limpieza
    public void setLimpieza(String limpieza) {
        this.limpieza = limpieza;
    }

    // Getter para comodidad
    public String getComodidad() {
        return comodidad;
    }

    // Setter para comodidad
    public void setComodidad(String comodidad) {
        this.comodidad = comodidad;
    }

    // Getter para espacio
    public String getEspacio() {
        return espacio;
    }

    // Setter para espacio
    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }

    // Getter para fecha
    public String getFecha() {
        return fecha;
    }

    // Setter para fecha
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    // Getter para restroom
    public RestroomEntity getRestroom() {
        return restroom;
    }

    // Setter para restroom
    public void setRestroom(RestroomEntity restroom) {
        this.restroom = restroom;
    }
}
