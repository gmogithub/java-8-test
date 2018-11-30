package annotation;

public class MyClass1 {

    @Todos(
            {
                    @Todo(auteur = "zozor",
                            niveau = NIVEAU.AMELIORATION,
                            description = "Tu ferais mieux d'utiliser un double...",
                            destinataire = "cysboy"),
                    @Todo(
                            description = "Utiliser l'annotation @SuppressWarning",
                            destinataire = "cysboy")
            }
    )
    private short entier = 0;

    @Todo(
            description = "Penser à faire les initialisations...",
            destinataire = "ssa"
    )
    public MyClass1() {
    }

    @Todos(
            {
                    @Todo(
                            description = "Qu'est-ce que c'est que cette méthode ?",
                            destinataire = "zozor",
                            niveau = NIVEAU.CRITIQUE)
            }
    )
    public void zozorEstPasseeParLa() {
    }
}
