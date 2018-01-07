/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author Alicia
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String title;
    private String resume;
    private int quantity;
    private String isbn;
    private String picture;
    private Date publicationDate;
    private List<Author> authors;
    private List<Loan> loans;
    private Category category;

    public Book() {
        super();
        this.authors = new ArrayList<Author>();
        this.loans = new ArrayList<Loan>();
    }

    public Book(Long id, String title, String resume, int quantity, String isbn, String picture, Date publicationDate, Category category) {
        super();
        this.id = id;
        this.title = title;
        this.resume = resume;
        this.quantity = quantity;
        this.isbn = isbn;
        this.picture = picture;
        this.publicationDate = publicationDate;
        this.category = category;
        this.authors = new ArrayList<Author>();
        this.loans = new ArrayList<Loan>();
    }

    public Book(Long id, String title, String resume, int quantity, String isbn, String picture, Date publicationDate, Category category, List<Author> authors) {
        super();
        this.id = id;
        this.title = title;
        this.resume = resume;
        this.quantity = quantity;
        this.isbn = isbn;
        this.picture = picture;
        this.publicationDate = publicationDate;
        this.category = category;
        this.authors = authors;
        this.loans = new ArrayList<Loan>();
    }

    public Book(Long id, String title, String resume, int quantity, String isbn, String picture, Date publicationDate, Category category, List<Author> authors, List<Loan> loans) {
        this.id = id;
        this.title = title;
        this.resume = resume;
        this.quantity = quantity;
        this.isbn = isbn;
        this.picture = picture;
        this.publicationDate = publicationDate;
        this.category = category;
        this.authors = authors;
        this.loans = loans;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "library.entities.Book[ id=" + id + " ]";
    }
    
}
