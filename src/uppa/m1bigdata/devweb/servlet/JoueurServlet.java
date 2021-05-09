package uppa.m1bigdata.devweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uppa.m1bigdata.devweb.dao.DAOException;
import uppa.m1bigdata.devweb.dao.JoueurDaoImpl;
import uppa.m1bigdata.devweb.pojo.Joueur;


/**
 * Servlet implementation class JoueurServlet
 */
@WebServlet(name = "JoueurServlet", urlPatterns = {"/"})
public class JoueurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    JoueurDaoImpl joueurDaoImpl=new JoueurDaoImpl();
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException, DAOException {
			        response.setContentType("text/html;charset=UTF-8");
			        PrintWriter out = response.getWriter();
			        String action = request.getParameter("action");
			        if (action.equals("afficher")){
			                  request.setAttribute("joueurs", joueurDaoImpl.getAll());            
			                  // forwarde la requÃªte Ã  la page JSP           
			                  request.getRequestDispatcher("/WEB-INF/views/listeJoueur.jsp")
			                          .forward(request,response);
			            }
			        else{
			        try {

			            // entÃªte du document + affichage du rectangle courant
			            out.println("<html>");
			            out.println("<head>");
			            out.println("<title>Test de Servlet : joueur</title>");
			            out.println("</head>");
			            out.println("<body>");
			            out.println("<h1>Servlet Joueur</h1>");
			            String nomJoueur = request.getParameter("nomJoueur");
			            String pseudo = request.getParameter("pseudo");
			            String pwd = request.getParameter("pwd");
			            int age=0;
			            if(request.getParameter("age")!="")
			                age = Integer.parseInt(request.getParameter("age"));
			            String sexe = request.getParameter("sexe");
			            String ville = request.getParameter("ville");

			            // crÃ©ation d'un rectangle
			            if (action.equals("creer")) {
			                Joueur joueur=new Joueur(nomJoueur, pseudo, pwd, age, sexe, ville);
			                joueurDaoImpl.create(joueur);
			                out.println("<p>Le joueur : "+joueur.getNomJoueur() + " a été bien créé</p>");
			            }

			            // dÃ©calage de rectangle
			            if (action.equals("modifier")) {
			               Joueur joueur=joueurDaoImpl.find(pseudo);
			               if (pwd!="")
			                   joueur.setPwd(pwd);
			               if(request.getParameter("age")!=""){
			                   age = Integer.parseInt(request.getParameter("age"));
			                   joueur.setAge(age);
			               }
			               if(sexe!="")
			                   joueur.setSexe(sexe);
			               joueurDaoImpl.update(joueur);
			               out.println("<p>Le joueur  : "+joueur.getNomJoueur() + " a été modifié </p>");
			                 out.println("</html>");
			            }

			            // calcul de surface du rectangle courant
			            if (action.equals("supprimer")) {
			                
			                   Joueur joueur=joueurDaoImpl.find(pseudo);
			                   joueurDaoImpl.delete(joueur);
			                   out.println("<p>Le joueur : "+joueur.getNomJoueur()+" a été supprimé</p>");
			                   out.println("</html>");

			            }
			            
			            
			            

			            }

			            // dÃ©calage de rectangle

			        catch (Exception e)
			        {
			             out.println("<p><b>Erreur !!</b><br />");
			             out.println(e.toString()+"</p>");
			        }
			      
			        // fin du document : lien pour retour en arriÃ¨re
			        out.println("<p><a href=\""+request.getContextPath()+"\">Retour</a></p>");
			        out.println("</body>");
			        out.println("</html>");
			        out.close();
			        }
			    } 

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            processRequest(request, response);
        } catch (DAOException ex) {
            Logger.getLogger(JoueurServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            processRequest(request, response);
        } catch (DAOException ex) {
            Logger.getLogger(JoueurServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

}
