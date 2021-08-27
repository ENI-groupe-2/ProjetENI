package fr.eni.enchere.bo;

public class Retrait {
	String rue;
	String codePostal;
	String ville;
	int no_article;
	
	
	
	public int getNo_article() {
		return no_article;
	}
	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	public Retrait(String rue, String codePostal, String ville) {
	
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;	
}
	
	public Retrait(int noArticle, String rue, String codePostal, String ville) {
		super();
		this.no_article = noArticle;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public Retrait() {
		// Coucou c'est vide :)
	}
	
}