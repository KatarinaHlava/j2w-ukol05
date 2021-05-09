package cz.czechitas.java2webapps.ukol5.controller;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.Period;
import java.util.EnumSet;

public class RegistraceForm {
    @NotBlank
    private String jmeno;
    @NotBlank
    private String prijmeni;
    @NotNull
    private LocalDate datumNarozeni;
    @NotNull
    private Pohlavi pohlavi;
    @NotNull
    private EnumSet<Sport> sporty;
    @NotNull
    private Integer turnus;
    @Email
    private String email;
    private Integer telefon;
    private Integer vek;

    public RegistraceForm() {
    }

    public RegistraceForm(@NotBlank String jmeno, @NotBlank String prijmeni, @NotNull LocalDate datumNarozeni, @NotNull Pohlavi pohlavi,
                          @NotNull EnumSet<Sport> sporty, @NotNull Integer turnus, @Email String email, Integer telefon) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
        this.pohlavi = pohlavi;
        this.sporty = sporty;
        this.turnus = turnus;
        this.email = email;
        this.telefon = telefon;
        setVek(datumNarozeni);
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

    public void setDatumNarozeni(LocalDate datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public Pohlavi getPohlavi() {
        return pohlavi;
    }

    public void setPohlavi(Pohlavi pohlavi) {
        this.pohlavi = pohlavi;
    }

    public EnumSet<Sport> getSporty() {
        return sporty;
    }

    public void setSporty(EnumSet<Sport> sporty) {
               this.sporty = sporty;
    }

    public Integer getTurnus() {
        return turnus;
    }

    public void setTurnus(Integer turnus) {
        this.turnus = turnus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefon() {
        return telefon;
    }

    public void setTelefon(Integer telefon) {
        this.telefon = telefon;
    }

    public Integer getVek() {
        return vek;
    }

    public void setVek(LocalDate datumNarozeni) {
        Period diff = Period.between(datumNarozeni, LocalDate.now()); //difference between the dates is calculated
        this.vek = diff.getYears();
    }
    //jméno (povinný údaj)
    //příjmení (povinný údaj)
    //datum narození (povinný údaj)
    //pohlaví (chlapec/dívka – povinný údaj)
    //zvolené sporty (např. plavání, běh, cyklistika, fotbal, basketbal – formou checkboxů)
    //turnus (např. 5. až 11. července, 12. až 18. července, 19. až 25. července – povinný údaj)
    //e-mail na rodiče (volitelný údaj)
    //telefon na rodiče (volitelný údaj)


}
