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

	//bi-directional many-to-one association to Dé
	@ManyToOne
	@JoinColumn(name="idDés1")
	private Dé dé1;

	//bi-directional many-to-one association to Dé
	@ManyToOne
	@JoinColumn(name="idDés2")
	private Dé dé2;

	//bi-directional many-to-one association to Dé
	@ManyToOne
	@JoinColumn(name="idDés3")
	private Dé dé3;

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

	public Dé getDé1() {
		return this.dé1;
	}

	public void setDé1(Dé dé1) {
		this.dé1 = dé1;
	}

	public Dé getDé2() {
		return this.dé2;
	}

	public void setDé2(Dé dé2) {
		this.dé2 = dé2;
	}

	public Dé getDé3() {
		return this.dé3;
	}

	public void setDé3(Dé dé3) {
		this.dé3 = dé3;
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