package org.mbellange.tennisdream.domain.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.collect.Sets;

/**
 * Entité article
 * 
 * @author Mathieu
 *
 */
@Entity
public class Article extends PersistentEntity {
	
	@Transient
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tdPersistenceUnit");
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6884047428302503162L;
	
	public Article(){
		
	}
	
	public Article(String reference, String nom, String description, float price, Brand brand) {
		this.reference = reference;
		this.nom = nom;
		this.description = description;
		this.brand = brand;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="NOM", length=60)
	private String nom;
	
	@Column(name="REFERENCE", length=5)
	private String reference;
	
	@Column(name="PRICE",precision=5, scale=2)
	private float price;
	
	@Column(name="DESCRIPTION", length = 400)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="BRAND_ID")
	private Brand brand;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="article",optional=true)
	private Deal deal;

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="ARTICLE_ID")
	private Set<ArticleReview> articleReview = Sets.newHashSet();
	
	public Set<ArticleReview> getArticleReviews() {
		return articleReview;
	}

	public void setArticleReviews(Set<ArticleReview> articleReview) {
		this.articleReview = articleReview;
	}
	
	public Brand getMarque() {
		return brand;
	}

	public void setMarque(Brand brand) {
		this.brand = brand;
	}
	
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}
	
	public boolean addreview(ArticleReview articleReview){
		return this.articleReview.add(articleReview);
	}
	
	public Article findArticle(long id){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Article article = entityManager.find(Article.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return article;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, false);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
