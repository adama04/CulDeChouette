package uppa.m1bigdata.devweb.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the combinaison database table.
 * 
 */
@Entity
@NamedQuery(name="Combinaison.findAll", query="SELECT c FROM Combinaison c")
public class Combinaison implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCombinaison;

	private String nomCombinaison;

	private String typeCombinaison;

	//bi-directional many-to-one association to D�
	@ManyToOne
	@JoinColumn(name="idD�s1")
	private D� d�1;

	//bi-directional many-to-one association to D�
	@ManyToOne
	@JoinColumn(name="idD�s2")
	private D� d�2;

	//bi-directional many-to-one association to D�
	@ManyToOne
	@JoinColumn(name="idD�s3")
	private D� d�3;

	//bi-directional many-to-one association to Jouer
	@OneToMany(mappedBy="combinaison")
	private List<Jouer> jouers;

	public Combinaison() {
	}

	public int getIdCombinaison() {
		return this.idCombinaison;
	}

	public void setIdCombinaison(int idCombinaison) {
		this.idCombinaison = idCombinaison;
	}

	public String getNomCombinaison() {
		return this.nomCombinaison;
	}

	public void setNomCombinaison(String nomCombinaison) {
		this.nomCombinaison = nomCombinaison;
	}

	public String getTypeCombinaison() {
		return this.typeCombinaison;
	}

	public void setTypeCombinaison(String typeCombinaison) {
		this.typeCombinaison = typeCombinaison;
	}

	public D� getD�1() {
		return this.d�1;
	}

	public void setD�1(D� d�1) {
		this.d�1 = d�1;
	}

	public D� getD�2() {
		return this.d�2;
	}

	public void setD�2(D� d�2) {
		this.d�2 = d�2;
	}

	public D� getD�3() {
		return this.d�3;
	}

	public void setD�3(D� d�3) {
		this.d�3 = d�3;
	}

	public List<Jouer> getJouers() {
		return this.jouers;
	}

	public void setJouers(List<Jouer> jouers) {
		this.jouers = jouers;
	}

	public Jouer addJouer(Jouer jouer) {
		getJouers().add(jouer);
		jouer.setCombinaison(this);

		return jouer;
	}

	public Jouer removeJouer(Jouer jouer) {
		getJouers().remove(jouer);
		jouer.setCombinaison(null);

		return jouer;
	}

}