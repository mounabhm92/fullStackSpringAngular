package Entities;

public class Etudiant {
	private int id;
	private String nom;
	private String Email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Etudiant(int id, String nom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		Email = email;
	}

	public Etudiant() {

	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", Email=" + Email + "]";
	}

}
