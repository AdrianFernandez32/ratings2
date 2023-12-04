package com.cetys.rating.DAO.Entities;

import java.sql.Date;

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
    private int privacidad;

    @Column(name = "limpieza")
    private int limpieza;

    @Column(name = "comodidad")
    private int comodidad;

    @Column(name = "espacio")
    private int espacio;

    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "restroom")
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
    public int getPrivacidad() {
        return privacidad;
    }

    // Setter para privacidad
    public void setPrivacidad(int privacidad) {
        this.privacidad = privacidad;
    }

    // Getter para limpieza
    public int getLimpieza() {
        return limpieza;
    }

    // Setter para limpieza
    public void setLimpieza(int limpieza) {
        this.limpieza = limpieza;
    }

    // Getter para comodidad
    public int getComodidad() {
        return comodidad;
    }

    // Setter para comodidad
    public void setComodidad(int comodidad) {
        this.comodidad = comodidad;
    }

    // Getter para espacio
    public int getEspacio() {
        return espacio;
    }

    // Setter para espacio
    public void setEspacio(int espacio) {
        this.espacio = espacio;
    }

    // Getter para fecha
    public Date getFecha() {
        return fecha;
    }

    // Setter para fecha
    public void setFecha(Date fecha) {
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
