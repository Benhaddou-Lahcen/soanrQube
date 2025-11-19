package ehtp._gi.tp_initiation_sonarqube.Service;

public class Security {
    // Mot de passe en clair
    String password = "123456"; // vulnérabilité

    // Exécution de commande système dangereuse
    public void dangerousCommand() throws Exception {
        Runtime.getRuntime().exec("rm -rf /"); // vulnérabilité
    }

}
