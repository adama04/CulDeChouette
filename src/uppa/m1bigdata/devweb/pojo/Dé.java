package uppa.m1bigdata.devweb.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dés database table.
 * 
 */
@Entity
@Table(name="dés")
@NamedQuery(name="Dé.findAll", query="SELECT d FROM Dé d")
public class Dé implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idDés;

	private String nomDés;

	private int valeurFace;

	//bi-directional many-to-one association to Combinaison
	@OneToMany(mappedBy="dé1")
	private List<Combinaison> combinaisons1;

	//bi-directional many-to-one association to Combinaison
	@OneToMany(mappedBy="dé2")
	private List<Combinaison> combinaisons2;

	//bi-directional many-to-one association to Combinaison
	@OneToMany(mappedBy="dé3")
	private List<Combinaison> combinaisons3;

	public Dé() {
	}

	public int getIdDés() {
		return this.idDés;
	}

	public void setIdDés(int idDés) {
		this.idDés = idDés;
	}

	public String getNomDés() {
		return this.nomDés;
	}

	public void setNomDés(String nomDés) {
		this.nomDés = nomDés;
	}

	public int getValeurFace() {
		return this.valeurFace;
	}

	public void setValeurFace(int valeurFace) {
		this.valeurFace = valeurFace;
	}

	public List<Combinaison> getCombinaisons1() {
		return this.combinaisons1;
	}

	public void setCombinaisons1(List<Combinaison> combinaisons1) {
		this.combinaisons1 = combinaisons1;
	}

	public Combinaison addCombinaisons1(Combinaison combinaisons1) {
		getCombinaisons1().add(combinaisons1);
		combinaisons1.setDé1(this);

		return combinaisons1;
	}

	public Combinaison removeCombinaisons1(Combinaison combinaisons1) {
		getCombinaisons1().remove(combinaisons1);
		combinaisons1.setDé1(null);

		return combinaisons1;
	}

	public List<Combinaison> getCombinaisons2() {
		return this.combinaisons2;
	}

	public void setCombinaisons2(List<Combinaison> combinaisons2) {
		this.combinaisons2 = combinaisons2;
	}

	public Combinaison addCombinaisons2(Combinaison combinaisons2) {
		getCombinaisons2().add(combinaisons2);
		combinaisons2.setDé2(this);

		return combinaisons2;
	}

	public Combinaison removeCombinaisons2(Combinaison combinaisons2) {
		getCombinaisons2().remove(combinaisons2);
		combinaisons2.setDé2(null);

		return combinaisons2;
	}

	public List<Combinaison> getCombinaisons3() {
		return this.combinaisons3;
	}

	public void setCombinaisons3(List<Combinaison> combinaisons3) {
		this.combinaisons3 = combinaisons3;
	}

	public Combinaison addCombinaisons3(Combinaison combinaisons3) {
		getCombinaisons3().add(combinaisons3);
		combinaisons3.setDé3(this);

		return combinaisons3;
	}

	public Combinaison removeCombinaisons3(Combinaison combinaisons3) {
		getCombinaisons3().remove(combinaisons3);
		combinaisons3.setDé3(null);

		return combinaisons3;
	}

}